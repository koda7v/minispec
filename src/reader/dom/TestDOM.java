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
    Model model = reader.read("carnet_test.xml");
    assertTrue(model != null);
    assertTrue(model.getNom().equals("patate"));
    assertTrue(model.getEntities().size() == 1);

    Entity entity = model.getEntities().get(0);

    assertTrue(entity.getNom().equals("Satellite"));
    assertTrue(entity.getAttributes().size() == 2);

    Attribute attribute1 = entity.getAttributes().get(0);
    Attribute attribute2 = entity.getAttributes().get(1);

    assertTrue(attribute1.getNom().equals("nom"));
    assertTrue(attribute1.getType().equals("String"));
    assertTrue(attribute2.getNom().equals("id"));
    assertTrue(attribute2.getType().equals("Integer"));

//    carnet.addContact(contact4);
//    FileWriterAttributesDOM writer = new FileWriterAttributesDOM();
//    writer.writeFileXMLDOM(carnet);

  }

}