//: typeinfo/pets2/Manx.java
package com.gui.demo.thingInJava.RTTI.pets;

import com.gui.demo.thingInJava.RTTI.Cat;
import com.gui.demo.thingInJava.RTTI.Factory;

public class Manx extends Cat {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<Manx> {
    public Manx create() { return new Manx(); }
  }
} ///:~
