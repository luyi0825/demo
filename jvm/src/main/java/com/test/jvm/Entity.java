package com.test.jvm;

/**
 * @author Administrator
 */
public class Entity implements Cloneable {
    private long x;
    private String name;
    private String age;

    @Override
    protected Entity clone() throws CloneNotSupportedException {
        return (Entity) super.clone();
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
