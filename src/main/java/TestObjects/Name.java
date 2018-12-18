package TestObjects;

import XML.XmlObject;
import XML.XmlTag;

@XmlObject
public class Name {
    @XmlTag(name = "not T")
    String name;
    public Name(String name) {
        this.name = name;
    }
    @XmlTag(name = "lol")
    public String getName() {
        return name;
    }
}
