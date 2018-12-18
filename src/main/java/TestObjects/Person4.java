package TestObjects;

import XML.XmlAttribute;
import XML.XmlObject;
import XML.XmlTag;

@XmlObject(message = "Hello world")
public class Person4 {

    @XmlTag(name = "fullname")
    private Name name;

    @XmlAttribute(tag = "fullname")
    private String lang;

    private int age;

    public Person4(String name, String lang, int age) {
        this.name = new Name(name);
        this.lang = lang;
        this.age = age;
    }
    public Name getName() {
        return name;
    }

    @XmlTag(name = "fullname")
    private void getAge() {

    }
}
