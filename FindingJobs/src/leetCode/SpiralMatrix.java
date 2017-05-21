package leetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	if(matrix==null || matrix.length==0){
    		return result;
    	}
    	boolean[][] passed = new boolean[matrix.length][matrix[0].length];
    	
    	int direction = 1;
    	int i=0;
    	int j=0;
    	
    	while(true){
    		if(direction==1 ){
    			for(;j<matrix[0].length&&!passed[i][j];j++){
    				result.add(matrix[i][j]);
    				passed[i][j]= true;
    			}
    			j--;
    			i++;
    			if(i>=matrix.length || passed[i][j]){
    				return result;
    			}
    			direction = 2;
    		}else if(direction ==2){
    			for(;i<matrix.length&&!passed[i][j];i++){
    				result.add(matrix[i][j]);
    				passed[i][j]= true;
    			}
    			i--;
    			j--;
    			if(j<0 || passed[i][j]){
    				return result;
    			}
    			direction = 3;
    		}else if(direction ==3){
    			for(;j>=0&&!passed[i][j];j--){
    				result.add(matrix[i][j]);
    				passed[i][j]= true;
    			}
    			j++;
    			i--;
    			if(passed[i][j]){
    				return result;
    			}
    			direction = 4;
    		}else if(direction ==4){
    			for(;i>=0&&!passed[i][j];i--){
    				result.add(matrix[i][j]);
    				passed[i][j]= true;
    			}
    			i++;
    			j++;
    			if(passed[i][j]){
    				return result;
    			}
    			direction = 1;
    		}
    	}
    }
    public static void main(String[] args){
    	int[][] matrix = {{1}
    					,{4}
    					,{7}
    					};
    	List<Integer> list = new ArrayList<Integer>();
    	SpiralMatrix sm = new SpiralMatrix();
    	list = sm.spiralOrder(matrix);
    	list = null;
    }
}
