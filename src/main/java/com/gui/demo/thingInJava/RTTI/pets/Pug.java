package com.gui.demo.thingInJava.RTTI.pets;

import com.gui.demo.thingInJava.RTTI.Dog;

public class Pug extends Dog {
  public static class Factory
  implements com.gui.demo.thingInJava.RTTI.Factory<Pug> {
    public Pug create() { return new Pug(); }
  }
}
