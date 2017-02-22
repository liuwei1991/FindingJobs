package astart.leetcode1;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int r = 0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[i].length;j++){
        		if(grid[i][j]==1){
        			if(i-1<0 || grid[i-1][j]==0){
        				r+=1;
        			}
        			if(j-1<0 || grid[i][j-1]==0){
        				r+=1;
        			}
        			if(j+1>=grid[i].length || grid[i][j+1]==0){
        				r+=1;
        			}
        			if(i+1>=grid.length || grid[i+1][j]==0){
        				r+=1;
        			}
        		}
        	}
        }
        return r;
    }
}
