package singleton;
/**
new LazyInitialization(); 가 어디에 선언되었는지 주목해보자. 
getInstance() method 안에서 사용되었다. 
if문을 이용해 instance가 null 인 경우에만 new를 사용해 객체를 생성하였다. 
최초 사용시점에만 인스턴스화 시키기 때문에 프로그램이 메모리에 적재되는 시점에 부담이 많이 줄게된다. 
하지만 여전히 문제는 남아있다. 
만약 프로그램이 muilti thread 방식이라면 지금의 singleton pattern은 안전하지 않다. 
동일 시점에 getInstance() method를 호출하면 인스턴스가 두번 생길 위험이 있다.
*/
public class LazyInitialization {
	
	private static LazyInitialization instance;
	private LazyInitialization () {}
	
	public static LazyInitialization getInstance () {
		if ( instance == null )
			instance = new LazyInitialization();
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in LazyInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}