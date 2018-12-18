package TestObjects;

import XML.XmlObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Name name = new Name("Alex");
        System.out.println(name.getName());
        Class classObject = name.getClass();
        for (Field field :classObject.getDeclaredFields()) {
            System.out.println(field);
        }
        for (Method method :classObject.getDeclaredMethods()) {
            System.out.println(method);
        }
        FullName fullName = new FullName("Alex");
        System.out.println(fullName.getName());
        Class clasObject = fullName.getClass();
        for (Field field :clasObject.getDeclaredFields()) {
            System.out.println(field);
        }
        for (Method method :clasObject.getDeclaredMethods()) {
            System.out.println(method);
        }
        System.out.println("Parrent class");
        Class clazObject = fullName.getClass().getSuperclass();
        for (Field field : clazObject.getDeclaredFields())
            System.out.println(field);
        for (Method method :clazObject.getDeclaredMethods())
            System.out.println(method);
    }
}
