package aaTest;

public class MySingleton {
	public static String str = null;
	
	public static String getSingleton(){
		if(str==null){
			synchronized(str){
				if(str==null){
					str = "afdads";
				}
			}
		}
		return str;
	}
}
