//: typeinfo/pets2/Pets.java
// Facade to produce a default PetCreator.
package com.gui.demo.thingInJava.RTTI.pets;
import com.gui.demo.thingInJava.RTTI.Factory;
import com.gui.demo.thingInJava.RTTI.Pet;
import com.gui.demo.thingInJava.RTTI.PetCreator;

import java.util.*;

@SuppressWarnings("unchecked")
public class Pets {
  private static class RFPetCreator extends PetCreator {
    /*static List<Factory<? extends Pet>> petFactories =
      Arrays.asList(new Mutt.Factory(), new Pug.Factory(),
        new EgyptianMau.Factory(), new Manx.Factory(),
         new Cymric.Factory(), new Rat.Factory(),
         new Mouse.Factory(), new Hamster.Factory());*/
    static List<Factory<? extends Pet>> petFactories =
            new ArrayList<>();
    static {
      petFactories.add((Factory<? extends Pet>) new Manx.Factory());
      petFactories.add(new EgyptianMau.Factory());
      petFactories.add(new Hamster.Factory());
      petFactories.add((Factory<? extends Pet>) new Manx.Factory());
      petFactories.add(new Mouse.Factory());
      petFactories.add(new Mutt.Factory());
      petFactories.add(new Pug.Factory());
      petFactories.add(new Rat.Factory());
    }
    @Override
    public List<Class<? extends Pet>> types() {
      return null;  // Dummy value, this method is not used!
    }
    @Override
    public Pet randomPet() { // Make 1 random Pet
      int n = rand.nextInt(petFactories.size());
      return petFactories.get(n).create();
    }  
  }
  private static Random rand = new Random(47);
  public static final PetCreator creator = 
    new RFPetCreator();
  public static Pet randomPet() { 
    return creator.randomPet(); 
  }
  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
} ///:~
