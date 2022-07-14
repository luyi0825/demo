package com.test.jvm;

/**
 * @author Administrator
 */
public class Entity implements Cloneable {
    private String name;
    private String age;

    @Override
    protected Entity clone() throws CloneNotSupportedException {
        return (Entity) super.clone();
    }
}
