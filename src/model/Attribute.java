package model;

public class Attribute
{
  protected String nom;
  protected String type;

  public Attribute()
  {}

  public Attribute(String nom, String type)
  {
    this.nom = nom;
    this.type = type;
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

}
