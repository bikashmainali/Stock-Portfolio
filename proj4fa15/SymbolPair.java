package proj4fa15;

public class SymbolPair
{
	private String tickerSym;
	private String companyName;

	public SymbolPair(String ticker, String compName)
	{
		tickerSym = ticker;
		companyName = compName;
	}

	public String getTickerSymbol()
	{
		return tickerSym;
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
}
