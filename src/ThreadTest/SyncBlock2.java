package ThreadTest;

import java.util.HashMap;

public class SyncBlock2 {
	private HashMap<String, String> mMap1 = new HashMap<String, String>();
	private HashMap<String, String> mMap2 = new HashMap<String, String>();
	
	private final Object object1 = new Object();
	private final Object object2 = new Object();
	
	public static void main(String args[]) {
		SyncBlock2 syncBlock2 = new SyncBlock2();
		System.out.println("Test start!");
		new Thread(() -> {
			for(int i = 0; i < 10000; i++) {
				syncBlock2.put1("A", "B");
				syncBlock2.get2("C");
			}
		}).start();
		
		new Thread(() -> {
			for(int i = 0; i < 10000; i++) {
				syncBlock2.put2("C", "D");
				syncBlock2.get1("A");
			}
		}).start();
		
		System.out.println("Test end!");
	}
	
	public void put1(String key, String value) {
		synchronized (object1) {
			mMap1.put(key, value);
		}
	}
	
	public String get1(String key) {
		synchronized (object1) {
			return mMap1.get(key);
		}
	}
	
	public void put2(String key, String value) {
		synchronized (object2) {
			mMap2.put(key, value);
		}
	}
	
	public String get2(String key) {
		synchronized (object2) {
			return mMap2.get(key);
		}
	}
}
