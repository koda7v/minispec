package satbat;

import java.util.List;

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
