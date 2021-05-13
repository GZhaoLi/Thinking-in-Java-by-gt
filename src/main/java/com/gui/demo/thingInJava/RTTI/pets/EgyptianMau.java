//: typeinfo/pets2/EgyptianMau.java
package com.gui.demo.thingInJava.RTTI.pets;


import com.gui.demo.thingInJava.RTTI.Cat;

public class EgyptianMau extends Cat {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<EgyptianMau> {
    public EgyptianMau create() { 
      return new EgyptianMau(); 
    }
  }
} ///:~
