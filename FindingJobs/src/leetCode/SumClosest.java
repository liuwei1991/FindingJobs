package leetCode;

public class SumClosest {
	 public int threeSumClosest(int[] num, int target) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		 int result = num[0]+num[1]+num[2];
		 int distance = result - target>=0?result - target:target - result;
		 for(int i = 0;i<num.length-1;i++){
			 for(int j=i+1;j<num.length;j++){
				 for(int k=j+1;k<num.length;k++){
					 int distmp = num[i]+num[j]+num[k] - target;
					 if(distmp <0) distmp = -1*distmp;
					 if(distmp < distance){
						 distance = distmp;
						 result = num[i]+num[j]+num[k] ;
					 }
				 }
			 }
		 }
		 return result;
	 }
	 
	 public static void main(String[] args){
		 SumClosest sc = new SumClosest();
		 int[] a = {-1,2,1,-4};
		 int target = 1;
		 System.out.println(sc.threeSumClosest(a, target));
	 }
}
