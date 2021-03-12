package model;

import visitor.IEntityVisitor;
import visitor.IVisitor;

public class MyObject implements IEntityVisitor
{
  protected String nom;

  public MyObject(String nom)
  {
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

  @Override
  public void accept(IVisitor visitor)
  {
    visitor.visitObject(this);

  }
}
