package model;

public class Satellite
{
  protected String nom;
  protected Integer id;

  public Satellite()
  {}

  public Satellite(String nom, Integer id)
  {
    this.nom = nom;
    this.id = id;
  }

  public String getNom()
  {
    return nom;
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

}
