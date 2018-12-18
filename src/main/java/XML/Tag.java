package XML;

import java.util.HashMap;

public class Tag {
    private String name;
    private String value;
    HashMap<String, Attribute> attributes;
    public Tag (String name, String value) {
        this.name = name;
        this.value = value;
        attributes = new HashMap<String, Attribute>();
    }
    public void insertAttribute(Attribute attribute) throws Exception{
        if (attributes.containsKey(attribute.getName())) {
            throw new DuplicateNameException(attribute.toString());
        }
        else {
            attributes.put(attribute.getName(),attribute);
        }
    }

    public String toXml() {
        String result = "<" + name + " ";
        for (Attribute i : attributes.values()) {
            result += i.getName() + "=\"" + i.getValue() + "\" ";
        }
        return result.substring(0, result.length()-1) + ">\n  " + value + "\n</" + name + ">\n";
    }
}
