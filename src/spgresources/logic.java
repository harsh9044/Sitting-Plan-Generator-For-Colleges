package spgresources;
import java.io.*;

import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class logic {
	
	public static void main (String[]args) throws IOException, InvalidFormatException
	{
		
		h();
	}
	
	public static void h() throws IOException, InvalidFormatException
		{
		
				Scanner sc= new Scanner(System.in);
				System.out.println("enter size of array");
				int n=sc.nextInt();
				int m=sc.nextInt();
				System.out.println("enter element of array");

		String array[][] = new String[n][m];
		for(int i = 0; i <=n; i++)
	    {
	      for(int y = 0; y <= m; y++)
	      {
	    	  for (int x=1;x<ExcelReader.getList().size();x++)
	            	{
	  		
	  		        array[i][y] = ExcelReader.getList().get(i);
	                continue; }
	    	  }
	    }
	for(int i = 0; i <= n; i++)
    {
      for(int y = 0; y <= m; y++)
      {
     System.out.println(array[i][y]);
      }
    }
	}
}