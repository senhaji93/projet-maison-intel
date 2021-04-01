


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class hie {
	public static String millisecondToFullTime(long millisecond) {
	    return timeUnitToFullTime(millisecond, TimeUnit.MILLISECONDS);
	}

	public static String secondToFullTime(long second) {
	    return timeUnitToFullTime(second, TimeUnit.SECONDS);
	}

	public static String timeUnitToFullTime(long time, TimeUnit timeUnit) {
	    long day = timeUnit.toDays(time);
	    long hour = timeUnit.toHours(time) % 24;
	    long minute = timeUnit.toMinutes(time) % 60;
	    long second = timeUnit.toSeconds(time) % 60;
	    if (day > 0) {
	        return String.format("%dday %02d:%02d:%02d", day, hour, minute, second);
	    } else if (hour > 0) {
	        return String.format("%d:%02d:%02d", hour, minute, second);
	    } else if (minute > 0) {
	        return String.format("00:%d:%02d", minute, second);
	    } else {
	        return String.format("00:00:%02d", second);
	    }
	}
	public static void main(String[] args) throws IOException {
		File file = new File("data/DAY_1.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  FileWriter fw = new FileWriter("data/filename.txt");
		  String st; 
		  int i=0;
		  
		 while ((st = br.readLine()) != null) {
			 fw.write( secondToFullTime(i) + " " + st+"\r\n");
			  System.out.println(secondToFullTime(i) + " " + st);
			  i++;
		  }
		 fw.close();
	  
	
	}
}
