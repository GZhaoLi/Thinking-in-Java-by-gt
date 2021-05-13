package com.gui.demo.thingInJava.RTTI;

import java.util.HashMap;

/**
 * @Classname PetCount
 * @Description TODO
 * @Date 2021/4/21 15:19
 * @Created by gt136
 */
public class PetCount extends HashMap<String, Integer> {
    public void count(String type) {
        Integer quantity = get(type);
        if (quantity == null) {
            put(type, 1);
        } else put(type, quantity + 1);
    }

    public static void countPets(PetCreator petCreator) {
        PetCount count = new PetCount();
        for (Pet pet : petCreator.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) count.count("Pet");
            if (pet instanceof Dog) count.count("Dog");
            if (pet instanceof Mutt) count.count("Mutt");
        }
        System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
/*
输出：
EgyptianMau Mutt EgyptianMau Pug Pug Cymric EgyptianMau Mutt Cat Cat EgyptianMau EgyptianMau Pug Cymric Cymric EgyptianMau EgyptianMau Pug Mutt EgyptianMau
{Mutt=3, Dog=7, Pet=20}
 */