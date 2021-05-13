package com.gui.demo.thingInJava.interface1;/**
 * @Classname Factories
 * @Description TODO
 * @Date 2021/3/21 23:10
 * @Created by gt136
 */

/**
 * @Classname Factories
 * @Description 工厂方法
 * @Date 2021/3/21 23:10
 * @Created by gt
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory fact){
        Service s = fact.getService();
        s.method();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}
interface Service{
    void method();
}

interface ServiceFactory{
    Service getService();
}
class Implementation1 implements Service{
    Implementation1(){
    }

    @Override
    public void method() {
        System.out.println("Implementation1 method");
    }
}

class Implementation1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class implementation2 implements Service {
    implementation2() {
    }

    @Override
    public void method() {
        System.out.println("Implementation2 method");
    }
}

class Implementation2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new implementation2();
    }
}

