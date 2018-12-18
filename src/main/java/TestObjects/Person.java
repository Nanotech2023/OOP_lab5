package TestObjects;

import XML.*;

@XmlObject(message = "Hello world")
public class Person {

    @XmlTag(name = "fullname")
    private Name name;

    @XmlAttribute(tag = "fullname")
    private String lang;

    private int age;

    public Person(String name, String lang, int age) {
        this.name = new FullName(name);
        this.lang = lang;
        this.age = age;
    }
    public Name getName() {
        return name;
    }

    @XmlTag
    private int getAge() {
        return age;
    }
}
