package com.gui.demo.thingInJava.RTTI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname LiteralPetCountor
 * @Description TODO
 * @Date 2021/4/22 10:43
 * @Created by gt136
 */
public class LiteralPetCountor extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Mutt.class, Pug.class, EgyptianMau.class, Cymric.class));

    public static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
    public List<Class<? extends Pet>> types(){
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
