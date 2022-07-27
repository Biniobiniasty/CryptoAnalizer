package Data;

import java.util.HashMap;
import java.util.LinkedHashMap;

import Main.GetData;

public class Analizer {

	public Analizer() {
		update();
	}

	public void update() {

		// getData - download raw data from getData
		HashMap<String, HashMap<String, Double>> DataToAnalis = GetData.getData();

		double theBeastBTCvalue = 0, theBeastBTCvolumen = 0;
		double theBeastETHvalue = 0, theBeastETHvolumen = 0;
		double theBeastBTCBuy = 0, theBeastBTCSell = 0;
		double theBeastETHBuy = 0, theBeastETHSell = 0;

		String BeastBTCBuy = "", BeastBTCSell = "";
		String BeastETHBuy = "", BeastETHSell = "";
		String BeastBTCvalue = "", BeastBTCvolumen = "";
		String BeastETHvalue = "", BeastETHvolumen = "";

		for (String x : DataToAnalis.keySet()) {
			System.out.println("-----------------" + x + "--------------");
			for (String y : DataToAnalis.get(x).keySet()) {
				System.out.println(y + " -> " + DataToAnalis.get(x).get(y));
				if (DataToAnalis.get(x).get(y) > 0) {
					///////////////////////////////////////////////////////////////////////////////////////////////////
					if (y == "ETH (volumen 24h)") {
						if (DataToAnalis.get(x).get(y) > theBeastETHvolumen) {
							theBeastETHvolumen = DataToAnalis.get(x).get(y);
							BeastETHvolumen = x;
						}
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
					if (y == "BTC (volumen 24h)") {
						if (DataToAnalis.get(x).get(y) > theBeastBTCvolumen) {
							theBeastBTCvolumen = DataToAnalis.get(x).get(y);
							BeastBTCvolumen = x;
						}
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
					if (y == "BTC (buy)") {
						if (DataToAnalis.get(x).get(y) > theBeastBTCBuy) {
							theBeastBTCBuy = DataToAnalis.get(x).get(y);
							BeastBTCBuy = x;
						}
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
					if (y == "ETH (value)") {
						if (DataToAnalis.get(x).get(y) > theBeastETHvalue) {
							theBeastETHvalue = DataToAnalis.get(x).get(y);
							BeastETHvalue = x;
						}
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
					if (y == "BTC (value)") {
						if (DataToAnalis.get(x).get(y) > theBeastBTCvalue) {
							theBeastBTCvalue = DataToAnalis.get(x).get(y);
							BeastBTCvalue = x;
						}
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
					if (y == "BTC (sell)") {
						if (DataToAnalis.get(x).get(y) > theBeastBTCSell) {
							theBeastBTCSell = DataToAnalis.get(x).get(y);
							BeastBTCSell = x;
						}

					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
				}
			}
		}

		LinkedHashMap<String, Double> DataAnalis = new LinkedHashMap<>();

		DataAnalis.put("-> " + BeastBTCvolumen + "\n       BTC (volumen 24h) : ", theBeastBTCvolumen);
		DataAnalis.put("-> " + BeastETHvolumen + "\n       ETH (volumen 24h) : ", theBeastETHvolumen);

		DataAnalis.put("-> " + BeastETHvalue + "\n       BTC (value) : ", theBeastBTCvalue);
		DataAnalis.put("-> " + BeastETHvalue + "\n       ETH (value) : ", theBeastETHvalue);
		
		DataAnalis.put("-> " + BeastBTCSell + "\n       BTC (Sell) : ", theBeastBTCSell);
		DataAnalis.put("-> " + BeastBTCBuy + "\n       BTC (Buy) : ", theBeastBTCBuy);

		GetData.setDataAnalis(DataAnalis);

	}
}
