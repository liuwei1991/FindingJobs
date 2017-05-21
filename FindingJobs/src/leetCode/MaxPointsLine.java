package leetCode;

import java.util.Iterator;
import java.util.TreeMap;

public class MaxPointsLine {
	class Point {
		int x;
		int y;
		Point() {
			x = 0; y = 0; 
		}
		Point(int a, int b) {
			x = a; y = b; 
		}
	}
	
	 public int maxPoints(Point[] points) {
		 TreeMap<Double,Integer> tm = new TreeMap<Double,Integer>();
		 if(points.length == 0) return 0;
		 int result=1;
		 for(int i=0; i<points.length; i++){
			 int selfNum = 1;
			 for(int j=0; j<points.length; j++){
				 if(i ==j) continue;
				 double k;
				 if((points[i].x == points[j].x) && (points[i].y == points[j].y)){
					 Iterator<Double> it = tm.keySet().iterator();
					 while(it.hasNext()){
						 Double key = it.next();
						 int tmp = tm.get(key);
						 tm.put(key, tmp+1);
					 }
					 if(!tm.containsKey(0.0)){
						 tm.put(0.0, 2);
					 }
					 selfNum += 1;
					 continue;
				 }else if(points[i].x == points[j].x){
					 k = Double.MAX_VALUE;
				 }else{
					 k = (points[i].y - points[j].y)/(1.0*(points[i].x - points[j].x));
				 }
				 
				 if(tm.containsKey(k)){
					 int value = tm.get(k)+1;
					 tm.put(k, value);
				 }else{
					 tm.put(k, selfNum+1);
				 }
			 }
			 Iterator<Double> it = tm.keySet().iterator();
			 while(it.hasNext()){
				 int tmp = tm.get(it.next());
				 if(tmp > result){
					 result = tmp;
				 }
			 }
			 if(selfNum>result){
				 result = selfNum;
			 }
			 tm.clear();
		 }
		 return result;
	 }
	 
	 public static void main(String args[]){
		 MaxPointsLine mp = new MaxPointsLine();
		 Point[] ps = new Point[9];
		 ps[0] = mp.new Point(84,250);
		 ps[1] = mp.new Point(0,0);
		 ps[2] = mp.new Point(1,0);
		 ps[3] = mp.new Point(0,-70);
		 ps[4] = mp.new Point(0,-70);
		 ps[5] = mp.new Point(1,-1);
		 ps[6] = mp.new Point(21,10);
		 ps[7] = mp.new Point(42,90);
		 ps[8] = mp.new Point(-42,-230);
		 System.out.println(mp.maxPoints(ps));
	 }
}
