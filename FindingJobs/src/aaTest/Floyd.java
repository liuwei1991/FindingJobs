package aaTest;

import java.util.ArrayList;
import java.util.List;

public class Floyd {
	public int floyd(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		for (int k = 0; k < grid.length; k++) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
				}
			}
		}
		return grid[0][grid.length - 1];
	}

	public int dijkstra(int[][] grid) {
		List<Integer> visited = new ArrayList<Integer>();
		int[] dis = new int[grid.length];
		for(int i=0;i<grid.length;i++){
			dis[i] = grid[0][i];
		}
		visited.add(0);
		
		for(int i=1;i<grid.length;i++){
			int minIndex = -1;
			int minDis = Integer.MAX_VALUE;
			//在所有未加入的点中找一个 距离原点0最短的
			for(int j=0;j<grid.length;j++){
				if(!visited.contains(j) && dis[j]<minDis){
					minIndex = j;
					minDis = dis[j];
				}
			}
			visited.add(minIndex);
			//更新所有未加入点距离原点0的距离
			for(int j=0;j<grid.length;j++){
				if(!visited.contains(j))
					dis[j] = Math.min(dis[j], dis[minIndex] + grid[minIndex][j]);
			}
		}
		return dis[grid.length-1];
	}

	public int aStare(int[][] grid) {
		
	}
}
