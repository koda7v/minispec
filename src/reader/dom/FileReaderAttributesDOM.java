package reader.dom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import constants.Constant;
import model.Attribute;
import model.Entity;
import model.Model;

/**
 * Version avec attributs
 * 
 * @author yannl
 *
 */
public class FileReaderAttributesDOM
{

  protected Model model;

  public FileReaderAttributesDOM()
  {
    this.model = new Model();
  }

  public Model read(String sourceFile)
  {
    try
    {
      URL ressource = getClass().getClassLoader().getResource(sourceFile);
      File file = new File(ressource.getFile());
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(file);
      doc.getDocumentElement().normalize();
      readModel(doc);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return this.model;

  }

  protected void readModel(Document doc)
  {
    NodeList list = doc.getElementsByTagName(Constant.NAMEXMLModel);

    for (int temp = 0; temp < list.getLength(); temp++)
    {

      Node nNode = list.item(temp);

      if (nNode.getNodeType() == Node.ELEMENT_NODE)
      {
        Element element = (Element) nNode;
        String nom = element.getAttribute(Constant.NAME);

        NodeList nEntities = list.item(temp).getChildNodes();
        List<Entity> entities = this.readEntity(nEntities);

        this.model.setNom(nom);
        this.model.setEntities(entities);
      }
    }

  }

  protected List<Entity> readEntity(NodeList list)
  {

    List<Entity> entities = new ArrayList<>();

    for (int temp = 0; temp < list.getLength(); temp++)
    {

      Node nNode = list.item(temp);

      if (nNode.getNodeType() == Node.ELEMENT_NODE)
      {
        Element element = (Element) nNode;
        String nom = element.getAttribute(Constant.NAME);

        NodeList nAttributes = list.item(temp).getChildNodes();

        Entity entity = new Entity(nom);
        entity.setAttributes(this.readAttribute(nAttributes));
      }
    }

    return entities;
  }

  protected List<Attribute> readAttribute(NodeList list)
  {

    List<Attribute> attributes = new ArrayList<>();

    for (int temp = 0; temp < list.getLength(); temp++)
    {

      Node nNode = list.item(temp);

      if (nNode.getNodeType() == Node.ELEMENT_NODE)
      {

        Element element = (Element) nNode;
        String nom = element.getAttribute(Constant.NAME);
        String type = element.getAttribute(Constant.TYPE);

        Attribute attribute = new Attribute(nom, type);

        attributes.add(attribute);
      }
    }

    return attributes;
  }

}