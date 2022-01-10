package singleton;
/**
문제가 되었던 muilit thread문제를 해결하기 위해 synchronized(동기화)를 사용하여 singleton pattern을 구현한다. 
여러 thread들이 동시에 접근해서 인스턴스를 생성시키는 위험은 없어졌다. 
하지만 수 많은 thread 들이 getInstance() method 를 호출하게 되면 높은 cost 비용으로 인해 프로그램 전반에 성능저하가 일어난다.
*/
public class ThreadSafeInitalization {
	
	private static ThreadSafeInitalization instance;
	private ThreadSafeInitalization () {}
	
	public static synchronized ThreadSafeInitalization getInstance () {
		if (instance == null)
			instance = new ThreadSafeInitalization();
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in ThreadSafeInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
	
}