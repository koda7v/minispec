package satbat;

public class Satellite
{

protected String nomSat;
protected Integer id;

public Satellite(String nomSat, Integer id)
{
this.nomSat = nomSat;
 this.id = id;
 }

public String getnomSat()
{
 return this.nomSat;
}

public Integer getid()
{
 return this.id;
}

public void setnomSat(String nomSat )
{
 this.nomSat = nomSat;
}

public void setid(Integer id )
{
 this.id = id;
}

}
