package leetCode;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		while(path.contains("//")){
			path = path.replaceAll("//", "/");
		}
		for(int i=0;i<path.length();i++){
			String element = this.getElement(i, path);
			if(element == null){
				continue;
			}else if(element.equals("/..")){
				if(s.isEmpty()){
					i+=element.length()-1;
					continue;
				}else{
					s.pop();
				}
			}else if(element.endsWith("/.") || element.equals("/")){
				i+=element.length()-1;
				continue;
			}else{
				s.add(element);
			}
			if(element!=null){
				i+=element.length()-1;
			}
		}
		String result = "";
		for(String ss:s){
			result+=ss;
		}
		if(result.length()<=0){
			return "/";
		}
		return result;
    }
	public String getElement(int start,String path){
		if(start>=path.length()){
			return null;
		}
		String result = "";
//		while(path.charAt(start)=='/'){
//			
//		}
		result += path.charAt(start);
		for(int i=start+1;i<path.length();i++){
			if(path.charAt(i)=='/'){
				return result;
			}else{
				result+=path.charAt(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args){
//		String a = "/";
//		System.out.println(a);
//		System.out.println(a=="/");
		String s = "/a/./b/../../c/";
		s = "/../../..";
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath(s));
	}
}
