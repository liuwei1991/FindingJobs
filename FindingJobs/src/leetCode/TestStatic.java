package leetCode;

public class TestStatic {
	TestStatic a = new TestStatic();

//	{
//		System.out.println("void");
//		
//	}
	
		static MinimumPathSum mps = new MinimumPathSum();
	
	static{
		System.out.println("b");
	}

	
	public TestStatic(){
		System.out.println("ts");
	}
	
	public class A{
		public A(){
			System.out.println("A");
		}
	}
	
	
	public static void main(String args[]){
		TestStatic ts = new TestStatic();
	}
}
