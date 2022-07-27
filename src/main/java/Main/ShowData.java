package Main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class ShowData {

	public ShowData() {
		updateComboBoxList();
		updateAnalis();
	}

	public void updateComboBoxList() {

		List<String> list = new ArrayList<>();
		StringBuilder text = new StringBuilder();
		boolean first = false;

		for (String x : GetData.getData().keySet()) {
			list.add(x);
			if (!first) {
				first = true;
				for (String y : GetData.getData().get(x).keySet()) {
					text.append("  ");
					text.append(y);
					text.append("  :  ");
					text.append(GetData.getData().get(x).get(y));
					text.append("\n");
				}
			}
		}
		Main.comboBox.setModel(new DefaultComboBoxModel(list.toArray()));
		Main.textPane.setText(text.toString());
	}

	// To change on comboBox
	public static void updateText() {

		// We can get data according index, becouse listRool have this order.
		int index = 0;
		StringBuilder text = new StringBuilder();

		for (String x : GetData.getData().keySet()) {

			if (index == Main.comboBox.getSelectedIndex()) {
				for (String y : GetData.getData().get(x).keySet()) {
					text.append("  ");
					text.append(y);
					text.append("  :  ");
					text.append(GetData.getData().get(x).get(y));
					text.append("\n");
				}
				break;
			}
			index++;
		}
		Main.textPane.setText(text.toString());

	}

	public void updateAnalis() {

		StringBuilder dataToShow = new StringBuilder();

		for (String x : GetData.getDataAnalis().keySet()) {
			if (GetData.getDataAnalis().get(x) > 0) {
				dataToShow.append(x);
				dataToShow.append(GetData.getDataAnalis().get(x));
				dataToShow.append("\n");
			}
		}

		Main.textPane_1.setText(dataToShow.toString());

	}

}
