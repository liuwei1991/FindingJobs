package google2014;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProblemA {

	public static void main(String[] args) throws IOException{
//		BufferedReader reader=new BufferedReader(new FileReader("D://a.in"));
		
		
		
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter writer=new BufferedWriter(new FileWriter("/opt/test/problema"));
		
		int num=Integer.parseInt(reader.readLine());
		for(int i=0;i<num;i++){
			String[] line=reader.readLine().split(" ");
			
			writer.write("dfg");
		}
		
		reader.close();
		writer.close();
	}
	
}