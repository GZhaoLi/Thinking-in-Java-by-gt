package com.gui.demo.thingInJava.RTTI;

import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup;

import java.util.*;

/**
 * @Classname PetCount3
 * @Description TODO
 * @Date 2021/4/22 10:56
 * @Created by gt136
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{

        public PetCounter(){
            super();
        }

        public void count(Pet pet, Map<Class<? extends Pet>, Integer> map) {

            for (Map.Entry<Class<? extends Pet>, Integer> pair : map.entrySet()) {
                if (pair.getKey().isInstance(pet))
                    map.put(pair.getKey(), pair.getValue() + 1);
            }
        }
        public String toString(){
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            if (result.length() >= 2)
            result.delete(result.length() - 2, result.length()-1);
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        LiteralPetCountor creator = new LiteralPetCountor();
        List<Class<? extends Pet>> list = LiteralPetCountor.types;
        Map<Class<? extends Pet>, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i),0);
        }

        for (Pet pet : creator.arrayList(10)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCounter.count(pet,map);
        }
        System.out.println();
        System.out.println(petCounter);
    }
}
