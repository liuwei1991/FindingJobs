package testCase;

public class ClassB extends AbstractClassA {
	int price = 1;
	public String name = "car";
	
	
	public class innerClass{
		public String kind = name;
		public int a = ClassB.this.price;
		
		public void m1(){
			int a = ClassB.this.price;
		}
	}


	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
}
