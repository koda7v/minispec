package visitor;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.Attribute;
import model.Entity;
import model.Model;
import model.MyObject;

public class BaseVisitor2 implements IVisitor
{

  protected String content = "";
  protected String content2 = "";
  protected String content3 = "";
  protected String actualPathDirectory;
  protected String actualPathFile;
  protected List<Attribute> attributes = new ArrayList<>();
  protected List<MyObject> myObjects = new ArrayList<>();
  protected boolean myImport;

  @Override
  public void visitModel(Model model)
  {
    this.createPackage(model.getNom());
    for (Entity currentEntity : model.getEntities())
    {
      myImport = false;
      content = "package " + model.getNom() + ";\n\n";
      currentEntity.accept(this);
      this.writeFile();

    }
  }

  @Override
  public void visitEntity(Entity entity)
  {
    this.createClass(entity.getNom());
    attributes = new ArrayList<>();
    content2 = "public class " + entity.getNom() + "\n{\n\n";
    for (Attribute currentAttribute : entity.getAttributes())
    {
      currentAttribute.accept(this);
    }
    content2 = content2 + "\n";
    loopConstructor(entity);
    loopGetterSetter();
    content3 = "}\n";
  }

  @Override
  public void visitAttribute(Attribute attribute)
  {
    attributes.add(attribute);
    myObjects = new ArrayList<MyObject>();
    for (MyObject currentObject : attribute.getObject())
    {
      currentObject.accept(this);
    }
    if (attribute.getObject().size() > 0)
    {
      content2 = content2 + "protected " + attribute.getType() + "<" + attribute.getObject().get(0).getNom() + ">" + " "
          + attribute.getNom() + ";\n";
    }
    else
    {
      content2 = content2 + "protected " + attribute.getType() + " " + attribute.getNom() + ";\n";
    }

  }

  @Override
  public void visitObject(MyObject myObject)
  {
    if (!myImport)
    {
//      content += "import java.util.ArrayList;\n";
      content += "import java.util.List;\n\n";
      myImport = true;
    }
    myObjects.add(myObject);
  }

  protected void createPackage(String namePackage)
  {
    actualPathDirectory = "./src/" + namePackage;
    try
    {
      Files.createDirectories(Paths.get(actualPathDirectory));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  protected void createClass(String nameClass)
  {
    actualPathFile = actualPathDirectory + "/" + nameClass + ".java";
    this.deleteClass(Paths.get(actualPathFile));
    try
    {
      Files.createFile(Paths.get(actualPathFile));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  protected void deleteClass(Path path)
  {
    try
    {
      Files.deleteIfExists(path);
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  protected void loopConstructor(Entity entity)
  {
    content2 = content2 + "public " + entity.getNom() + "(";
    for (Attribute currentAttribute : attributes)
    {
      if (currentAttribute.getObject().size() > 0)
      {
        content2 = content2 + currentAttribute.getType() + "<" + currentAttribute.getObject().get(0).getNom() + "> "
            + currentAttribute.getNom() + ", ";
      }
      else
      {
        content2 = content2 + currentAttribute.getType() + " " + currentAttribute.getNom() + ", ";
      }
    }
    content2 = content2.substring(0, content2.length() - 2);
    content2 = content2 + ")\n{\n";
    for (Attribute currentAttribute : attributes)
    {
      content2 = content2 + "this." + currentAttribute.getNom() + " = " + currentAttribute.getNom() + ";\n ";
    }
    content2 = content2 + "}\n\n";
  }

  protected void loopGetterSetter()
  {
    // getter
    for (Attribute currentAttribute : attributes)
    {

      if (currentAttribute.getObject().size() > 0)
      {
        content2 = content2 + "public " + currentAttribute.getType() + "<"
            + currentAttribute.getObject().get(0).getNom() + ">" + " get" + currentAttribute.getNom()
            + "()\n{\n return this." + currentAttribute.getNom() + ";\n}\n\n";
      }
      else
      {
        content2 = content2 + "public " + currentAttribute.getType() + " get" + currentAttribute.getNom()
            + "()\n{\n return this." + currentAttribute.getNom() + ";\n}\n\n";
      }

    }
    // setter
    for (Attribute currentAttribute : attributes)
    {
      if (currentAttribute.getObject().size() > 0)
      {
        content2 = content2 + "public void set" + currentAttribute.getNom() + "(" + currentAttribute.getType() + "<"
            + currentAttribute.getObject().get(0).getNom() + "> " + currentAttribute.getNom() + " )\n{\n this."
            + currentAttribute.getNom() + " = " + currentAttribute.getNom() + ";\n}\n\n";
      }
      else
      {
        content2 = content2 + "public void set" + currentAttribute.getNom() + "(" + currentAttribute.getType() + " "
            + currentAttribute.getNom() + ")\n{\n this." + currentAttribute.getNom() + " = " + currentAttribute.getNom()
            + ";\n}\n\n";
      }

    }
  }

  protected void writeFile()
  {
    try
    {
      FileWriter myWriter = new FileWriter(actualPathFile);
      myWriter.write(content);
      myWriter.write(content2);
      myWriter.write(content3);
      myWriter.close();
    }
    catch (IOException e)
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

}
