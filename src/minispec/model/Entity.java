package minispec.model;

import java.util.List;

public class Entity
{
  protected String nom;
  protected List<Attribute> attributes;

  public Entity()
  {
    // TODO Auto-generated constructor stub
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

}
