package XML;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class XmlParser {
    private static String iteration(AccessibleObject object) throws Exception{
        String result = "";
        XmlTag annotationTag = (XmlTag) object.getAnnotation(XmlTag.class);
        if (annotationTag != null) {
            result += annotationTag + ";";
        }
        else {
            XmlAttribute annotationAttr = (XmlAttribute) object.getAnnotation(XmlAttribute.class);
            if (annotationAttr != null) {
                result += annotationAttr + ";";
            }
        }
        return result;

    }
    private static String makingXml(String string) throws Exception{
        String[] firstSplit = string.split(":");
        String[] secondSplit = firstSplit[1].split(";");
        String result = firstSplit[0] + "\n";
        HashMap<String, Tag> tags = new HashMap<String, Tag>();
        HashMap<String, Attribute> attributes = new HashMap<String, Attribute>();
        for (int i = 0; i < secondSplit.length; i += 3) {
            if (secondSplit[i].contains("name=")) {
                String[] tagName = secondSplit[i].split("\\(name=");
                String name = tagName[1].split("\\)")[0];
                if (name.equals("defaultTag"))
                    name = secondSplit[i+1];
                Tag tag = new Tag(name, secondSplit[i+2]);
                if (tags.containsKey(name))
                    throw new DuplicateNameException(name);
                tags.put(name, tag);
            }
            if (secondSplit[i].contains("tag=")) {
                String[] AttributeTag = secondSplit[i].split("\\(tag=");
                String tag = AttributeTag[1].split("\\)")[0];
                if (attributes.containsKey(tag))
                    throw new DuplicateNameException(tag);
                attributes.put(tag, new Attribute(tag, secondSplit[i+1], secondSplit[i+2]));
            }
            if (secondSplit[i+2].contains("<"))
                i++;
        }
        for (Attribute i : attributes.values()) {
            tags.get(i.getTag()).insertAttribute(i);
        }
        for (Tag i : tags.values()) {
            result += i.toXml();
        }
        result += "</" + firstSplit[0].split("<")[1];

        String[] forProperXmlTreePerfomance = result.split("\n");
        result = "";
        int countOfTagIncluded = 0;
        for (String i: forProperXmlTreePerfomance) {
            if (!i.equals("")) {
                String additionalSpace = "";
                boolean flag = false;
                if (i.contains(("</"))) {
                    countOfTagIncluded--;
                    flag = true;
                }
                for (int j = 0; j < countOfTagIncluded; j++)
                    additionalSpace += "    ";
                i = additionalSpace + i;
                if (i.contains("<") && !flag)
                    countOfTagIncluded++;
                result += i + "\n";
            }
        }
        System.out.println(result);
        return result;

    }

    private static String anotherIteration(Class classObject, Object object) throws Exception{
        String result = "";
        for (Field field : classObject.getDeclaredFields()) {
            String part = (String) iteration(field);
            if (!part.equals(""))
            {
                result += part + field.getName() + ";";
                field.setAccessible(true);
                Class classObjectInner = field.get(object).getClass();
                XmlObject annotationObjIn = (XmlObject) classObjectInner.getAnnotation(XmlObject.class);
                if (annotationObjIn != null) {
                    result += toXml(field.get(object)) + ";";
                }
                result += field.get(object) + ";";
                field.setAccessible(false);
            }
        }
        for (Method method : classObject.getDeclaredMethods()) {
            boolean flag = false;
            if (method.getReturnType().toString().equals("void"))
                flag = true;
            if (method.getParameterTypes().length != 0)
                flag = true;
            String part = iteration(method);
            if (!part.equals("")) {
                if (flag)
                    throw new InnapropriateMethodForXml(method.toString());
                String[] notRealName = method.getName().split("^get");
                String name = (notRealName.length == 2 ? notRealName[1] : notRealName[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                    result += part + name + ";" + method.invoke(object) + ";";
                    method.setAccessible(true);
                }
                else {result += part + name + ";" + method.invoke(object) + ";";}
            }
        }
        return result;
    }

    private static String iterationOverParents(Class clazz, Object object) throws Exception{
        String result = "";
        XmlObject annotationObjInP = (XmlObject) clazz.getAnnotation(XmlObject.class);
        if (annotationObjInP != null) {
            result = anotherIteration(clazz, object);
            Class classObjectInnerParent = clazz.getSuperclass();
            if (classObjectInnerParent != null)
                result += iterationOverParents(classObjectInnerParent, object);
        }
        return result;

    }
    public static String toXml(Object object) throws Exception {
        String result = "";
        Class classObject = object.getClass();
        XmlObject annotationObj = (XmlObject) classObject.getAnnotation(XmlObject.class);
        if (annotationObj != null) {
            result = "<" + object.getClass().getName().split("TestObjects.")[1] + ">:";
            result += anotherIteration(classObject, object);
            Class classObjectInnerParent = object.getClass().getSuperclass();
            result += iterationOverParents(classObjectInnerParent, object);
        }
        return makingXml(result);
    }
}
