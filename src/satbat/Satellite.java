package satbat;

import java.util.List;

public class Satellite
{

protected String nomSat;
protected Integer id;
protected Flotte parent;
protected List<PanneauSolaire> panneauSolaires;

public Satellite(String nomSat, Integer id, Flotte parent, List<PanneauSolaire> panneauSolaires)
{
this.nomSat = nomSat;
 this.id = id;
 this.parent = parent;
 this.panneauSolaires = panneauSolaires;
 }

public String getnomSat()
{
 return this.nomSat;
}

public Integer getid()
{
 return this.id;
}

public Flotte getparent()
{
 return this.parent;
}

public List<PanneauSolaire> getpanneauSolaires()
{
 return this.panneauSolaires;
}

public void setnomSat(String nomSat)
{
 this.nomSat = nomSat;
}

public void setid(Integer id)
{
 this.id = id;
}

public void setparent(Flotte parent)
{
 this.parent = parent;
}

public void setpanneauSolaires(List<PanneauSolaire> panneauSolaires )
{
 this.panneauSolaires = panneauSolaires;
}

}
