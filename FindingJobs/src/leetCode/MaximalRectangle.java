package leetCode;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0){
        	return 0;
        }
		int r[] = new int[matrix[0].length];
        int l[] = new int[matrix[0].length];
        int h[] = new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
        	r[i] = matrix[0].length;
        	l[i] = 0;
        	h[i] = 0;
        }
        int result = 0;
        for(int i=0;i<matrix.length;i++){
        	int left = 0;
        	int right = matrix[0].length;
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]=='1'){
        			h[j]++;
        			l[j]=Math.max(l[j], left);
        		}else{
        			h[j] = 0;
        			l[j] = 0;
        			r[j] = matrix[0].length;
        			left = j+1;
        		}
        	}
        	
        	for(int j=matrix[0].length-1;j>=0;j--){
        		if(matrix[i][j]=='1'){
        			r[j] = Math.min(r[j], right);
        			result = Math.max(result, h[j]*(r[j]-l[j]));
        		}else{
        			right = j;
        		}
        	}
        }
        return result;
    }
	public static void main(String[] args){
		char[][] matrix={{'1'}};
		MaximalRectangle mr = new MaximalRectangle();
		System.out.println(mr.maximalRectangle(matrix));
	}
}
