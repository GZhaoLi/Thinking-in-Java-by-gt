package com.gui.demo.thingInJava.lunzi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ThrowGenericException
 * @Description 泛型异常
 * @Date 2021/6/4 15:29
 * @Created by gt136
 */
//定义一个泛型接口，这个接口里传入你要操作的集合和接受这个集合抛出的异常
interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}
/**
 * 这个类继承了带了限制的ArrayList，且这个类自己也实现了泛型限定，在其中实现了processAll() 方法，这个方法将调用Processor接口中的方法，
 * 但是因为没有实现Processor接口，所以并不需要去重写它的方法。
 *      可以这样理解：这整个程序先定义了一个接口，然后有其他实现接口的类，然后这些类因为有共性，所以可以用一个通用的模型来操作它们：ProcessRunner
 */
class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception{}

class Process1 implements Processor<String, Failure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        //**这里我忘记了，当在做这一步的判断的时候，count的值就已经被变化了！！！！，所以循环三次这个正好没有报错
        if (count-- > 3) {
            resultCollector.add("Hep!");
        } else resultCollector.add("Ho!");
        if (count < 0) throw new Failure1();
    }
}

class Failure2 extends Exception{}

class Process2 implements Processor<Integer, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        //而这个正好就在循环第三次的时候报错了！！！
        if (count-- == 0) {
            resultCollector.add(47);
        } else{
            resultCollector.add(11);//这里的添加操作因为有动态判断，赋值正确是不会走异常抛出的
        }
        if (count < 0) {
            throw new Failure2();
        }
    }
}
public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            //因为ProcessRunner继承了ArrayList，所以可以调用这些方法
            runner.add(new Process1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 failure1) {
            System.out.println(failure1);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Process2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 failure2) {
            System.out.println(failure2);
        }
    }
}
/*
output:
[Ho!, Ho!, Ho!]
Failure2
 */
