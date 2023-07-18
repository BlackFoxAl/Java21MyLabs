package com.java21.lesson19;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLFileInJava {
    public static void main(String[] arguments) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);
            rootElement.appendChild(createUserElement(doc, "1", "Ramesh", "Fadatare", "28", "Male"));
            rootElement.appendChild(createUserElement(doc, "2", "John", "Cena", "45", "Male"));
            rootElement.appendChild(createUserElement(doc, "3", "Tom", "Cruise", "40", "Male"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("create_users.xml"));
            transformer.transform(source, console);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Node createUserElement(Document doc, String id, String firstName, String lastName,
                                          String age, String gender) {
        Element user = doc.createElement("User");
        user.setAttribute("id", id);
        user.appendChild(createUserElements(doc, user, "firstName", firstName));
        user.appendChild(createUserElements(doc, user, "lastName", lastName));
        user.appendChild(createUserElements(doc, user, "age", age));
        user.appendChild(createUserElements(doc, user, "gender", gender));
        return user;
    }
    private static Node createUserElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
