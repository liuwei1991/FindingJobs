package leetCode;

import java.util.ArrayList;

public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        solve(0,0,s,"",result);
		return result;
    }
	
	public void solve(int IpPos,int CharPos,String ip,String befor,ArrayList<String> result){
		if(IpPos == 0){
			if(ip.length()-CharPos-1>=0 && Long.valueOf(ip.substring(CharPos,CharPos+1))<=255){
				solve(1,CharPos+1,ip,ip.substring(CharPos,CharPos+1),result);
			}
			if(ip.length()-CharPos-2>=0 && Long.valueOf(ip.substring(CharPos,CharPos+2))<=255){
				if(ip.charAt(CharPos)=='0'){
					return;
				}
				solve(1,CharPos+2,ip,ip.substring(CharPos,CharPos+2),result);
			}
			if(ip.length()-CharPos-3>=0 && Long.valueOf(ip.substring(CharPos,CharPos+3))<=255){
				if(ip.charAt(CharPos)=='0'){
					return;
				}
				solve(1,CharPos+3,ip,ip.substring(CharPos,CharPos+3),result);
			}
		}else if(IpPos == 1){
			if(ip.length()-CharPos-1>=0 && Long.valueOf(ip.substring(CharPos,CharPos+1))<=255){
				solve(2,CharPos+1,ip,befor+"."+ip.substring(CharPos,CharPos+1),result);
			}
			if(ip.length()-CharPos-2>=0 && Long.valueOf(ip.substring(CharPos,CharPos+2))<=255){
				if(ip.charAt(CharPos)=='0'){
					return;
				}
				solve(2,CharPos+2,ip,befor+"."+ip.substring(CharPos,CharPos+2),result);
			}
			if(ip.length()-CharPos-3>=0 && Long.valueOf(ip.substring(CharPos,CharPos+3))<=255){
				if(ip.charAt(CharPos)=='0'){
					return;
				}
				solve(2,CharPos+3,ip,befor+"."+ip.substring(CharPos,CharPos+3),result);
			}
		}else if(IpPos == 2){
			if(ip.length()-CharPos-1>=0 && Long.valueOf(ip.substring(CharPos,CharPos+1))<=255){
				solve(3,CharPos+1,ip,befor+"."+ip.substring(CharPos,CharPos+1),result);
			}
			if(ip.length()-CharPos-2>=0 && Long.valueOf(ip.substring(CharPos,CharPos+2))<=255){
				if(ip.charAt(CharPos)=='0'){
					return;
				}
				solve(3,CharPos+2,ip,befor+"."+ip.substring(CharPos,CharPos+2),result);
			}
			if(ip.length()-CharPos-3>=0 && Long.valueOf(ip.substring(CharPos,CharPos+3))<=255){
				if(ip.charAt(CharPos)=='0'){
					return;
				}
				solve(3,CharPos+3,ip,befor+"."+ip.substring(CharPos,CharPos+3),result);
			}
		}else if(IpPos == 3){
			if(ip.length()-CharPos>=1 && ip.length()-CharPos<=3 && Long.valueOf(ip.substring(CharPos))<=255){
				if(ip.charAt(CharPos)=='0' && ip.length()-CharPos>1){
					return;
				}
				result.add(befor+"."+ip.substring(CharPos));
			}else{
				return;
			}
		}
	}
	
	public static void main(String[] args){
		RestoreIPAddresses rp = new RestoreIPAddresses();
		String s = "010010";
		System.out.println(rp.restoreIpAddresses(s));
	}
	
}
