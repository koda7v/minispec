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

public class BaseVisitor implements IVisitor
{

  protected String content = "";
  protected String actualPathDirectory;
  protected String actualPathFile;
  protected List<Attribute> attributes = new ArrayList<>();

  @Override
  public void visitModel(Model model)
  {
    this.createPackage(model.getNom());
    for (Entity currentEntity : model.getEntities())
    {
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
    content = content + "public class " + entity.getNom() + "\n{\n\n";
    for (Attribute currentAttribute : entity.getAttributes())
    {
      currentAttribute.accept(this);
    }
    content = content + "\n";
    loopConstructor(entity);
    loopGetterSetter();
    content = content + "}\n";
  }

  @Override
  public void visitAttribute(Attribute attribute)
  {
    attributes.add(attribute);
    content = content + "protected " + attribute.getType() + " " + attribute.getNom() + ";\n";
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
    content = content + "public " + entity.getNom() + "(";
    for (Attribute currentAttribute : attributes)
    {
      content = content + currentAttribute.getType() + " " + currentAttribute.getNom() + ", ";
    }
    content = content.substring(0, content.length() - 2);
    content = content + ")\n{\n";
    for (Attribute currentAttribute : attributes)
    {
      content = content + "this." + currentAttribute.getNom() + " = " + currentAttribute.getNom() + ";\n ";
    }
    content = content + "}\n\n";
  }

  protected void loopGetterSetter()
  {
    // getter
    for (Attribute currentAttribute : attributes)
    {
      content = content + "public " + currentAttribute.getType() + " get" + currentAttribute.getNom()
          + "()\n{\n return this." + currentAttribute.getNom() + ";\n}\n\n";

    }
    // setter
    for (Attribute currentAttribute : attributes)
    {
      content = content + "public void set" + currentAttribute.getNom() + "(" + currentAttribute.getType() + " "
          + currentAttribute.getNom() + ")\n{\n this." + currentAttribute.getNom() + " = " + currentAttribute.getNom()
          + ";\n}\n\n";
    }
  }

  protected void writeFile()
  {
    try
    {
      FileWriter myWriter = new FileWriter(actualPathFile);
      myWriter.write(content);
      myWriter.close();
    }
    catch (IOException e)
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  @Override
  public void visitObject(MyObject myObject)
  {
    // TODO Auto-generated method stub

  }

}
