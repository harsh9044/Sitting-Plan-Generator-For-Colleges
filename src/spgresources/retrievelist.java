package spgresources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import spgresources.ExcelReader;
public class retrievelist  {
	public static void main (String[] args) throws IOException, InvalidFormatException{
	
	System.out.println(ExcelReader.getList().size());
	for (int i=1;i<ExcelReader.getList().size();i++)
	{
		String h=ExcelReader.getList().get(i);
		System.out.print(h);
	}
}}
