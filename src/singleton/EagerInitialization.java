package singleton;
/**
가장 기본적인 singleton pattern이다. 
전역 변수로 instance를 만드는데 private static을 이용한다. 
static이 붙은 클래스변수는 인스턴스화에 상관없이 사용이 가능하게 된다. 
하지만 앞의 private 접근제어자로 인해 EagerInitialization.instance로의 접근은 불가능하다. 
이런 상태에서 생성자를 private로 명시한다. 생성자를 private로 붙이게되면, new 키워드를 사용할 수 없게된다. 
즉 다른 클래스에서 EagerInitialization instance = new EagerInitialization(); 
이런 방법을 통한 인스턴스 생성은 불가능해진다. 
결국 외부 클래스가 EagerInitialization 클래스의 인스턴스를 가질 수 있는 방법은 
getInstance() method를 사용하는 수 밖에 없다.
리소스가 작은 프로그램일때엔 고도화 대상이 아니다. 하지만 프로그램의 크기가 커져서 
수 많은 클래스에서 위와 같은 singleton pattern을 사용한다고 가정해보자. 
new EagerInitialization();으로 인해 클래스가 load 되는 시점에 인스턴스를 생성시키는데 이
마저도 부담스러울 수가 있다. 또한 이 소스는 EagerInitialization 클래스가 인스턴스화 되는 시점에 
어떠한 에러처리도 할 수가 없다.
*/
public class EagerInitialization {
	// private static 로 선언.
	private static EagerInitialization instance = new EagerInitialization();
	// 생성자
	private EagerInitialization () {}
	// 조회 method
	public static EagerInitialization getInstance () {
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in EagerInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}