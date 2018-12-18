package lab5;

import TestObjects.*;
import XML.DuplicateNameException;
import XML.InnapropriateMethodForXml;
import XML.XmlParser;
import org.junit.Assert;
import org.junit.Test;

public class lab5Test {
    //проверка на обычный класс
    @Test
    public void FirstTest() throws Exception {
        Person person = new Person("Иван","Eng",16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }
    @Test
    public void SecondTest() throws Exception {
        Person2 person = new Person2("Иван","Eng",16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }
    @Test (expected = DuplicateNameException.class)
    public void ThirdTest() throws Exception {
        Person3 person = new Person3("Иван","Eng", 16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }
    @Test (expected = InnapropriateMethodForXml.class)
    public void FourthTest() throws Exception {
        Person4 person = new Person4("Иван","Eng", 16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }
    @Test(expected = InnapropriateMethodForXml.class)
    public void FiveTest() throws Exception {
        Person5 person = new Person5("Иван","Eng", 16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }
    @Test(expected = DuplicateNameException.class)
    public void SixTest() throws Exception {
        Person6 person = new Person6("Иван","Eng", 16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }
    @Test
    public void SeventhTest() throws Exception {
        Person7 person = new Person7("Иван","Eng", 16);
        XmlParser xmlParser = new XmlParser();
        Object real = xmlParser.toXml(person);
        Object excepted = (Object) XmlParser.toXml(person);
        Assert.assertEquals(real,excepted);
    }

}
