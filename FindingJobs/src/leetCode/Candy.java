package leetCode;

public class Candy {
	public int candy(int[] ratings) {
		int result = ratings.length;
		int record[] = new int[ratings.length];
		int num = 1;
		for(int i=1;i<ratings.length;i++){
			if(ratings[i]>ratings[i-1]){
				record[i]=num;
				result += num;
				num ++;
			}else{
				record[i] = 0;
				num = 1;
			}
		}
		num = 1;
		for(int i=ratings.length-2;i>=0;i--){
			if(ratings[i]>ratings[i+1]){
				result += num;
				num++;
			}else{
				result-= Math.min(record[i+1], num-1);
				num = 1;
			}
		}
		return result;
    }
	
	public static void main(String[] args){
		Candy c = new Candy();
		int[] r = {3,2,1};
//		int[] r = {1,2,2};
//		int[] r = {1,2,3,4,5,4,3,6};
		System.out.println(c.candy(r));
	}
}
