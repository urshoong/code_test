package singleton;

import java.util.concurrent.Executors;

public class Tester {
	private static final int LIMIT = 5;
	public static void main(String args[]) throws InterruptedException{
		runNormalClass();						delayFnc();
		runEagerInitialization();				delayFnc();
		runStaticBlockInitalization();			delayFnc();
		runLazyInitialization();				delayFnc();
		runThreadSafeInitalization();			delayFnc();
		runThreadSafeInitalizationDCL();		delayFnc();
		runInitializationOnDemandHolderIdiom();	delayFnc();
		runEnumInitialization();
	}
	
	public static void runNormalClass() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				NormalClass normalClass = new NormalClass();
				normalClass.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
		
	}
	
	public static void runEagerInitialization() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				EagerInitialization eagerInitialization = EagerInitialization.getInstance();
				eagerInitialization.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void runStaticBlockInitalization() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				StaticBlockInitalization staticBlockInitalization = StaticBlockInitalization.getInstance();
				staticBlockInitalization.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void runLazyInitialization() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				LazyInitialization lazyInitialization = LazyInitialization.getInstance();
				lazyInitialization.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void runThreadSafeInitalization() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				ThreadSafeInitalization threadSafeInitalization = ThreadSafeInitalization.getInstance();
				threadSafeInitalization.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void runThreadSafeInitalizationDCL() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				ThreadSafeInitalizationDCL threadSafeInitalizationDCL = ThreadSafeInitalizationDCL.getInstance();
				threadSafeInitalizationDCL.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void runInitializationOnDemandHolderIdiom() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				InitializationOnDemandHolderIdiom initializationOnDemandHolderIdiom = InitializationOnDemandHolderIdiom.getInstance();
				initializationOnDemandHolderIdiom.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void runEnumInitialization() {
		for(int i = 0; i < LIMIT; i++) {
			Executors.newSingleThreadExecutor().execute(()->{
			//Executors.newWorkStealingPool().execute(()->{
				EnumInitialization enumInitialization = EnumInitialization.getInstance();
				enumInitialization.print();
				String name = Thread.currentThread().getName();
				System.out.println(name);
			});
		}
	}
	
	public static void delayFnc() throws InterruptedException {
		Thread.sleep(500);
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		Thread.sleep(500);
	}
}