package com.gui.demo.thingInJava.collectionAndMap;

import java.util.*;

/**
 * @Classname BankTeller
 * @Description 简单银行出纳员模拟类
 * @Date 2021/5/12 10:15
 * @Created by gt136
 */
class Customer{
    private static long count = 0;
    private final long id = count++;
    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + '}';
    }

    //生成器方法
    public static Generator<Customer> generator(){
//        return Customer::new;
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller{
    private static long count = 0;
    private final long id = count++;
    private Teller(){}

    @Override
    public String toString() {
        return "Teller{" + "id=" + id + '}';
    }

    //
//    public static Generator<Teller> generator(){
//        return Teller::new;
//    }
    public static Generator<Teller> generator = Teller::new;
}
public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);

        Queue<Customer> queue = new LinkedList<>();
        Generators.fill(queue, Customer.generator(),5);

        List<Teller> list = new ArrayList<>();
        Generators.fill(list, Teller.generator, 5);

        for (Customer c : queue) {
            serve(list.get(rand.nextInt(list.size())),c);
        }
    }
}
/*
shuchu :
Teller{id=3} serves Customer{id=0}
Teller{id=0} serves Customer{id=1}
Teller{id=3} serves Customer{id=2}
Teller{id=1} serves Customer{id=3}
Teller{id=1} serves Customer{id=4}
 */