package leetCode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0){
			return result;
		}
		for(int i=0;i<intervals.size();i++){
			boolean meraged = false;
			for(int j=i+1;j<intervals.size();j++){
				if(canMerage(intervals.get(i),intervals.get(j))){
//					result.add(merage(intervals.get(i),intervals.get(j)));
					intervals.set(j, merage(intervals.get(i),intervals.get(j)));
					meraged = true;
					break;
				}
			}
			if(!meraged){
				result.add(intervals.get(i));
			}
		}
		return result;
    }
	
	public boolean canMerage(Interval a,Interval b){
		if(a.start>b.end || a.end<b.start){
			return false;
		}
		return true;
	}
	public Interval merage(Interval a,Interval b){
		Interval result = new Interval();
		if(a.start>b.start){
			result = new Interval(a.start,a.end);
			a = new Interval(b.start,b.end);
			b = new Interval(result.start,result.end);
		}
		result = new Interval(a.start,Math.max(a.end, b.end));
		return result;
	}
	
	public static void main(String[] args){
		MergeIntervals mi = new MergeIntervals();
		List<Interval> intervals = new ArrayList<Interval>();
		
		intervals.add(mi.new Interval(1,4));
		intervals.add(mi.new Interval(1,4));
//		intervals.add(mi.new Interval(1,4));
		mi.merge(intervals);
	}
	
}
