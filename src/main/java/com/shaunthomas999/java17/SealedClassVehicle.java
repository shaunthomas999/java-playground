package com.shaunthomas999.java17;

/**
 * Ref: Google drive doc
 */
public sealed class SealedClassVehicle permits Car, Truck {
  private String brand;

  public SealedClassVehicle(String brand) {
    this.brand = brand;
  }

  public String getBrand() {
    return brand;
  }
}

final class Car extends SealedClassVehicle {
  private int numberOfDoors;

  public Car(String brand, int numberOfDoors) {
    super(brand);
    this.numberOfDoors = numberOfDoors;
  }

  public int getNumberOfDoors() {
    return numberOfDoors;
  }
}

final class Truck extends SealedClassVehicle {
  private double cargoCapacity;

  public Truck(String brand, double cargoCapacity) {
    super(brand);
    this.cargoCapacity = cargoCapacity;
  }

  public double getCargoCapacity() {
    return cargoCapacity;
  }
}

