package proj4fa15;
/**
 * <p>
 * Title: Symbol Table class
 * </p>
 * <p>
 * Description: SymbolTable get input files passed to it. It store company
 * ticker and company name.
 * </p>
 *
 * @author Bikash Mainali
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolTable
{
	// instance variable
	private ArrayUnorderedList<SymbolPair> symbolPairs;

	/**
	 * parameterized SymbolTable constructor -- get file as from the calling
	 * class. Input all the value from that file. Create symbolTalbe object and
	 * add to arrayUnordered list. 
	 * 
	 * @param file -- file from which the value to be pulled.
	 * @throws FileNotFoundException if the file is not found then creates a new FileNotFoundException object.
	 */
	public SymbolTable(File file) throws FileNotFoundException
	{
		symbolPairs = new ArrayUnorderedList<SymbolPair>();
		Scanner fileScan = new Scanner(file);
		while (fileScan.hasNext())
		{
			String comp = fileScan.next();
			String compName = fileScan.nextLine();
			SymbolPair symbolPair = new SymbolPair(comp , compName);
			symbolPairs.addToRear(symbolPair);
		}
		fileScan.close();
	}

	/**
	 * it find the full name of the company from the company ticker passed.
	 * @param comp - ticker to search for the full name of company.
	 * @return the full name of company if found otherwise return "Company not found".
	 */
	public String findCompany(String comp)
	{
		int count = symbolPairs.count;
		for (int i = 0; i < count; i++)
		{
			if (symbolPairs.get(i).getTickerSymbol().equals(comp))
				return symbolPairs.get(i).getCompanyName();
		}
		return "Company not found";
	}
}
