package Data;

import java.util.ArrayDeque;
import java.util.Queue;

import Harvaster.Check;

public class Storage implements Runnable {

	// Here is valid data 
	private static volatile Queue<Storage> storageData = new ArrayDeque<>();

	public synchronized void addStorage(Storage newStorage) {
		storageData.add(newStorage);
	}

	public synchronized Storage getStorage() {
		if (storageData.size() > 0)
			return storageData.remove();
		return null;
	}

	public Storage() {
		Thread storage = new Thread(this); 
		storage.start();
	}

	@Override
	public void run() {
		while (true) {
			Check newData = Check.getData();
			if (newData != null)
				new Segregation(newData);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
