package google2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemC {
	private char[][] status ;
	private boolean[][] redStatus;
	private boolean[][] blueStatus;
	
	public void setStatus(char[][] status){
		this.status = status;
		this.redStatus = new boolean[this.status.length][this.status.length];
		this.blueStatus = new boolean[this.status.length][this.status.length];
	}
	
	public boolean dfsRed(int x,int y){
		if(!onBoard(x,y)){
			return false;
		}
		if(this.redStatus[x][y] == true){
			return false;
		}
		
		if(this.status[x][y]!='R'){
			return false;
		}
		this.redStatus[x][y] = true;
		if(x==this.status.length-1 && this.status[x][y]=='R'){
			this.status[x][y]='r';
			return true;
		}else if(dfsRed(x-1,y)){
			this.status[x][y]='r';
			return true;
		}else if(dfsRed(x-1,y+1)){
			this.status[x][y]='r';
			return true;
		}else if(dfsRed(x,y-1)){
			this.status[x][y]='r';
			return true;
		}else if(dfsRed(x,y+1)){
			this.status[x][y]='r';
			return true;
		}else if(dfsRed(x+1,y-1)){
			this.status[x][y]='r';
			return true;
		}else if(dfsRed(x+1,y)){
			this.status[x][y]='r';
			return true;
		}
		
		return false;
	}
	
	public boolean dfsBule(int x,int y){
		if(!onBoard(x,y)){
			return false;
		}
		if(this.blueStatus[x][y] == true){
			return false;
		}
		
		if(this.status[x][y]!='B'){
			return false;
		}
		this.blueStatus[x][y] = true;
		if(y==this.status.length-1 && this.status[x][y]=='B'){
			this.status[x][y]='b';
			return true;
		}else if(dfsBule(x-1,y)){
			this.status[x][y]='b';
			return true;
		}else if(dfsBule(x-1,y+1)){
			this.status[x][y]='b';
			return true;
		}else if(dfsBule(x,y-1)){
			this.status[x][y]='b';
			return true;
		}else if(dfsBule(x,y+1)){
			this.status[x][y]='b';
			return true;
		}else if(dfsBule(x+1,y-1)){
			this.status[x][y]='b';
			return true;
		}else if(dfsBule(x+1,y)){
			this.status[x][y]='b';
			return true;
		}
		
		return false;
	}
	
	public String solve() {
		int blueNum = 0;
		int redNum = 0;
		int n = this.status.length;
		this.redStatus = new boolean[this.status.length][this.status.length];
		this.blueStatus = new boolean[this.status.length][this.status.length];
		for(int j=0;j<n;j++){
			for(int k=0;k<n;k++){
				
				if(status[j][k]=='B'){
					blueNum ++;
				}else if(status[j][k]=='R'){
					redNum++;
				}
			}
		}
		if(!(blueNum - redNum ==1) && !(redNum - blueNum ==1) && !(redNum - blueNum == 0)){
			return "Impossible";
		}
		
		int bluePathNum = 0;
		int redPathNum = 0;
		for(int i=0;i<n;i++){
			if(dfsRed(0,i)){
				this.status[0][i]='r';
				redPathNum ++;
			}
			if(dfsBule(i,0)){
				this.status[0][i]='b';
				bluePathNum ++;
			}
		}
		if(redPathNum == 1){
			if(blueNum > redNum){
				return "Impossible";
			}
			return "Red wins";
		}else if(bluePathNum == 1){
			if(redNum > blueNum){
				return "Impossible";
			}
			return "Blue wins";
		}else if(redPathNum == 0 && bluePathNum == 0){
			return "Nobody wins";
		}else{
			return "Impossible";
		}
	}
	
	public boolean onBoard(int x,int y){
		int n = this.status.length;
		if (x>=0 && x<=n-1 && y>=0 && y<=n-1){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
//		BufferedReader reader=new BufferedReader(new FileReader("D://a.in"));
//		BufferedReader reader = new BuffledReader(new FileReader("d://adadfa"));
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter writer=new BufferedWriter(new FileWriter("/opt/google/problemc"));
		ProblemC p = new ProblemC();
		int t=Integer.parseInt(reader.readLine());
		for(int i=1;i<=t;i++){
			int n = Integer.parseInt(reader.readLine());
			char[][] status = new char[n][]; 
			for(int j=0;j<n;j++){
				status[j]=reader.readLine().toCharArray();
			}
			p.setStatus(status);
			if(i!=t){
				writer.write("Case #"+i+": "+p.solve()+"\n");
			}
			else{
				writer.write("Case #"+i+": "+p.solve());
			}
		}
		reader.close();
		writer.close();
	}
}
