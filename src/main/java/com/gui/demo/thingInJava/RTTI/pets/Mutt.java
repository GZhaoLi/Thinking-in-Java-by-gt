//: typeinfo/pets2/Mutt.java
package com.gui.demo.thingInJava.RTTI.pets;

import com.gui.demo.thingInJava.RTTI.Dog;
import com.gui.demo.thingInJava.RTTI.Factory;

public class Mutt extends Dog {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<Mutt> {
    public Mutt create() { return new Mutt(); }
  }
} ///:~
