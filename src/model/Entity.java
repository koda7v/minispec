package model;

import java.util.ArrayList;
import java.util.List;

import visitor.IEntityVisitor;
import visitor.IVisitor;

public class Entity implements IEntityVisitor
{
  protected Model model;
  protected String nom;
  protected List<Attribute> attributes;

  public Entity()
  {
    this.attributes = new ArrayList<>();
  }

  public Entity(String nom, Model model)
  {
    this();
    this.nom = nom;
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

  public List<Attribute> getAttributes()
  {
    return attributes;
  }

  public void setAttributes(List<Attribute> attributes)
  {
    this.attributes = attributes;
  }

  public Model getModel()
  {
    return model;
  }

  public void setModel(Model model)
  {
    this.model = model;
  }

  @Override
  public void accept(IVisitor visitor)
  {
    visitor.visitEntity(this);

  }

}
