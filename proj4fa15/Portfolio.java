package proj4fa15;

/**
 * <p>
 * Title: Portfolio class
 * </p>
 * <p>
 * Description: portfolio class process different transaction. it sells stock.
 * calculate gain or loss. if stock is brought then put that stock in the list
 * so that we can keep track of all information.
 * </p>
 *
 * @author Bikash Mainali
 */
import java.text.DecimalFormat;

public class Portfolio
{
	// instance variable
	private ArrayUnorderedList<Stock> stocks;
	private SymbolTable symbols;
	private double gainloss;
	String pattern = "$ ###,###.####";
	DecimalFormat decimalFormat;

	/**
	 * Portfolio parameterized constructor it assign the symbol to value passed.
	 * assign gainloss value to 0. create initialized ArrayUnorderedList object.
	 * Creates pattern to display currency in proper way.
	 * 
	 * @param symbolTable
	 *            -- is reference to the symbol table. it contains company
	 *            ticker and company name.
	 */
	public Portfolio(SymbolTable symbolTable)
	{
		symbols = symbolTable;
		gainloss = 0;
		stocks = new ArrayUnorderedList<Stock>();
		decimalFormat = new DecimalFormat(pattern);
		decimalFormat.setGroupingSize(3);
	}

	/**
	 * it performs sells stock, calculate gain or loss. if stock is brought then
	 * put that stock in the list so that we can keep track of all information.
	 * 
	 * @param status - whether the stock is being bought or sold.
	 * @param number - number of stock to be bought or sold.
	 * @param value - value at which stock is being sold or brought.
	 * @param compTicker - company short name.
	 */
	public void processTransaction(char status, int number, double value, String compTicker)
	{
		int numOfstock = 0;
		if (status == 's')
		{
			System.out.println(
					"\t\t\t--------------  Stock selling in process:  -------------- \n\n" + number + " stock of "
							+ symbols.findCompany(compTicker) + " requested at price " + decimalFormat.format(value));
			for (int i = 0; i < stocks.count; i++)
			{
				if (stocks.get(i).getTickerSymbol().equals(compTicker))
				{
					numOfstock += stocks.get(i).getSharesOwned();
				}
			}
			if (numOfstock < number)
			{
				if (numOfstock > 0)
					System.out.println("We have only " + numOfstock + " stocks of " + symbols.findCompany(compTicker));
				else
					System.out.println("We do not have any stocks of " + symbols.findCompany(compTicker));
				System.out.println("Not enough stock sorry!");
				throw new InvalidSaleException("Not enough stocks to sell.");
			}
			else
			{
				int i = 0;
				while (number > 0)
				{
					if (stocks.get(i).getTickerSymbol().equals(compTicker))
					{
						double sales = gainloss;
						if (stocks.get(i).getSharesOwned() <= number)
						{
							System.out.print("Selling " + stocks.get(i).getSharesOwned() + " stocks of "
									+ symbols.findCompany(compTicker) + " from position " + (i + 1 ));
							number = number - stocks.get(i).getSharesOwned();
							gainloss = gainloss
									+ stocks.get(i).getSharesOwned() * (value - stocks.get(i).getPurchasePrice() );
							double val = (gainloss - sales );// (a < b) ? a
							// : b
							System.out.println( (val > 0 ) ? "\tGain in this sale: " + decimalFormat.format(val)
									: "\tLoss in this sale: " + decimalFormat.format(val));
							stocks.remove(stocks.get(i));
							i--;
						}
						else
						{
							System.out.print("Selling " + number + " stocks of " + symbols.findCompany(compTicker)
									+ " from position " + (i + 2 ));
							gainloss = gainloss + number * (value - stocks.get(i).getPurchasePrice() );
							double val = (gainloss - sales );// (a < b) ? a
							// : b
							System.out.println( (val > 0 ) ? "\tGain in this sale: " + decimalFormat.format(val)
									: "\tLoss in this sale: " + decimalFormat.format(val));
							stocks.get(i).setSharesOwned(stocks.get(i).getSharesOwned() - number);
							number = 0;
							i--;
						}
					}
					i++;
				}
			}
			System.out.println("\n\t\t\t--------------    Transaction Complete    -------------- \n");
		}
		else if (status == 'b')
		{
			stocks.addToRear(new Stock(number , value , compTicker));
			System.out.println("Stock Bought : \t\tNumber of stocks: " + number + " \tPrice: " + value + " \tCompany : "
					+ symbols.findCompany(compTicker));
		}
	}

	/**
	   * toString --
	   * returns a string representation of this list.
	   * @return a reference to a String containing the data in the list
	   */
	public String toString()
	{
		int Scount = stocks.size();
		String str = "";
		for (int i = 0; i < Scount; i++)
		{
			str = str + stocks.get(i).toString() + "  \tCompany Name: "
					+ symbols.findCompany(stocks.get(i).getTickerSymbol()) + "\n";
		}
		str += "\nGain/loss :" + decimalFormat.format(gainloss) + "\n";
		str += "-------------------------------------------------------------------------------------------------------------- \n";
		return str;
	}
}
