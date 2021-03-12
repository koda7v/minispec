package model;

import visitor.IEntityVisitor;
import visitor.IVisitor;

public class Attribute implements IEntityVisitor
{
  protected String nom;
  protected String type;
  protected Model model;
  protected Entity entity;

  public Attribute()
  {}

  public Attribute(String nom, String type, Entity entity, Model model)
  {
    this.nom = nom;
    this.type = type;
    this.entity = entity;
    this.model = model;
  }

  public String getNom()
  {
    return nom;
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public Model getModel()
  {
    return model;
  }

  public void setModel(Model model)
  {
    this.model = model;
  }

  public Entity getEntity()
  {
    return entity;
  }

  public void setEntity(Entity entity)
  {
    this.entity = entity;
  }

  @Override
  public void accept(IVisitor visitor)
  {
    visitor.visitAttribute(this);

  }

}
