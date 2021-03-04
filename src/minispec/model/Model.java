package minispec.model;

import java.util.List;

public class Model
{
  protected String nom;
  protected List<Entity> entities;

  public Model()
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

  public List<Entity> getEntities()
  {
    return entities;
  }

  public void setEntities(List<Entity> entities)
  {
    this.entities = entities;
  }
}