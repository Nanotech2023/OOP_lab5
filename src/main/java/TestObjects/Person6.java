package TestObjects;

import XML.XmlAttribute;
import XML.XmlObject;
import XML.XmlTag;

@XmlObject(message = "Hello world")
public class Person6 {

    @XmlTag(name = "fullname")
    private Name name;

    @XmlAttribute(tag = "fullname")
    private String lang;

    @XmlAttribute(tag = "fullname")
    private int age;

    public Person6(String name, String lang, int age) {
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
