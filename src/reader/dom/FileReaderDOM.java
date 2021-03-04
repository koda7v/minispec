package reader.dom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Model.Autre;
import Model.Carnet;
import Model.Contact;
import constants.IAutreConstant;
import constants.IContactConstant;

/**
 * Version sans attributs
 * 
 * @author yannl
 *
 */
public class FileReaderDOM
{

  public Carnet readFileContactDOM(String sourceFile)
  {
    Carnet carnet = new Carnet();
    URL resource = this.getClass().getClassLoader().getResource(sourceFile);
    File newFile = new File(resource.getFile());
    try (FileReader file = new FileReader(newFile); BufferedReader fileReader = new BufferedReader(file))
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder loader = factory.newDocumentBuilder();
      Document document = loader.parse(newFile);

      document.getDocumentElement().normalize();
      NodeList listnode = document.getElementsByTagName(IContactConstant.NAMEXMLContact);

      for (int i = 0; i < listnode.getLength(); i++)
      {

        Node nNode = listnode.item(i);

        if (nNode.getNodeType() == Node.ELEMENT_NODE)
        {
          Element element = (Element) nNode;
          String nom = element.getElementsByTagName(IContactConstant.NOM).item(0).getTextContent();
          String prenom = element.getElementsByTagName(IContactConstant.PRENOM).item(0).getTextContent();
          String adresse = element.getElementsByTagName(IContactConstant.ADRESSE).item(0).getTextContent();
          String age = element.getElementsByTagName(IContactConstant.AGE).item(0).getTextContent();
          String numero = element.getElementsByTagName(IContactConstant.NUMERO).item(0).getTextContent();

          int MonAge = Integer.parseInt(age);
          Contact contactAutre = this.readFileAutreDOM(sourceFile);
          Contact contact = new Contact(nom, prenom, adresse, MonAge, numero, contactAutre.getAutres());

          carnet.addContact(contact);
          contact = new Contact();
        }

      }

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return carnet;
  }

  public Contact readFileAutreDOM(String sourceFile)
  {
    Contact contact = new Contact();
    URL resource = this.getClass().getClassLoader().getResource(sourceFile);
    File newFile = new File(resource.getFile());
    try (FileReader file = new FileReader(newFile); BufferedReader fileReader = new BufferedReader(file))
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder loader = factory.newDocumentBuilder();
      Document document = loader.parse(newFile);

      document.getDocumentElement().normalize();
      NodeList listnode = document.getElementsByTagName(IAutreConstant.NAMEXMLAutre);

      for (int i = 0; i < listnode.getLength(); i++)
      {

        Node nNode = listnode.item(i);

        if (nNode.getNodeType() == Node.ELEMENT_NODE)
        {
          Element element = (Element) nNode;
          String label = element.getElementsByTagName(IAutreConstant.LABEL).item(0).getTextContent();
          String valeur = element.getElementsByTagName(IAutreConstant.VALEUR).item(0).getTextContent();
          String[] MesValeurs = valeur.split(", ");
          List<String> list = Arrays.asList(MesValeurs);
          Autre autre = new Autre(label, list);

          contact.addAutreToContact(autre);

          autre = new Autre();

        }

      }

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return contact;
  }
}