package enum_test;

enum Type{
	WALKING("워킹화"), 
	RUNNING("러닝화"), 
	TRACKING("트래킹화"), 
	HIKING("등산화");
	
	private String name;
	private Type(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}

public class tester1 {
	public static void main(String[] args) {
		for(Type type: Type.values()) {
			System.out.println(type.getName());
			System.out.println();
		}
		
	}
}
