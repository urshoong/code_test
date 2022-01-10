package singleton;

import java.lang.reflect.Constructor;

public class UsingReflectionToDestroySingleton {
	
	public static void main (String[] args) {
		System.out.println("테스트1");
		testNormalEagerInitialization();
		testNormalInitializationOnDemandHolderIdiom();
		System.out.println("\n테스트2");
		testReflectEagerInitialization();
		testReflectInitializationOnDemandHolderIdiom();
	}
	
	public static void testNormalEagerInitialization() {
		System.out.println("testNormalEagerInitialization()");
		EagerInitialization instance1 = EagerInitialization.getInstance();
		EagerInitialization instance2 = EagerInitialization.getInstance();
		System.out.println("instance1 : " + instance1.hashCode());
		System.out.println("instance2 : " + instance2.hashCode());
	}
	
	public static void testNormalInitializationOnDemandHolderIdiom() {
		System.out.println("testNormalInitializationOnDemandHolderIdiom()");
		InitializationOnDemandHolderIdiom instance1 = InitializationOnDemandHolderIdiom.getInstance();
		InitializationOnDemandHolderIdiom instance2 = InitializationOnDemandHolderIdiom.getInstance();
		System.out.println("instance1 : " + instance1.hashCode());
		System.out.println("instance2 : " + instance2.hashCode());
	}
	
	public static void testReflectEagerInitialization() {
		System.out.println("testReflectEagerInitialization()");
		EagerInitialization instance1 = EagerInitialization.getInstance();
		EagerInitialization instance2 = null;
		
		try {
			Constructor<?>[] constructors = EagerInitialization.class.getDeclaredConstructors();
			for ( Constructor<?> constructor : constructors ) {
				constructor.setAccessible(true);
				instance2 = (EagerInitialization)constructor.newInstance();
			}
		} catch (Exception e) {}
		
		System.out.println("instance1 : " + instance1.hashCode());
		System.out.println("instance2 : " + instance2.hashCode());
	}
	
	public static void testReflectInitializationOnDemandHolderIdiom() {
		System.out.println("testReflectInitializationOnDemandHolderIdiom()");
		InitializationOnDemandHolderIdiom instance1 = InitializationOnDemandHolderIdiom.getInstance();
		InitializationOnDemandHolderIdiom instance2 = null;
		
		try {
			Constructor<?>[] constructors = InitializationOnDemandHolderIdiom.class.getDeclaredConstructors();
			for( Constructor<?> constructor : constructors ) {
				constructor.setAccessible(true);
				instance2 = (InitializationOnDemandHolderIdiom)constructor.newInstance();
			}
		}catch(Exception e) {}
		
		System.out.println("instance1 : " + instance1.hashCode());
		System.out.println("instance2 : " + instance2.hashCode());
	}
}