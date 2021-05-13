package com.gui.demo.thingInJava.RTTI;

import com.gui.demo.thingInJava.RTTI.pets.*;
import com.gui.demo.thingInJava.RTTI.pets.EgyptianMau;
import com.gui.demo.thingInJava.RTTI.pets.Mutt;
import com.gui.demo.thingInJava.RTTI.pets.Pug;

import java.util.*;

/*
  *@Classname RegisteredPetFactory
  @Description TODO
  @Date 2021/4/26 14:24
  @Created by gt136
 */
class RegisteredPetFactories15 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(PetFactory.createRandom());
    }
}


/* Solution includes rewrite of base-class, Individual15, to extend PetFactory
  and changes to methods in Pets and PetCreator:
  // typeinfo/pets/Individual15.java
  // for use in solution to Ex 15, page 586*/

class PetFactory {
    public String toString() {
        return getClass().getSimpleName();
    }

    // 	static List<Factory<? extends Pet>> petFactories;
// 	static {
// 		petFactories = Arrays.asList(new Manx.Factory(),new EgyptianMau.Factory(),new Hamster.Factory(),new Manx.Factory()
//		, new Mouse.Factory(),new Mutt.Factory(),new Pug.Factory(),new Rat.Factory());
// 	}
    static List<Class<? extends Pet>> petFactories =
            new ArrayList<>();

    static {
        petFactories.add(Manx.class);
        petFactories.add(EgyptianMau.class);
        petFactories.add(Hamster.class);
        petFactories.add(Mouse.class);
        petFactories.add(Mutt.class);
        petFactories.add(Pug.class);
        petFactories.add(Rat.class);
    }

    private static Random rand = new Random();

    public static Pet createRandom() {
        int n = rand.nextInt(petFactories.size());
        try {
            return petFactories.get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Individual15 extends PetFactory implements Comparable<Individual15> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual15(String name) {
        this.name = name;
    }

    // 'name' is optional:
    public Individual15() {
    }

    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    public boolean equals(Object o) {
        return o instanceof Individual15 &&
                id == ((Individual15) o).id;
    }

    public int hashCode() {
        int result = 17;
        if (name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int) id;
        return result;
    }

    public int compareTo(Individual15 arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0)
            return firstCompare;
        if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}

// typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.

class LiteralPetCreator1 extends PetCreator {
    // No try block needed.
	/*public static final List<Class<?>> allTypes =
			Collections.unmodifiableList(Arrays.asList(
					Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
					Cymric.class, Rat.class, Mouse.class,Hamster.class));*/
    static List<Class<? extends Pet>> petFactories =
            new ArrayList<>();

    static {
        petFactories.add(Manx.class);
        petFactories.add(EgyptianMau.class);
        petFactories.add(Hamster.class);
        petFactories.add(Mouse.class);
        petFactories.add(Mutt.class);
        petFactories.add(Pug.class);
        petFactories.add(Rat.class);
    }

    // Types for random creation:
    public List<Class<? extends Pet>> types() {
        return petFactories;
    }

    public static void main(String[] args) {
        System.out.println(petFactories);
    }
}

class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator1();

    public static Pet randomPet() { // new method version
        return PetFactory.createRandom();
    }

    // older method version:
    // public static Pet randomPet() {
    //	return creator.randomPet();
    // }
    //
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}

// typeinfo/pets/PetCreator.java
// Creates random sequence of pets


//  public abstract class PetCreator {
// 	private Random rand = new Random();
// 	// The List of the different types of Pet to create:
// 	public abstract List<Class<? extends Pet>> types();
//
// 	public Pet randomPet() { // newer method, using PetFactory
// 		return PetFactory.createRandom();
// 	}

// older, first method:
// public Pet randomPet() { // Create one random Pet
//	int n = rand.nextInt(types().size());
//	try {
//		return types().get(n).newInstance();
//	} catch(InstantiationException e) {
//		throw new RuntimeException(e);
//	} catch(IllegalAccessException e) {
//		throw new RuntimeException();
//	}
// }

// 	public Pet[] createArray(int size) {
// 		Pet[] result = new Pet[size];
// 		for(int i = 0; i < size; i++)
// 			result[i] = randomPet();
// 		return result;
// 	}
// 	public ArrayList<Pet> arrayList(int size) {
// 		ArrayList<Pet> result = new ArrayList<Pet>();
// 		Collections.addAll(result, createArray(size));
// 		return result;
// 	}
