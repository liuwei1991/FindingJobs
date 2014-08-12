package testCase;

public class Test {
	String[] num = new String[3];
	String[] k = num.clone();
	
	public Test(String[] a){
		this.num = a;
		System.out.println("num="+num[0]);
		System.out.println("k="+k[0]);
	}
	public static void main(String args[]){
		String a[] = {"a","b"};
		Test t = new Test(a);
		
//		StringBuffer sb = new StringBuffer("a");
//		sb.append("b");
//		int a = (int) 1.1;
//		System.out.println(a);
//
//		a = (int) 1.6;
//		System.out.println(a);
	}
}
