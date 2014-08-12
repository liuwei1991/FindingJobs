package leetCode;

public class AddBinary {
	public String addBinary(String a, String b) {
		if(a==null || b==null){
			return null;
		}
		char[] ca = this.reverse(a.toCharArray());
		char[] cb = this.reverse(b.toCharArray());
		String result = "";
		int i;
		boolean inc = false;
		for (i = 0; i < ca.length && i < cb.length; i++) {
			if (inc) {
				if (ca[i] == '0' && cb[i] == '0') {
					inc = false;
					result += "1";
				} else if (ca[i] == '1' && cb[i] == '1'){
					inc = true;
					result += "1";
				} else {
					inc = true;
					result += "0";
				}
			}else{
				if (ca[i] == '0' && cb[i] == '0') {
					inc = false;
					result += "0";
				} else if (ca[i] == '1' && cb[i] == '1'){
					inc = true;
					result += "0";
				} else {
					inc = false;
					result += "1";
				}
			}
		}
		for(;i<ca.length;i++){
			if(inc){
				if(ca[i]=='1'){
					result+="0";
				}else{
					inc = false;
					result+="1";
				}
			}else{
				result+=ca[i];
			}
		}
		for(;i<cb.length;i++){
			if(inc){
				if(cb[i]=='1'){
					result+="0";
				}else{
					inc = false;
					result+="1";
				}
			}else{
				result+=cb[i];
			}
		}
		if(inc){
			result +="1";
		}
		char[] r = this.reverse(result.toCharArray());
		return String.valueOf(r);
	}

	public char[] reverse(char[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			char t = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = t;
		}
		return a;
	}
	
	public static void main(String[] args){
		AddBinary ab = new AddBinary();
		String a ="1010";
		String b = "1011";
		System.out.println(ab.addBinary(a, b));
	}
}
