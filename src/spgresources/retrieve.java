package spgresources;
import java.sql.*;

public class retrieve {
	
	
	public static String mypath  ()
	{
		
		
	
	try{
		PreparedStatement ps1=com.example.dao.Dao.getCon().prepareStatement("SELECT path from record where path =' '");
		ResultSet rs=ps1.executeQuery();
		String s=rs.toString();
		return s;
	}

catch(Exception e)
{
System.out.print(e);
}
	return null;}
	public static void main (String []args)
	{ mypath();
	
	}}


