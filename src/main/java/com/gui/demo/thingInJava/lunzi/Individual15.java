package com.gui.demo.thingInJava.lunzi;

/**
 * @Classname Individual15
 * @Description TODO
 * @Date 2021/4/26 16:14
 * @Created by gt136
 */
public class Individual15 implements Comparable<Individual15> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    public Individual15(String name) { this.name = name; }
    // 'name' is optional:
    public Individual15() {}
    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }
    public long id() { return id; }
    public boolean equals(Object o) {
        return o instanceof Individual15 &&
                id == ((Individual15)o).id;
    }
    public int hashCode() {
        int result = 17;
        if(name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int)id;
        return result;
    }
    public int compareTo(Individual15 arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0)
            return firstCompare;
        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
