package com.dsalgado.examples.cypher;

public interface Cypher {
  boolean isEncrypted(String text);

  String encrypt(String text);

  String decrypt(String text);
}
