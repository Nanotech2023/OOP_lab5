package TestObjects;

import XML.XmlAttribute;
import XML.XmlObject;
import XML.XmlTag;

@XmlObject(message = "Hello world")
public class Person7 {

    @XmlTag(name = "fullname")
    private Name name;

    @XmlAttribute(tag = "fullname")
    private String lang;

    @XmlAttribute(tag = "name")
    private int age;

    public Person7(String name, String lang, int age) {
        this.name = new FullName(name);
        this.lang = lang;
        this.age = age;
    }
    public Name getName() {
        return name;
    }

    @XmlTag(name = "name")
    private int getAge() {
        return age;
    }
}
