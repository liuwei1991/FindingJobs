package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS使用时要用栈，否则可能迭代次数过多，会造成栈溢出的情况。可以通过leetcode看出两次代码的不同。
 * @author Ares
 *
 */
public class SurroundedRegions {
	class Node{
		int x;
		int y;
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void solve(char[][] board) {
		if(board ==null || board.length==0){
			return ;
		}
		Queue<Node> q = new LinkedList<Node>();
		
		for(int i=0;i<board[0].length;i++){
			if(board[0][i]=='O'){
				q.add(new Node(0,i));
				bfs(board,q);
			}
			if(board[board.length-1][i]=='O'){
				q.add(new Node(board.length-1,i));
				bfs(board,q);
			}
		}
		for(int i=0;i<board.length;i++){
			if(board[i][0]=='O'){
				q.add(new Node(i,0));
				bfs(board,q);
			}
			if(board[i][board[0].length-1]=='O'){
				q.add(new Node(i,board[0].length-1));
				bfs(board,q);
			}
		}
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]=='#'){
					board[i][j]='O';
				}else{
					board[i][j]='X';
				}
			}
		}
		int i=1;
	}
	
	public void bfs(char[][] board,Queue<Node> q){
		while(!q.isEmpty()){
			Node cur = q.poll();
			int i=cur.x;
			int j = cur.y;
			if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O'){
				board[i][j]='#';
				q.add(new Node(i+1,j));
				q.add(new Node(i-1,j));
				q.add(new Node(i,j+1));
				q.add(new Node(i,j-1));
			}
		}
	}
	
	public static void main(String args[]){
		SurroundedRegions sr = new SurroundedRegions();
		char[][] result = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		char[][] result = {{}};

		sr.solve(result);
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
