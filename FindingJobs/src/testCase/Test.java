package testCase;

public class Test {
	public static int k=0;
	public static Test t1= new Test("t1");
	public static Test t2= new Test("t2");
	public static int i=print("i");
	public static int n=99;
	public int j = print("j");
	{
		print("¹¹Ôì¿ì");
	}
	static{
		print("¾²Ì¬¿é");
	}
		
	public Test(String str){
		System.out.println((++k)+":"+str+" i="+i+" n="+n);
		++i;
		++n;
	}
	
	public static int print(String str){
		System.out.println((++k)+":"+str+" i="+i+" n="+n);
		++n;
		return ++i;
	}
	public static void main(String args[]){
		String a[] = {"a","b"};
		Test t = new Test("ini");
//		StringBuffer sb = new StringBuffer("a");
//		sb.append("b");
//		int a = (int) 1.1;
//		System.out.println(a);
//
//		a = (int) 1.6;
//		System.out.println(a);
	}
}
