package testCase;

public class ClassC extends ClassB {
//	@Override
//	public void method() {
//		System.out.println("ClassC");
//	}
	protected int a;
	protected int kk(){
		return 2;
	}
	public static void main(String args[]){
		ClassC c = new ClassC();
		AbstractClassA aa = c;
		aa.method();
	}
}
