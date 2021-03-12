package satbat;

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

public class Flotte
{

protected String nomFlo;
protected Integer id;
protected List<Satellite> satellites;

public Flotte(String nomFlo, Integer id, List<Satellite> satellites)
{
this.nomFlo = nomFlo;
 this.id = id;
 this.satellites = satellites;
 }

public String getnomFlo()
{
 return this.nomFlo;
}

public Integer getid()
{
 return this.id;
}

public List<Satellite> getsatellites()
{
 return this.satellites;
}

public void setnomFlo(String nomFlo)
{
 this.nomFlo = nomFlo;
}

public void setid(Integer id)
{
 this.id = id;
}

public void setsatellites(List<Satellite> satellites )
{
 this.satellites = satellites;
}

}
}
}
