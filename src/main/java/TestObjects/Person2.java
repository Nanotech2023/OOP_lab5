package TestObjects;

import XML.XmlAttribute;
import XML.XmlObject;
import XML.XmlTag;

@XmlObject(message = "Hello world")
public class Person2 {

    @XmlTag(name = "fullname")
    private Name name;

    @XmlAttribute(tag = "fullname")
    private String lang;

    private int age;

    public Person2(String name, String lang, int age) {
        this.name = new Name(name);
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
