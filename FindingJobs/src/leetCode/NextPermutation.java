package leetCode;

public class NextPermutation {
	public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int pos;
		int last=num[num.length-1];
        for(pos = num.length-2;pos>=0;pos--){
        	if(num[pos]<last){
        		break;
        	}
        	last = num[pos];
        }
        transfor(num,pos);
    }
	
	public void transfor(int[] num,int begin){
		if(begin == -1){
			for(int i=0;i<num.length/2;i++){
				int tmp = num[i];
				num[i] = num[num.length-1-i];
				num[num.length-1-i] = tmp;
			}
		}else{
			int biggerIndex=num.length-1;
			for(int i=begin+1;i<num.length;i++){
				if(num[begin] >=num[i]){
					biggerIndex = i-1;
					break;
				}
			}
			int tmp = num[biggerIndex];
			num[biggerIndex] = num[begin];
			num[begin] = tmp;
		
			for(int i = begin+1;i<=(begin+1+num.length-1)/2;i++){
				tmp = num[i];
				num[i] =  num[num.length-1+begin+1 -i];
				num[num.length-1+begin+1 -i] = tmp;
			}
		}
	}
	
	public static void main(String args[]){
		NextPermutation np = new NextPermutation();
//		int[] num = {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] num ={1,3,2};
		np.nextPermutation(num);
		
		for(int i:num){
			System.out.println(i);
		}
		
	}
}
