package leetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		boolean pass = false;
		Interval tmp = new Interval();
		for(int i=0;i<intervals.size();i++){
			if(pass){
				result.add(intervals.get(i));
			}else{
				if(newInterval.start<intervals.get(i).start){
					tmp.start = newInterval.start;
				}else if(newInterval.start>=intervals.get(i).start && newInterval.start<=intervals.get(i).end ){
					tmp.start = intervals.get(i).start;
				}else{
					result.add(intervals.get(i));
					continue;
				}
				
				while(i<intervals.size()){
					if(newInterval.end<intervals.get(i).start){
						tmp.end = newInterval.end;
						result.add(tmp);
						result.add(intervals.get(i));
						break;
					}
					if(newInterval.end>=intervals.get(i).start && newInterval.end<=intervals.get(i).end){
						tmp.end = intervals.get(i).end;
						result.add(tmp);
						break;
					}
					i++;
				}
				if(i==intervals.size() && newInterval.end>intervals.get(i-1).end){
					tmp.end = newInterval.end;
					result.add(tmp);
				}
				pass = true;
			}
		}
		if(!pass){
			result.add(newInterval);
		}
		return result;
    }
}
