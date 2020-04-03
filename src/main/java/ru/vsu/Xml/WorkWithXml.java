package ru.vsu.Xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.vsu.Division;
import ru.vsu.Person;
import ru.vsu.Repository;
import ru.vsu.lab.entities.enums.Gender;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class WorkWithXml {

    /**
     * From Java to XML file with name Output.xml
     * @param person - list with persons
     */

    public void toXml(Repository<Person> person) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Persons personsList = new Persons();
            List<Person> personList = person.toList();
            for (Person element : personList) {
                System.out.println(element);
                personsList.getPersons().add(element);
            }
            File output = new File("Output.xml");
            marshaller.marshal(personsList, output);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * From XML file to Java
     * @return - Repository with persons
     */
    public Repository<Person> fromXml(String file) {

        try {
            File xmlFile = new File(file);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("persons");

            Repository<Person> personRepo = new Repository<>();
            for (int i = 1; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode;
                    String id = elem.getElementsByTagName("id").item(1).getTextContent();
                    String fname = elem.getElementsByTagName("firstName").item(0).getTextContent();
                    String lname = elem.getElementsByTagName("lastName").item(0).getTextContent();
                    String birthday = elem.getElementsByTagName("birthdate").item(0).getTextContent();

                    NodeList list = doc.getElementsByTagName("division");
                    Node node = list.item(i - 1);
                    Element elem1 = (Element) node;
                    String div = elem1.getElementsByTagName("id").item(0).getTextContent();
                    String divName = elem1.getElementsByTagName("name").item(0).getTextContent();

                    String gen = elem.getElementsByTagName("gender").item(0).getTextContent();
                    String sal = elem.getElementsByTagName("salary").item(0).getTextContent();

                    Person person = new Person(Integer.parseInt(id), fname, lname, LocalDate.parse(birthday), Gender.valueOf(gen),
                            BigDecimal.valueOf(Double.parseDouble(sal)), new Division(Integer.parseInt(div), divName));
                    personRepo.add(person);
                }
            }
            return personRepo;
        } catch (ParserConfigurationException | SAXException | IOException | DOMException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
