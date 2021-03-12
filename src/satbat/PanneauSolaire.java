package satbat;

public class PanneauSolaire
{

protected String nomPan;
protected Integer id;
protected Satellite parent;

public PanneauSolaire(String nomPan, Integer id, Satellite parent)
{
this.nomPan = nomPan;
 this.id = id;
 this.parent = parent;
 }

public String getnomPan()
{
 return this.nomPan;
}

public Integer getid()
{
 return this.id;
}

public Satellite getparent()
{
 return this.parent;
}

public void setnomPan(String nomPan)
{
 this.nomPan = nomPan;
}

public void setid(Integer id)
{
 this.id = id;
}

public void setparent(Satellite parent)
{
 this.parent = parent;
}

}
