package Harvaster;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Check {

	// Here is checked data
	private static volatile Queue<Check> DataToSeg = new ArrayDeque<>();

	private HashMap<String, String> data;
	private boolean vaildData;
	private int counterConfirmation;

	private synchronized static void addData(Check newData) {
		if (newData.vaildData)
			DataToSeg.add(newData);
	}

	public synchronized static Check getData() {
		if (DataToSeg.size() > 0)
			return DataToSeg.remove();
		return null;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Check(String name) {
		vaildData = false;
		counterConfirmation = 0;
		data = new HashMap<>();
		data.put("name", name);
		checkName(name);
	}

	public boolean checkAndPut() {
		if (counterConfirmation == 7) // every function checked have to add to one
		{
			vaildData = true;
			addData(this);
			return true;
		}
		return false;
	}

	public void addData(String name, String value) {
		data.put(name, value);
	}

////////////////////////////////////////SETTERS/////////////////////////////////////

	public boolean setETHvalue(String value) {
		if (checkETHvalue(value)) {
			addData("ETH-value", value);
			return true;
		}
		return false;
	}

	public boolean setBTCvolumen(String value) {
		if (checkBTCvolumen(value)) {
			addData("BTC-volumen", value);
			return true;
		}
		return false;
	}

	public boolean setBTCvalue(String value) {
		if (checkBTCvalue(value)) {
			addData("BTC-value", value);
			return true;
		}
		return false;
	}

	public boolean setETHvolumen(String value) {
		if (checkETHvolumen(value)) {
			addData("ETH-volumen", value);
			return true;
		}
		return false;
	}

	public boolean setSellBTC(String value) {
		if (checkSellBTC(value)) {
			addData("Sell-BTC", value);
			return true;
		}
		return false;
	}

	public boolean setBuyBTC(String value) {
		if (checkBuyBTC(value)) {
			addData("Buy-BTC", value);
			return true;
		}
		return false;
	}

////////////////////////////////////////GETTERS/////////////////////////////////////
	public double getETHvalue() {
		return Double.parseDouble(data.get("ETH-value"));
	}

	public double getBTCvalue() {
		return Double.parseDouble(data.get("BTC-value"));
	}

	public String getName() {
		return data.get("name");
	}

	public double getSellBTC() {
		return Double.parseDouble(data.get("Sell-BTC"));
	}

	public double getBuyBTC() {
		return Double.parseDouble(data.get("Buy-BTC"));
	}

	public double getETHvolumen() {
		return Double.parseDouble(data.get("ETH-volumen"));
	}

	public double getBTCvolumen() {
		return Double.parseDouble(data.get("BTC-volumen"));
	}

///////////////////////////////////////CHECK DATA////////////////////////////////////
	private boolean checkETHvalue(String value) {
		counterConfirmation++;
		return true;
	}

	private boolean checkName(String name) {
		if (name.length() > 0) {
			counterConfirmation++;
			return true;
		}
		return false;
	}

	private boolean checkSellBTC(String sell) {
		if (checkDigit(sell)) {
			counterConfirmation++;
			return true;
		}
		return false;
	}

	private boolean checkBuyBTC(String buy) {
		if (checkDigit(buy)) {
			counterConfirmation++;
			return true;
		}
		return false;	}

	private boolean checkETHvolumen(String value) {
		if (checkDigit(value)) {
			counterConfirmation++;
			return true;
		}
		return false;}

	private boolean checkBTCvalue(String buy) {
		if (checkDigit(buy)) {
			counterConfirmation++;
			return true;
		}
		return false;}

	private boolean checkBTCvolumen(String value) {
		if (checkDigit(value)) {
			counterConfirmation++;
			return true;
		}
		return false;}

	private boolean checkDigit(String value) {
		int counter = 0;
		boolean result = false;

		for (int x = 0; x < value.length(); x++) {
			char znak = value.toCharArray()[x];
			if (znak == '0' || znak == '1' || znak == '2' || znak == '3' || znak == '4' || znak == '5' || znak == '6'
					|| znak == '7' || znak == '8' || znak == '9' || znak == '.') {
				counter++;
				continue;
			}
		}

		if (counter == value.length())
			result = true;

		return result;
	}

}
