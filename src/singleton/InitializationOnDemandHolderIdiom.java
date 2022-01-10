package singleton;
/**
미국 메릴랜드 대학의 컴퓨터 과학 연구원인 Bill pugh 가 기존의 java singleton pattern이 가지고 있는 문제들을 해결 하기위해
제시한 새로운 Singleton Pattern이다.
이것은 jvm 의 class loader의 매커니즘과 class의 load 시점을 이용하여 내부 class를 생성시킴으로 thread 간의 동기화 문제를 해결한다.
Synchronized를 사용하지 않아서 성능 저하까지 해결이 가능하다.
현재 java에서 Singleton을 생성시킨다고 하면 거의 위의 방법을 사용한다고 보면 된다.
*/
public class InitializationOnDemandHolderIdiom {
	
	private InitializationOnDemandHolderIdiom () {}
	private static class LazyHolder {
		private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
	}
	
	public static InitializationOnDemandHolderIdiom getInstance () {
//		System.out.println(InitializationOnDemandHolderIdiom.class + " instance create..");
		return LazyHolder.instance;
	}
	
	public void print () {
		System.out.println("It's print() method in InitializationOnDemandHolderIdiom instance.");
		System.out.println("instance hashCode > " + LazyHolder.instance.hashCode());
	}
}