package Main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class GetData {

	private static volatile HashMap<String, HashMap<String, Double>> Data = new HashMap<>();
	private static volatile LinkedHashMap<String, Double> AnalisData = new LinkedHashMap<>();
	
	public static synchronized HashMap<String, HashMap<String, Double>> getData() {
		return Data;
	}

	public static synchronized void setData(String name, HashMap<String, Double> newData) {
		Data.put(name, newData); 
	}

	public static synchronized void setDataAnalis(LinkedHashMap<String, Double> newData)
	{
		AnalisData.clear();
		AnalisData.putAll(newData);
	}
	public static synchronized LinkedHashMap<String, Double> getDataAnalis() {
		return AnalisData;
	}
}
