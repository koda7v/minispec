package visitor;

import model.Attribute;
import model.Entity;
import model.Model;

public class BaseVisitor implements IVisitor
{

  protected String code = "";

  @Override
  public void visitModel(Model model)
  {
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

}
