//: typeinfo/pets2/Mouse.java
package com.gui.demo.thingInJava.RTTI.pets;

import com.gui.demo.thingInJava.RTTI.Cat;

public class Mouse extends Cat {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<Mouse> {
    public Mouse create() { return new Mouse(); }
  }
} ///:~
