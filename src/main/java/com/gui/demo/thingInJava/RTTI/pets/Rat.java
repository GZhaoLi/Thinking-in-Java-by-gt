//: typeinfo/pets2/Rat.java
package com.gui.demo.thingInJava.RTTI.pets;

import com.gui.demo.thingInJava.RTTI.Cat;
import com.gui.demo.thingInJava.RTTI.Factory;

public class Rat extends Cat {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<Rat> {
    public Rat create() { return new Rat(); }
  }
} ///:~
