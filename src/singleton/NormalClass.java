package singleton;

public class NormalClass {
	public NormalClass() {}
	
	public void print() {
		System.out.println("It's print() method in NormalClass instance.");
		System.out.println("instance hashCode > " + this.hashCode());
	}
}
