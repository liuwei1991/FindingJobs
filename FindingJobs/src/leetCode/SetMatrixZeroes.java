package leetCode;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix==null){
			return;
		}
		if(matrix.length==0 || matrix[0].length==0){
			return;
		}
//		unsigned int row[] = new int[matrix.length/32];
        boolean row[] = new boolean[matrix.length];
        boolean column[] = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			row[i] = true;
        			column[j] = true;
        		}
        	}
        }
        for(int i=0;i<row.length;i++){
        	if(row[i]==true){
        		for(int j=0;j<matrix[0].length;j++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int i=0;i<column.length;i++){
        	if(column[i]==true){
        		for(int j=0;j<matrix.length;j++){
        			matrix[j][i] = 0;
        		}
        	}
        }
    }
	
	public static void main(String[] args){
		SetMatrixZeroes sm = new SetMatrixZeroes();
		int[][] matrix = {{1,2,3},{0,1,2},{3,54,0},{1,2,2}};
		sm.setZeroes(matrix);
	}
}
