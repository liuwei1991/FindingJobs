package aaTest;

public class TestAdd {
	public class Pair<T>{
		public T min;
		public T max;
		Pair(T min,T max){
			this.min = min;
			this.max = max;
		}
		
	}
	
	public static <T extends Comparable<T>> Pair<T> minMaz(T[] a){
		if(a==null||a.length==0){
			return null;
		}
		T min = a[0];
		T max = a[0];
		for(T b:a){
			if(b.compareTo(min)<0){
				min = b;
			}
			if(b.compareTo(max)>0){
				max = b;
			}
		}
		return new TestAdd().new Pair<T>(max, max);
	}
	
}
