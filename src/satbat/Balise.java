package satbat;

public class Balise
{

protected String nomBat;
protected Integer id;

public Balise(String nomBat, Integer id)
{
this.nomBat = nomBat;
 this.id = id;
 }

public String getnomBat()
{
 return this.nomBat;
}

public Integer getid()
{
 return this.id;
}

public void setnomBat(String nomBat )
{
 this.nomBat = nomBat;
}

public void setid(Integer id )
{
 this.id = id;
}

}
