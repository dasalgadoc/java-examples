package com.dsalgado.examples;

public class FieldsExample {
  private String nombre;
  private String edad;
  private boolean mayorEdad;

  private Long userId;

  public FieldsExample(String nombre, String edad, boolean mayorEdad) {
    this.nombre = nombre;
    this.edad = edad;
    this.mayorEdad = mayorEdad;
  }

  public FieldsExample(String nombre, String edad, boolean mayorEdad, Long userId) {
    this.nombre = nombre;
    this.edad = edad;
    this.mayorEdad = mayorEdad;
    this.userId = userId;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEdad() {
    return edad;
  }

  public void setEdad(String edad) {
    this.edad = edad;
  }

  public boolean isMayorEdad() {
    return mayorEdad;
  }

  public void setMayorEdad(boolean mayorEdad) {
    this.mayorEdad = mayorEdad;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
