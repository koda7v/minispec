package reader.dom;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import model.Attribute;
import model.Entity;
import model.Model;

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

}