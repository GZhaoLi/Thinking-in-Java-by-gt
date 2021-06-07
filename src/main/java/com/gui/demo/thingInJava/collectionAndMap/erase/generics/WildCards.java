package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import com.gui.demo.thingInJava.collectionAndMap.Holder;

/**
 * @Classname WildCards
 * @Description TODO
 * @Date 2021/6/3 10:00
 * @Created by gt136
 */
public class WildCards {
    static void rawArgs(Holder holder, Object obj) {
        /**
         * 编译器知道Holder是一个泛型类型，即使它在这里被表示成一个原生类型
         */
        //警告：
//        holder.setA(obj);
        Object object = holder.getA();
    }

    /**
     * 可能会觉得原生 Holder 和 Holder<?> 是大致相同的事物，但是这个方法却证明它们是不一样的，上一例警告，这里直接报错
     * 原生 Holder 可以持有任何类型的事物，而 Holder<?> 将持有具有某种具体类型的同构集合，因此不能像其中只是单纯的传递Object。
     * @param holder
     * @param arg
     */
    static void unboundedArg(Holder<?> holder, Object arg) {
        //编译报错,这里是报错和上面的方法不一样
//        holder.setA(arg);
    }

    /**
     * 这个例子和下个例子都使用了泛型的确切类型，没有任何通配符。
     * @param holder
     * @param <T>
     * @return
     */
    static <T> T exact1(Holder<T> holder) {
        return holder.getA();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setA(arg);
        return holder.getA();
    }

    /**
     * 在Holder 类型上的限制被放松为包括持有任何拓展自：包括持有任何拓展自T对象的Holder。也是具体类型的，当指定一种类型后，就不可以再向其中
     * 随意插入数据
     * @param holder
     * @param arg
     * @param <T>
     * @return
     */
    //包括持有任何扩展自 T 的对象的 Holder
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //编译报错，必须是T的子类型
//        holder.setA(arg);

        return holder.getA();
    }

    /**
     * 这个和上一个完全相反，holder是任何持有任何T类型的基类型的容器。
     * @param holder
     * @param arg
     * @param <T>
     */
    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.setA(arg);
    }

    public static void main(String[] args) {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long l = 1L;

        rawArgs(raw, l);
        rawArgs(qualified, l);
        rawArgs(unbounded, l);
        rawArgs(bounded, l);

        unboundedArg(raw, l);
        unboundedArg(qualified, l);
        unboundedArg(unbounded, l);
        unboundedArg(bounded, l);

        //报警告：
//        Object o = exact1(raw);
        Long r2 = exact1(qualified);
        //必须返回object
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        //报警告
//        Long r5 = exact2(raw, l);
        Long r6 = exact2(qualified, l);
        //报错：: no instance(s) of type variable(s) exist so that Long conforms to capture of ? inference variable T has incompatible bounds: equality constraints: capture of ? lower bounds: Long
//        Long r7 = exact2(unbounded, l);
        //报错：equality constraints: capture of ? extends Long lower bounds: Long
//        Long r8 = exact2(bounded, l);

        //警告Unchecked assignment: 'Holder' to 'Holder<? extends java.lang.Long>'
//        Long r9 = wildSubtype(raw, l);
        Long r10 = wildSubtype(qualified, l);
        Object r11 = wildSubtype(unbounded, l);
        Long r12 = wildSubtype(bounded, l);

        //警告： [unchecked] unchecked method invocation:required: Holder<? super T>,T；found: Holder,Long
//        wildSuperType(raw,l);
        wildSuperType(qualified,l);
        //编译报错：no instance(s) of type variable(s) exist so that Long conforms to capture of ?
//        wildSuperType(unbounded,l);
        //报错
//        wildSuperType(bounded,l);
    }
}