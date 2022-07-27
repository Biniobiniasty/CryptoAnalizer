package Data;

import java.util.HashMap;

import Harvaster.Check;
import Main.GetData;
import Main.ShowData;

public class Segregation {

	
	public Segregation(Check newData)
	{
		// Here i incoming class "check" with valid data.
		
		HashMap<String, Double> map = new HashMap<>();
		
		map.put("BTC (sell)", newData.getSellBTC());
		map.put("BTC (buy)", newData.getBuyBTC());
		map.put("BTC (volumen 24h)", newData.getBTCvolumen());
		map.put("BTC (value)", newData.getBTCvalue());
		map.put("ETH (volumen 24h)", newData.getETHvolumen());
		map.put("ETH (value)", newData.getETHvalue());
		
		GetData.setData(newData.getName(), map);
		
		new Analizer();		
		new ShowData();
	}
	
}
