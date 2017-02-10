package proj4fa15;

import java.text.DecimalFormat;

public class Stock
{
	//instance variable
	private String tickerSym;
	private int sharesOwned;
	private double purchasePrice;

	/**
	 * Parameterized stock constructor -initialized all the instance variable
	 * @param shares --number of stocks
	 * @param price -- price of stock
	 * @param ticker -- ticker of stock
	 */
	public Stock(int shares, double price, String ticker)
	{
		sharesOwned=shares;
		purchasePrice= price;
		tickerSym = ticker;
	}

	/**
	 * return ticker symbol of the stock
	 * @return tickerSym -- is ticker of the company.
	 */
	public String getTickerSymbol()
	{
		return tickerSym;
	}

	/**
	 * return shares Owned of a stock.
	 * @return sharesOwned -- number of stocks.
	 */
	public int getSharesOwned()
	{
		return sharesOwned;
	}
	
	/**
	 * return the price at which stock is purchased .
	 * @return purchasePrice -- unit price of the stock
	 */
	public double getPurchasePrice()
	{
		return purchasePrice;
	}

	/**
	 * set the current number of stocks.
	 * @param share -- number of stock to be assigned.
	 */
	public void setSharesOwned(int share)
	{
		sharesOwned= share;
	}

	/**
	 * toString -- returns the state of the stock as a string
	 * 
	 * @return a string containing the value that a stock should contain.
	 */
	public String toString()
	{
		 String pattern = "$ ###,###,###.####";
		 DecimalFormat decimalFormat = new DecimalFormat(pattern);
		 decimalFormat.setGroupingSize(3);
		 return "Share Owned: " + sharesOwned + " \tPurchase Price: " +  decimalFormat.format(purchasePrice);

	}

}
