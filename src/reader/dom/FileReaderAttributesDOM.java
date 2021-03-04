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
 * Version avec attributs
 * 
 * @author yannl
 *
 */
public class FileReaderAttributesDOM
{

  protected Carnet carnet;

  public FileReaderAttributesDOM()
  {
    this.carnet = new Carnet();
  }

  protected Carnet readFileContactDOM(String sourceFile)
  {

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
          String nom = element.getAttribute(IContactConstant.NOM);
          String prenom = element.getAttribute(IContactConstant.PRENOM);
          String adresse = element.getAttribute(IContactConstant.ADRESSE);
          String age = element.getAttribute(IContactConstant.AGE);
          String numero = element.getAttribute(IContactConstant.NUMERO);

          int MonAge = Integer.parseInt(age);

          NodeList autreList = listnode.item(i).getChildNodes();
          Contact contactAutre = this.readFileAutreDOM(autreList);

          Contact contact = new Contact(nom, prenom, adresse, MonAge, numero, contactAutre.getAutres());
          carnet.addContact(contact);

        }

      }

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return carnet;
  }

  protected Contact readFileAutreDOM(NodeList listnode)
  {
    Contact contact = new Contact();

    for (int i = 0; i < listnode.getLength(); i++)
    {

      Node nNode = listnode.item(i);

      if (nNode.getNodeType() == Node.ELEMENT_NODE)
      {
        Element element = (Element) nNode;
        String label = element.getAttribute(IAutreConstant.LABEL);
        String valeur = element.getAttribute(IAutreConstant.VALEUR);
        String[] MesValeurs = valeur.split(" ");
        List<String> list = Arrays.asList(MesValeurs);
        Autre autre = new Autre(label, list);

        contact.addAutreToContact(autre);

      }

    }

    return contact;
  }

  public Carnet getCarnet()
  {
    return this.carnet;
  }

}