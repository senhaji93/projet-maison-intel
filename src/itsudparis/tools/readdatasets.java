
package itsudparis.tools;
import java.io.*; 
public class readdatasets {
	
	public String[] tokens;
    static int[] temperature={2,4,6,8,10,12,14,15,16,17,18,19,20,21,22,21,22,21,22,21,22,21,22,21};
	public static int[] getTemperature() {
		return temperature;
	}
	public static void setTemperature(int[] temperature) {
		readdatasets.temperature = temperature;
	}
	public void readdata(int a) throws IOException{
		File file = new File("data/day1.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  String st2 = ""; 
		  for (int t=0;t<a;t++) {
			  st = br.readLine();
		  }
		 /* while ((st = br.readLine()) != null) {
		    System.out.println(st); 
		  }*/
		  
		  st = br.readLine();
		 
		   this.tokens = st.split(" ");
		   for (int t=0;t<21;t++) {
				 st2= st2+" "+tokens[t]+" ";
			  }
		   System.out.println("---------------------------------------------------------------------------------------------------"); 
		   System.out.println(st2); 
		 
	  }
	public String[] getTokens() {
		return tokens;
	}
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
	
}
	
