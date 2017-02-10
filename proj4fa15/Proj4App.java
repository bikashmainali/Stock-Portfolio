package proj4fa15;
/**
 * <p>
 * Title: Project 4--Application class
 * </p>
 * <p>
 * Description: Project4App test stock, portfolio stockTable class. It get data
 * from different file from in the computer and manage the stock sales and info.
 * </p>
 *
 * @author Bikash Mainali
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj4App
{
	public static void main(String[] args) throws FileNotFoundException
	{
		SymbolTable symbolTable = new SymbolTable(new File("symboldata.txt"));
		Portfolio portfolio = new Portfolio(symbolTable);
		Scanner fileScan = new Scanner(new File("stockdata.txt"));
		while (fileScan.hasNext())
		{
			String ticker = fileScan.next();
			int numStock = fileScan.nextInt();
			double price = fileScan.nextDouble();
			String comp = fileScan.next();
			char c = ticker.charAt(0);
			try
			{
				portfolio.processTransaction(c , numStock , price , comp);
			}
			catch (ElementNotFoundException | InvalidSaleException ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("\n\t\t\t--------------    Transaction Canceled    -------------- \n");
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("portfolio after transaction :");
			System.out.println(portfolio.toString());
		}
		// scanner close
		fileScan.close();
	}
}
