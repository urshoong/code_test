package singleton;
/**
DLC(Double-Checking Locking)을 사용하면, 일단 인스턴스가 생성되어 있는지 확인한 다음, 생성되어있지 않았을 때만 동기화를 할 수 있다.
이렇게 하면 처음에만 동기화를 하고 나중에는 동기화를 하지 않아도 된다.
getInstance() 메소드를 사용할 떄 속도가 문제가 될 수 있다면 이런식으로 Singleton을 구현함으로써 오버헤드를 극적으로 줄일 수 있다.
※volatile 키워드
https://nesoy.github.io/articles/2018-06/Java-volatile
*/
public class ThreadSafeInitalizationDCL {
	private volatile static ThreadSafeInitalizationDCL instance;
	
	private ThreadSafeInitalizationDCL() {}
	
	public static ThreadSafeInitalizationDCL getInstance() {
		if(instance == null) {
			synchronized (ThreadSafeInitalizationDCL.class) {
				if(instance == null)
					instance = new ThreadSafeInitalizationDCL();
			}
		}
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in ThreadSafeInitalizationDCL instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
