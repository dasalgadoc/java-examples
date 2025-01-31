package com.dsalgado.examples.cypher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESGCMVanillaCypher implements Cypher {

  // Si se comparte estos parametros entre apis se puede interoperar
  private static final String KEY_FILE_PATH = "./aes-gcm-key.bin";
  private static final int AES_KEY_SIZE = 256;
  private static final int GCM_IV_LENGTH = 12;
  private static final int GCM_TAG_LENGTH = 128;

  private SecretKey secretKey;

  public AESGCMVanillaCypher() {
    secretKey = loadOrGenerateKey();
  }

  @Override
  public boolean isEncrypted(String text) {

    return false;
  }

  @Override
  public String encrypt(String plainText) {

    try {
      // 1. Crear el objeto Cipher con el algoritmo AES/GCM/NoPadding
      // GCM autenticación e integridad de datos y NoPadding indica que no se agregará ningún
      // relleno
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

      // 2. Crear un vector de inicialización (IV) con números aleatorios seguros.
      // El IV será Nonce (número usado una sola vez) y se enviará junto con el texto cifrado.
      // Este número se usa para evitar ataques de repetición, aumentando la seguridad y la
      // aleatoriedad de los datos cifrados.
      SecureRandom secureRandom = new SecureRandom();
      byte[] iv = new byte[GCM_IV_LENGTH];
      secureRandom.nextBytes(iv);
      // 12 bytes para GCM - 96 bits: El tamaño de 12 bytes aplicado a todas las api, permite
      // interoperabilidad

      // 3. Aplicar un tag de autenticación al cifrado.
      // El tag se genera automáticamente durante el cifrado y se verifica durante el descifrado.
      // Auth tag o GCM tag para fortalecer la integridad de los datos cifrados

      GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);

      // 4. Cifrar el texto IV + Ciphertext + Tag.
      // El IV se envía sin cifrar junto con el texto cifrado para que el receptor pueda
      // descifrarlo.
      byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

      // 5. Concatenar IV + Ciphertext + Tag en un solo array de bytes.
      byte[] combined = new byte[iv.length + encryptedBytes.length];
      System.arraycopy(iv, 0, combined, 0, iv.length);
      System.arraycopy(encryptedBytes, 0, combined, iv.length, encryptedBytes.length);

      // 6. Codificar el array de bytes combinado en Base64 para facilitar el almacenamiento y la
      // transmisión.
      return Base64.getEncoder().encodeToString(combined);

    } catch (NoSuchAlgorithmException
        | NoSuchPaddingException
        | InvalidAlgorithmParameterException
        | InvalidKeyException
        | IllegalBlockSizeException
        | BadPaddingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String decrypt(String text) {
    // 1. Decodificar el texto cifrado de Base64 a un array de bytes.
    byte[] combined = Base64.getDecoder().decode(text);

    // 2. Separar el IV del texto cifrado.
    byte[] iv = Arrays.copyOfRange(combined, 0, GCM_IV_LENGTH);
    byte[] encryptedBytes = Arrays.copyOfRange(combined, GCM_IV_LENGTH, combined.length);

    // 3. Configurar el cipher. Crear un objeto GCMParameterSpec con el IV.
    Cipher cipher = null;
    try {
      cipher = Cipher.getInstance("AES/GCM/NoPadding");
    } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
      throw new RuntimeException(e);
    }

    GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
    try {
      cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);
    } catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
      throw new RuntimeException(e);
    }

    // 4. Descifrar el texto cifrado.
    try {
      byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
      return new String(decryptedBytes);
    } catch (IllegalBlockSizeException | BadPaddingException e) {
      throw new RuntimeException(e);
    }
  }

  private SecretKey loadOrGenerateKey() {
    Path path = Paths.get(KEY_FILE_PATH);
    if (Files.exists(path)) {
      return readKey();
    }

    return generateAndPersistKey(path);
  }

  private SecretKey readKey() {
    try {
      String encodedKey = Files.readString(Paths.get(KEY_FILE_PATH));
      byte[] keyBytes = Base64.getDecoder().decode(encodedKey);

      return new SecretKeySpec(keyBytes, "AES");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private SecretKey generateAndPersistKey(Path path) {
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
      keyGenerator.init(AES_KEY_SIZE, new SecureRandom());
      SecretKey key = keyGenerator.generateKey();
      saveKey(key, path);

      return key;
    } catch (NoSuchAlgorithmException | RuntimeException e) {
      throw new RuntimeException(e);
    }
  }

  private void saveKey(SecretKey key, Path path) {
    try {
      String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
      Files.write(path, encodedKey.getBytes(), StandardOpenOption.CREATE);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
