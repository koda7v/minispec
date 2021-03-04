package reader.dom;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Model.Autre;
import Model.Carnet;
import Model.Contact;
import writers.FileWriterAttributesDOM;

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
    Carnet carnet = new Carnet();
    FileReaderAttributesDOM reader = new FileReaderAttributesDOM();
    carnet = reader.readFileContactDOM("carnet_test2.xml");
    assertTrue(carnet != null);
    assertTrue(carnet.getContacts().size() == 4);
    assertTrue(carnet.getType().equals("commun"));

    Contact contact = carnet.getContacts().get(0);
    assertTrue(contact.getAdresse().equals("1 route de brest"));
    assertTrue(contact.getAge() == 22);
    assertTrue(contact.getPrenom().equals("Yann"));
    assertTrue(contact.getNumero().equals("06 95 46 55 65"));
    assertTrue(contact.getNom().equals("Le Bris"));
    assertTrue(contact.getAutres().get(0).getLabel().equals("Hobby"));
    assertTrue(contact.getAutres().get(0).getValeur().get(0).equals("Lecture"));
    assertTrue(contact.getAutres().get(1).getLabel().equals("Plat"));
    assertTrue(contact.getAutres().get(1).getValeur().get(0).equals("Cassoulet"));

    Contact contact1 = carnet.getContacts().get(1);
    assertTrue(contact1.getAdresse().equals("14 route des cerises"));
    assertTrue(contact1.getAge() == 21);
    assertTrue(contact1.getPrenom().equals("Kilian"));
    assertTrue(contact1.getNumero().equals("06 95 36 45 59"));
    assertTrue(contact1.getNom().equals("Anchyse"));
    assertTrue(contact1.getAutres().get(0).getLabel().equals("Etudes"));
    assertTrue(contact1.getAutres().get(0).getValeur().get(0).equals("Info"));
    assertTrue(contact1.getAutres().get(0).getValeur().get(1).equals("Bio"));
    assertTrue(contact1.getAutres().get(1).getLabel().equals("Ordinateur"));

    Contact contact2 = carnet.getContacts().get(2);
    assertTrue(contact2.getAdresse().equals("3 rue des oranges"));
    assertTrue(contact2.getAge() == 21);
    assertTrue(contact2.getPrenom().equals("Samuel"));
    assertTrue(contact2.getNumero().equals("06 00 01 02 03"));
    assertTrue(contact2.getNom().equals("Barre"));
    assertTrue(contact2.getAutres().isEmpty());

    Contact contact3 = carnet.getContacts().get(3);
    assertTrue(contact3.getAdresse().equals("20 piste de Ski"));
    assertTrue(contact3.getAge() == 24);
    assertTrue(contact3.getPrenom().equals("Erwan"));
    assertTrue(contact3.getNumero().equals("07 05 36 46 73"));
    assertTrue(contact3.getNom().equals("Pech"));
    assertTrue(contact3.getAutres().isEmpty());

    Contact contact4 = new Contact();
    contact4.setAdresse("3 avenue des tulipes");
    contact4.setAge(15);
    contact4.setNom("Tout Puissant");
    contact4.setPrenom("Dieu");
    contact4.setNumero("00 00 00 00 00");
    List<Autre> autres = new ArrayList<>();
    Autre autre = new Autre();
    autre.setLabel("Téléphone");
    Autre autre1 = new Autre();
    autre1.setLabel("Pouvoirs");
    List<String> st = new ArrayList<>();
    st.add("Samsung");
    st.add("Nokia");
    st.add("IPhone");
    autre.setValeur(st);
    autres.add(autre);
    autres.add(autre1);
    contact4.setAutres(autres);

    carnet.addContact(contact4);
    FileWriterAttributesDOM writer = new FileWriterAttributesDOM();
    writer.writeFileXMLDOM(carnet);

  }

  /*
   * Test du carnet créé dans le premier test
   */
  @Test
  public void test1() throws IOException
  {
    Carnet carnet = new Carnet();
    FileReaderAttributesDOM reader = new FileReaderAttributesDOM();
    carnet = reader.readFileContactDOM("carnet_test3.xml");
    assertTrue(carnet != null);
    assertTrue(carnet.getContacts().size() == 5);
    assertTrue(carnet.getType().equals("commun"));
    Contact contact = carnet.getContacts().get(4);
    assertTrue(contact.getAdresse().equals("3 avenue des tulipes"));
    assertTrue(contact.getAge() == 15);
    assertTrue(contact.getPrenom().equals("Dieu"));
    assertTrue(contact.getNumero().equals("00 00 00 00 00"));
    assertTrue(contact.getNom().equals("Tout Puissant"));
    assertTrue(contact.getAutres().get(0).getLabel().equals("Téléphone"));
    assertTrue(contact.getAutres().get(0).getValeur().get(0).equals("IPhone"));
    assertTrue(contact.getAutres().get(0).getValeur().get(1).equals("Nokia"));
    assertTrue(contact.getAutres().get(0).getValeur().get(2).equals("Samsung"));
    assertTrue(contact.getAutres().get(1).getLabel().equals("Pouvoirs"));
  }

  /*
   * Test du carnet vide
   */
  @Test
  public void test2() throws IOException
  {
    Carnet carnet = new Carnet();
    FileReaderAttributesDOM reader = new FileReaderAttributesDOM();
    carnet = reader.readFileContactDOM("carnet_vide.xml");
    assertTrue(carnet != null);
    assertTrue(carnet.getContacts().size() == 0);
    assertTrue(carnet.getType().equals("commun"));

  }
}
