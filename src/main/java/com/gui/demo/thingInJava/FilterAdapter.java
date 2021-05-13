package com.gui.demo.thingInJava;


import java.util.Arrays;

/**
 * @Classname FilterAdapter
 * @Description 复用代码的第一种方式是客户端程序员遵循该接口来编写他们自己的类
 * @Date 2021/3/17 21:25
 * @Created by gt136
 */
public class FilterAdapter implements ProcessorI {
    Filter filter;

    public FilterAdapter(LowPass filter) {
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}
class Waveform{
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return "Waveform" + id;
    }
}
class Filter{
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){
        return input;
    }
}

class LowPass extends Filter{
    double aDouble;
    public LowPass(double aDouble) {
        this.aDouble = aDouble;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
class FilterProcessor{
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
    }
}
