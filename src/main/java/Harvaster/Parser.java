package Harvaster;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse1() throws IOException {

		Document html = Jsoup.connect("https://coinmarketcap.com/").timeout(6000).get();
		Elements diwa = html.select("a.cmc-link");

		int counter = 0;
		boolean check = false;
		int endData = 0;
		int counterData = 0;

		Check data = new Check("coinmarketcap.com");

		for (Element e : diwa) {

			if (check) {
				String stringData = e.text().substring(1, e.text().length() - 2);
				int indexp = stringData.indexOf('.');
				StringBuilder newString = new StringBuilder();

				for (int i = 0; i < stringData.length(); i++) {
					if (i == indexp) {
						newString.append('.');
					}
					if (stringData.toCharArray()[i] != ',' && stringData.toCharArray()[i] != '.')
						newString.append(stringData.toCharArray()[i]);
				}

				System.out.println(newString.toString());
				stringData = newString.toString();

				if (counterData == 0)
					data.setBTCvalue(stringData);
				if (counterData == 1)
					data.setBTCvolumen(stringData);
				if (counterData == 2)
					data.setETHvalue(stringData);
				if (counterData == 3)
					data.setETHvolumen(stringData);
				counterData++;

				counter++;
				if (counter >= 2) {
					check = false;
					endData++;
					counter = 0;
				}
			}
			if (endData >= 2)
				break;
			if (e.text().contains("Bitcoin") || e.text().contains("Ethe")) {
				check = true;
			}

		}
		html.clearAttributes();
		data.setSellBTC("0");
		data.setBuyBTC("0");
		data.checkAndPut();

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse2() throws IOException {

		Document html = Jsoup.connect("https://www.coingecko.com/").timeout(6000).get();

		Check data = new Check("coingecko.com");

		Elements el = html.select("span.no-wrap");
		int counter = 0;

		for (Element e : el) {

			String newString = e.text();
			StringBuilder string = new StringBuilder();
			for (int x = 0; x < newString.length() - 1; x++)
				if (newString.toCharArray()[x] != ',' && newString.toCharArray()[x] != '$')
					string.append(newString.toCharArray()[x]);
			newString = string.toString();
			if (counter == 0)
				data.setBTCvalue(newString);
			if (counter == 1)
				data.setBTCvolumen(newString);
			if (counter == 4)
				data.setETHvalue(newString);
			if (counter == 5)
				data.setETHvolumen(newString);
			counter++;
		}

		html.clearAttributes();
		data.setSellBTC("0");
		data.setBuyBTC("0");
		data.checkAndPut();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse3() {
//		Check data = new Check("Spr1");
//		data.setSellBTC("23");
//		data.setBuyBTC("88");
//		data.setBTCvalue("44");
//		data.setBTCvolumen("89");
//		data.setETHvolumen("12");
//		data.setETHvalue("54");
//		data.checkAndPut();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse4() {
//		Check data = new Check("Spr2");
//		data.setSellBTC("243");
//		data.setBuyBTC("8");
//		data.setBTCvalue("4");
//		data.setBTCvolumen("829");
//		data.setETHvolumen("2");
//		data.setETHvalue("574");
//		data.checkAndPut();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse5() {
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse6() {
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse7() {
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void parse8() {
	}
}
