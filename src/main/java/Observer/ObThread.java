package Observer;

import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ObThread {

	public void startWork(final Observer Parsefunction, JProgressBar progress, JLabel label, JComboBox listTime) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				
				long TimeNow = System.currentTimeMillis();
				long TimeLast = TimeNow;
				int counter = 0; 

				Random r = new Random();

				int countTime = 50;

				
				counter++;
				label.setText("Download data " + counter + " times");
				Parsefunction.ParseFunction();
				
				while (true) {
					
					if(listTime.getSelectedIndex() == 0)
						countTime = 25;
					if(listTime.getSelectedIndex() == 1)
						countTime = 30;
					if(listTime.getSelectedIndex() == 2)
						countTime = 45;
					if(listTime.getSelectedIndex() == 3)
						countTime = 60;
					if(listTime.getSelectedIndex() == 4)
						countTime = 80;
					if(listTime.getSelectedIndex() == 5)
						countTime = 100;
					if(listTime.getSelectedIndex() == 6)
						countTime = 120;
					if(listTime.getSelectedIndex() == 7)
						countTime = 150;
					if(listTime.getSelectedIndex() == 8)
						countTime = 200;
					if(listTime.getSelectedIndex() == 9)
						countTime = 250;
					if(listTime.getSelectedIndex() == 10)
						countTime = 300;
					if(listTime.getSelectedIndex() == 11)
						countTime = 500;
					if(listTime.getSelectedIndex() == 12)
						countTime = 750;
					if(listTime.getSelectedIndex() == 13)
						countTime = 1000;
					
					for (int x = r.nextInt(20); x <= 100; x++) {
						TimeNow = System.currentTimeMillis();
						long showTime = (int)((TimeNow-TimeLast)/1000);
						label.setText("Download data " + counter + " times" + " (" + Long.toString(showTime) + " s)");
						progress.setValue(x);
						try {
							Thread.sleep(r.nextInt(10, 120));
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
					}

					TimeNow = System.currentTimeMillis();
					if (TimeNow - TimeLast > 1000 * countTime) {
						counter++;
						label.setText("Download data " + counter + " times");
						Parsefunction.ParseFunction();
						TimeLast = TimeNow;
					}
				}
			}
		});

		thread.start();
	}
}
