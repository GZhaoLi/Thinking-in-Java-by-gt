package com.gui.demo.thingInJava.collectionAndMap;

import com.gui.demo.thingInJava.lunzi.Generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Classname Store
 * @Description TODO
 * @Date 2021/5/13 9:23
 * @Created by gt136
 */
class Product{
    private final int id;
    private String description;
    private double price;
    public Product(int IDNumber, String desc, double price){
        id = IDNumber;
        description = desc;
        this.price = price;
        System.out.println("1:"+toString());
    }
    public String toString(){
        return id + ": "+ description+".price:￥"+price;
    }

    public void changePrice(double change) {
        price += change;
    }
    public static Generator<Product> generator =
         () -> {
            Random rand = new Random();
            return new Product(rand.nextInt(10), "Test", Math.round(rand.nextDouble() * 1000.0)+0.99);
        };

}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}
class Aisle extends ArrayList<Shelf>{
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}
class CheckoutStand{}
class Office{}

public class Store extends ArrayList<Aisle> {
    private List<CheckoutStand> checkouts = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisle, int nShelf, int nProducts) {
        for (int i = 0; i < nAisle; i++) {
            add(new Aisle(nShelf,nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    sb.append(p);
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 5, 5));
    }
}
