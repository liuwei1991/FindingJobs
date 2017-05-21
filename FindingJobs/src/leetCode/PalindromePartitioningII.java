package leetCode;

public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}
		boolean matrix[][] = new boolean[s.length()][s.length()];
		int cut[] = new int[s.length()+1];
		
		for(int i=0;i<=s.length();i++){
			cut[i] = s.length()-i-1;
		}
		for(int i=s.length()-2;i>=0;i--){
			for(int j=i;j<s.length();j++){
				if(((j-i<2) && s.charAt(i)==s.charAt(j)) 
					|| (s.charAt(i)==s.charAt(j) && matrix[i+1][j-1])){
					matrix[i][j]=true;
					cut[i] = Math.min(cut[i],cut[j+1]+1);
				}
			}
		}
		//因为在计算cut[s.length]的时候，多加了一个1；
		return cut[0];
		
		
		
	}
	
	public int minCutk(String s) {  
        int min = 0;  
        int len = s.length();  
        boolean[][] matrix = new boolean[len][len];  
        int cuts[] = new int[len+1];  
          
        if (s == null || s.length() == 0)  
            return min;  
        //初始化cuts里面的值为最坏情况的值  
        for (int i=0; i<len; ++i){  
            cuts[i] = len - i;  
        }  
        //dp过程  
        for (int i=len-1; i>=0; --i){  
            for (int j=i; j<len; ++j){  
                if ((s.charAt(i) == s.charAt(j) && (j-i<2))  
                        || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))  
                {  
                    matrix[i][j] = true;  
                    cuts[i] = getMinValue(cuts[i], cuts[j+1]+1);  
                }  
            }  
        }  
        min = cuts[0];  
        return min-1;  
    }  
      
    public int getMinValue(int a, int b){  
        return a > b ? b : a;  
    }  
      
	
	public static void main(String[] args){
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s = "cdd";
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(pp.minCut(s));
	}
}
