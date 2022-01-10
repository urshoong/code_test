package ThreadTest;

public class StaticFunction {
	private static String HERO;
	
	public static void main(String args[]) {
		System.out.println("Test start!");
		new Thread(()->{
			for(int i = 0; i < 1000000; i++) {
				StaticFunction.batman();
			}
		}) .start();
		
		new Thread(()->{
			for(int i = 0; i < 1000000; i++) {
				StaticFunction.superman();
			}
		}) .start();
		
		StaticFunction staticFunction = new StaticFunction();
		new Thread(()->{
			for(int i = 0; i < 1000000; i++) {
				staticFunction.ironman();
			}
		}) .start();
		System.out.println("Test end!");
	}
	
	
	public static synchronized void batman() {
		HERO = "batman";
		
		try {
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
			if("batman".equals(HERO) == false) {
				System.out.println("synchronization broken - batman");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized void superman() {
		HERO = "superman";
		
		try {
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
			if("superman".equals(HERO) == false) {
				System.out.println("synchronization broken - superman");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void ironman() {
		HERO = "ironman";
		
		try {
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
			if("ironman".equals(HERO) == false) {
				System.out.println("synchronization broken - ironman");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
