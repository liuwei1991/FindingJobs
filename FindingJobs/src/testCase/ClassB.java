package testCase;

public class ClassB extends AbstractClassA {
	int price = 1;
	public String name = "car";
	
	@Override
	public void method() {
		System.out.println("ClassB");
	}
	
	public class innerClass{
		public String kind = name;
		public int a = ClassB.this.price;
		
		public void m1(){
			int a = ClassB.this.price;
		}
	}
}
