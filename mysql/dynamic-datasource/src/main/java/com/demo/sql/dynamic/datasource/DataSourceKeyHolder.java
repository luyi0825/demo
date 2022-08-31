package com.demo.sql.dynamic.datasource;

public class DataSourceKeyHolder {

    private static ThreadLocal<String> ds = new ThreadLocal<>();

    public static void set(String key) {
        ds.set(key);
    }

    public static String get() {
        return ds.get();
    }

    public static void remove() {
        ds.remove();
    }

}
