package stockexchange.client;

import java.util.List;
import java.util.Observer;

public interface StockExchangeClient extends AutoCloseable{

	public void startListening(String clientId, Observer observer);

	public Long sendCommand (StockExchangeCommand command);
	
	public List<StockExchangeTransaction> getTransactionsForCommand (long commandId);
	
	public Stock getQuote (String stockId);
	
	public List<String> getStocksId ();

	public List<StockExchangeTransaction> getTransactionsByStockId(String string, int size);

	public List<StockExchangeCommand> getCommandsByStockId(String stockId, int size);
}
