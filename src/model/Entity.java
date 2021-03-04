package model;

import java.util.ArrayList;
import java.util.List;

public class Entity
{
  protected String nom;
  protected List<Attribute> attributes;

  public Entity()
  {
    this.attributes = new ArrayList<>();
  }

  public Entity(String nom)
  {
    this();
    this.nom = nom;
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
