//: typeinfo/pets2/Hamster.java
package com.gui.demo.thingInJava.RTTI.pets;


import com.gui.demo.thingInJava.RTTI.Dog;
import com.gui.demo.thingInJava.RTTI.Factory;

public class Hamster extends Dog {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<Hamster> {
    public Hamster create() { return new Hamster(); }
  }
} ///:~
