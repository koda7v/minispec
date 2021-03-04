package writers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Model.Autre;
import Model.Carnet;
import Model.Contact;
import constants.IAutreConstant;
import constants.IContactConstant;
import constants.IFileConstant;

/**
 * Version avec attribut
 * 
 * @param carnet
 * @throws IOException
 */
public class FileWriterAttributesDOM
{

  public void writeFileXMLDOM(Carnet carnet) throws IOException
  {
    Document document = null;
    DocumentBuilderFactory fabrique = null;
    File file = new File(IFileConstant.RESOURCE, IFileConstant.FILENAMEXML);
    file.delete();
    file.createNewFile();
    try
    {
      fabrique = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = fabrique.newDocumentBuilder();
      document = builder.newDocument();
      Element racine = document.createElement(IFileConstant.FILENAMEXMLDOM);
      racine.setAttribute(IFileConstant.TYPE, IFileConstant.COMMUN);
      document.appendChild(racine);
      document.setXmlStandalone(true);

      for (Contact contact : carnet.getContacts())
      {
        Element MonContact = document.createElement(IContactConstant.NAMEXMLContact);
        MonContact.setAttribute(IContactConstant.NOM, contact.getNom());
        MonContact.setAttribute(IContactConstant.PRENOM, contact.getPrenom());
        MonContact.setAttribute(IContactConstant.ADRESSE, contact.getAdresse());
        String age = Integer.toString(contact.getAge());
        MonContact.setAttribute(IContactConstant.AGE, age);
        MonContact.setAttribute(IContactConstant.NUMERO, contact.getNumero());

        for (Autre autre : contact.getAutres())
        {
          Element MonAutre = document.createElement(IAutreConstant.NAMEXMLAutre);

          MonAutre.setAttribute(IAutreConstant.LABEL, autre.getLabel());

          String valeur1 = "";
          for (int i = 0; i < autre.getValeur().size(); i++)
          {
            String valeur = autre.getValeur().get(i);
            valeur = valeur + " " + valeur1;
            MonAutre.setAttribute(IAutreConstant.VALEUR, valeur);
            valeur1 = valeur;
          }
          MonContact.appendChild(MonAutre);
        }
        racine.appendChild(MonContact);

      }

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult resultat = new StreamResult(file);
      transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, IFileConstant.DTD);
      transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, IFileConstant.CARNETID);
      transformer.setOutputProperty(OutputKeys.INDENT, IFileConstant.YES);
      transformer.setOutputProperty(IFileConstant.URL, IFileConstant.DEUX);
      transformer.transform(source, resultat);

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}