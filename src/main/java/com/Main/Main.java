//right click on project name --> Build path --> libraries --> add external jars
//RESTController -->  C - POST(returns the new object), R - GET, U - PUT(replace object)/ PATCH(updates part of fields), D - DELETE

package com.Main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.Main.Service.StockMarketService;


import stockexchange.client.StockCommandType;
import stockexchange.client.StockExchangeClient;
import stockexchange.client.StockExchangeClientImplementation;
import stockexchange.client.StockExchangeCommand;

@SpringBootApplication
public class Main implements CommandLineRunner{
    @Autowired
	private StockMarketService stockMarketService;
    @Autowired
	private StockExchangeClient stockExchangeClient;
	@Bean
	public StockExchangeClient client(){
	     return new StockExchangeClientImplementation();
	}
	
	@Bean
	@Autowired
	public StockMarketService start1(StockExchangeClient client){
		return new StockMarketService(client);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class , args);
    }
	@Override
	public void run(String... arg0) throws Exception {
		stockExchangeClient.sendCommand(new StockExchangeCommand(StockCommandType.ASK, "client1", "GOOG", 500, 1500, 1000));
	    stockExchangeClient.sendCommand(new StockExchangeCommand(StockCommandType.ASK, "client1", "FB", 200, 700, 1000));
	    stockExchangeClient.sendCommand(new StockExchangeCommand(StockCommandType.ASK, "client1", "IBM", 50, 500, 1000));
	    stockExchangeClient.sendCommand(new StockExchangeCommand(StockCommandType.ASK, "client1", "AMZN", 500, 800, 1000));
	    stockExchangeClient.sendCommand(new StockExchangeCommand(StockCommandType.ASK, "client1", "ORCL", 20, 800, 1000));
	}
	
}
