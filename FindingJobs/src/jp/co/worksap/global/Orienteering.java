package jp.co.worksap.global;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Orienteering {
	private char[][] originalMatrix = null;
	private int[][] distanceMatrix = null;
	private List<Node> checkPoints = new ArrayList<Node>();	//all the checkpoints,'S' and 'G'.
	private int endIndex = -1;	
	int nodeNumber;	//total number of checkpoints, 'S' and 'G'.
	
	Orienteering(char[][] matrix){
		this.nodeNumber = 1;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j]=='S'){
					matrix[i][j] = (char) (0);
					checkPoints.add(new Node(i,j,0));
				}else if(matrix[i][j]=='G' || matrix[i][j]=='@'){
					if(matrix[i][j]=='G'){
						endIndex = nodeNumber;
					}
					matrix[i][j] = (char) (nodeNumber);	//mark checkpoints, 'S','G'.
					checkPoints.add(new Node(i,j,nodeNumber));
					nodeNumber++;
				}
			}
		}
		this.originalMatrix = matrix;
	}
	
	/**
	 * Using BFS to get the shortest distance between this node and all other checkpoints, and update the result to distanceMatrix.
	 * @param node
	 */
	public void updateDistanceMatrix(Node node){
		Queue<Node> q = new LinkedList<Node>();
		boolean passed[][] = new boolean[originalMatrix.length][originalMatrix[0].length];
		q.add(node);
		passed[node.x][node.y] = true;
		int startIndex = node.id;
		int superNumber = 1; // the number of nodes that has the distance of ( current node distance -1) from the start node.
		int stepNumber = 1; // the distance between the current node from the start node.
		// using BFS
		while(true){
			int thisNumber = 0;  // mark the node number that has the distance of stepNumber from the start node. 
			// when BFS has no way to search, just get out of the loop.
			if(superNumber<=0){
				break;
			}
			for(int j=0; j<superNumber; j++){
				Node current = q.poll();
				//left
				if(current.y-1 >= 0){
					if(!passed[current.x][current.y-1]){
						char c = originalMatrix[current.x][current.y-1];
						if(c!='#'){
							if(c != '.'){
								this.distanceMatrix[startIndex][c] = stepNumber;
								this.distanceMatrix[c][startIndex] = stepNumber;
							}
							passed[current.x][current.y-1] = true;
							q.add(new Node(current.x,current.y-1));
							thisNumber++;
						}
					}
				}
				//right
				if(current.y+1 < originalMatrix[0].length){
					if(!passed[current.x][current.y+1]){
						char c = originalMatrix[current.x][current.y+1];
						if(c!='#'){
							if(c != '.'){
								this.distanceMatrix[startIndex][c] = stepNumber;
								this.distanceMatrix[c][startIndex] = stepNumber;
							}
							passed[current.x][current.y+1] = true;
							q.add(new Node(current.x,current.y+1));
							thisNumber++;
						}
					}
				}
				//up
				if(current.x-1 >= 0){
					if(!passed[current.x-1][current.y]){
						char c = originalMatrix[current.x-1][current.y];
						if(c!='#'){
							if(c != '.'){
								this.distanceMatrix[startIndex][c] = stepNumber;
								this.distanceMatrix[c][startIndex] = stepNumber;
							}
							passed[current.x-1][current.y] = true;
							q.add(new Node(current.x-1,current.y));
							thisNumber++;
						}
					}
				}
				//down
				if(current.x+1 < originalMatrix.length){
					if(!passed[current.x+1][current.y]){
						char c = originalMatrix[current.x+1][current.y];
						if(c!='#'){
							if(c != '.'){
								this.distanceMatrix[startIndex][c] = stepNumber;
								this.distanceMatrix[c][startIndex] = stepNumber;
							}
							passed[current.x+1][current.y] = true;
							q.add(new Node(current.x+1,current.y));
							thisNumber++;
						}
					}
				}
			}
			superNumber = thisNumber;
			stepNumber ++;
		}
	}
	
	/**
	 * Get all the distance between any two checkpoints, and update the result to distanceMatrix.
	 */
	public void prepareDistanceMatrix(){
		this.distanceMatrix = new int[this.nodeNumber][this.nodeNumber];
		
		for(int i=0; i<checkPoints.size(); i++){
			this.updateDistanceMatrix(checkPoints.get(i));
		}
	}
	
	/**
	 * Get the final result of the problem.
	 * @return
	 */
	public int getResult(){
		this.prepareDistanceMatrix();
		
		// if there are checkpoints that S can't arrive, return -1.
		for(int i=1; i<this.distanceMatrix[0].length; i++){
			if(this.distanceMatrix[0][i] == 0){
				return -1;
			}
		}
		
		// dynamic programming. Using binary to mark the status, 1 stands for having arrived this node, 0 stands for having not arrived.
		// dp[i][j] means the cost of status 'i' when the last node is j.
		int[][] dp = new int[1<<(this.nodeNumber-1)][this.nodeNumber];
		
		for(int i=0; i<(1<<(this.nodeNumber-1)); i++){
			for(int j=1; j<this.nodeNumber; j++){
				if((i&(1<<(j-1)))!=0){  //状态i中经过城市j
					if(i==(1<<(j-1))) {  //状态i只经过城市j
						dp[i][j]=distanceMatrix[0][j];
					}else{
						dp[i][j]=Integer.MAX_VALUE;  
						for(int k=1; k<this.nodeNumber; k++){
							if(j!=k && (i&(1<<(k-1)))!=0){ //枚举状态i经过的不是城市j的其他城市k
								dp[i][j]=dp[i][j]>dp[i^(1<<(j-1))][k]+distanceMatrix[k][j]?dp[i^(1<<(j-1))][k]+distanceMatrix[k][j]:dp[i][j];
							}
						}
					}
				}
			}
		}
		
	    // having arrived all checkpoints including 'S' and 'G', and the final node is 'G'(this.endIndex)
		return dp[(1<<(this.nodeNumber-1))-1][this.endIndex]; 
	}

	class Node{
		public int x = -1;
		public int y = -1;
		public int id = -1;
		
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		Node(int x,int y,int id){
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		Scanner in =  new Scanner(System.in);
		int w,h;
		w = in.nextInt();
		h = in.nextInt();
		
		if(w<=0 || h<=0){
			throw new Exception("Input is illegal!");
		}
		
		char[][] matrix = new char[h][w];
		for(int i=0;i<h;i++){
			matrix[i] = in.next().toCharArray();
		}
		
		Orienteering or = new Orienteering(matrix);
		int result = or.getResult();
		System.out.println(result);
	}
}


