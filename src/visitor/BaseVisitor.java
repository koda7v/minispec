package visitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Attribute;
import model.Entity;
import model.Model;

public class BaseVisitor implements IVisitor
{

  protected String code = "";
  protected Path actualPath;

  @Override
  public void visitModel(Model model)
  {
    this.createPackage(model.getNom());
    code = code + "package " + model.getNom() + "\n";
    for (Entity currentEntity : model.getEntities())
    {
      currentEntity.accept(this);
    }
    System.out.println(code);
  }

  @Override
  public void visitEntity(Entity entity)
  {
    this.createClass(entity.getNom());
    code = code + "class " + entity.getNom() + "\n";
    for (Attribute currentAttribute : entity.getAttributes())
    {
      currentAttribute.accept(this);
    }

  }

  @Override
  public void visitAttribute(Attribute attribute)
  {
    code = code + attribute.getType() + " " + attribute.getNom() + "\n";

  }

  protected void createPackage(String namePackage)
  {
    actualPath = Paths.get("./src/" + namePackage);
    try
    {
      Files.createDirectories(actualPath);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  protected void createClass(String nameClass)
  {
    Path path = Paths.get(actualPath + "/" + nameClass + ".java");
    this.deleteClass(path);
    try
    {
      Files.createFile(path);
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

}
