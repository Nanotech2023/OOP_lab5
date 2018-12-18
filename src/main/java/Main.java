import TestObjects.Person;
import XML.CustomException;
import XML.XmlParser;


public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Sergey", "Rus", 32);
            XmlParser xmlParser = new XmlParser();
            System.out.println(xmlParser.toXml(person));
        }
        catch (CustomException e) {
            System.out.println(e.getError());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
