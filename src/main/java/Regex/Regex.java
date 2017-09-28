package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String pattern ="(\\/\\S*wxq)(\\/)(\\S*)(\\/)";
	    // String line ="/search/hello";
	      String line ="/mpp-data/l/data04/data_wxq/tp_wxq_target_v1/fedf4468a34a3a69/0000015e3abcb8000000015e3fe313ff/0/index";
	      Pattern r =Pattern.compile(pattern);
	      Matcher m= r.matcher(line);
	      if(m.find()){
	      System.out.println(m.group(0));
	      System.out.println(m.group(1));
	      System.out.println(m.group(2));
	      System.out.println(m.group(3));
	      System.out.println(m.group(4));
	      System.out.println(m.group(6));
		}
       
       
	}

}
