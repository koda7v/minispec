package reader.dom;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import model.Attribute;
import model.Entity;
import model.Model;
import model.MyObject;

public class TestDOM
{

  /**
   * Vérification d'une carnet et écriture de ce carnet dans un autre fichier
   * 
   * @throws IOException
   */
  @Test
  public void test() throws IOException
  {
    FileReaderAttributesDOM reader = new FileReaderAttributesDOM();
    Model model = reader.read("Resource/minispec.xml");
    assertTrue(model != null);
    assertTrue(model.getNom().equals("satbat"));
    assertTrue(model.getEntities().size() == 2);

    Entity entity1 = model.getEntities().get(0);

    assertTrue(entity1.getNom().equals("Satellite"));
    assertTrue(entity1.getAttributes().size() == 2);

    Attribute attribute1 = entity1.getAttributes().get(0);
    Attribute attribute2 = entity1.getAttributes().get(1);

    assertTrue(attribute1.getNom().equals("nomSat"));
    assertTrue(attribute1.getType().equals("String"));
    assertTrue(attribute2.getNom().equals("id"));
    assertTrue(attribute2.getType().equals("Integer"));

    Entity entity2 = model.getEntities().get(1);

    assertTrue(entity2.getNom().equals("Balise"));
    assertTrue(entity2.getAttributes().size() == 2);

    Attribute attribute3 = entity2.getAttributes().get(0);
    Attribute attribute4 = entity2.getAttributes().get(1);

    assertTrue(attribute3.getNom().equals("nomBat"));
    assertTrue(attribute3.getType().equals("String"));
    assertTrue(attribute4.getNom().equals("id"));
    assertTrue(attribute4.getType().equals("Integer"));

//    carnet.addContact(contact4);
//    FileWriterAttributesDOM writer = new FileWriterAttributesDOM();
//    writer.writeFileXMLDOM(carnet);

  }

  @Test
  public void test2() throws IOException
  {
    FileReaderAttributesDOM2 reader = new FileReaderAttributesDOM2();
    Model model = reader.read("Resource/minispec2.xml");
    assertTrue(model != null);
    assertTrue(model.getNom().equals("satbat"));
    assertTrue(model.getEntities().size() == 3);

    Entity entity1 = model.getEntities().get(0);

    assertTrue(entity1.getNom().equals("Satellite"));
    assertTrue(entity1.getAttributes().size() == 4);

    Attribute attribute1 = entity1.getAttributes().get(0);
    Attribute attribute2 = entity1.getAttributes().get(1);
    Attribute attribute3 = entity1.getAttributes().get(2);
    Attribute attribute4 = entity1.getAttributes().get(3);

    assertTrue(attribute1.getNom().equals("nomSat"));
    assertTrue(attribute1.getType().equals("String"));
    assertTrue(attribute2.getNom().equals("id"));
    assertTrue(attribute2.getType().equals("Integer"));
    assertTrue(attribute3.getNom().equals("parent"));
    assertTrue(attribute3.getType().equals("Flotte"));
    assertTrue(attribute4.getNom().equals("panneauSolaires"));
    assertTrue(attribute4.getType().equals("List"));

    MyObject objet = attribute4.getObject().get(0);
    assertTrue(objet.getNom().equals("PanneauSolaire"));

    Entity entity2 = model.getEntities().get(1);

    assertTrue(entity2.getNom().equals("PanneauSolaire"));
    assertTrue(entity2.getAttributes().size() == 3);

    Attribute attribute5 = entity2.getAttributes().get(0);
    Attribute attribute6 = entity2.getAttributes().get(1);
    Attribute attribute7 = entity2.getAttributes().get(2);

    assertTrue(attribute5.getNom().equals("nomPan"));
    assertTrue(attribute5.getType().equals("String"));
    assertTrue(attribute6.getNom().equals("id"));
    assertTrue(attribute6.getType().equals("Integer"));
    assertTrue(attribute7.getNom().equals("parent"));
    assertTrue(attribute7.getType().equals("Satellite"));

    Entity entity3 = model.getEntities().get(2);

    assertTrue(entity3.getNom().equals("Flotte"));
    assertTrue(entity3.getAttributes().size() == 3);

    Attribute attribute8 = entity3.getAttributes().get(0);
    Attribute attribute9 = entity3.getAttributes().get(1);
    Attribute attribute10 = entity3.getAttributes().get(2);

    assertTrue(attribute8.getNom().equals("nomFlo"));
    assertTrue(attribute8.getType().equals("String"));
    assertTrue(attribute9.getNom().equals("id"));
    assertTrue(attribute9.getType().equals("Integer"));
    assertTrue(attribute10.getNom().equals("satellites"));
    assertTrue(attribute10.getType().equals("List"));

    MyObject objet2 = attribute10.getObject().get(0);
    assertTrue(objet2.getNom().equals("Satellite"));

//    carnet.addContact(contact4);
//    FileWriterAttributesDOM writer = new FileWriterAttributesDOM();
//    writer.writeFileXMLDOM(carnet);

  }

}