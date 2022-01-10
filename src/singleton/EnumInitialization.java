package singleton;
/**
Joshua Bloch가 작성한 effective java 책에서 enum singleton 방법이 소개 되었다.
enum 이 singleton pattern 으로 사용될 수 있는 이유는 아래와 같다.
 - INSTANCE 가 생성될 때, multi thread 로 부터 안전하다. (추가된 methed 들은 safed 하지 않을 수도 있다.)
 - 단 한번의 인스턴스 생성을 보장한다.
 - 사용이 간편하다.
 - enum value는 자바 프로그램 전역에서 접근이 가능하다.
*/
public enum EnumInitialization {
	INSTANCE;
	static String test = "";
	public static EnumInitialization getInstance() {
		test = "test";
		return INSTANCE;
	}
	
	public void print () {
		System.out.println("It's print() method in EnumInitialization instance.");
		System.out.println("instance hashCode > " + INSTANCE.hashCode());
	}
}