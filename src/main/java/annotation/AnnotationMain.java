package annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AnnotationMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		ArrayList<Field> list =new ArrayList<Field>();
		
	
        Class<Config> cla= Config.class;
        Field [] f=cla.getDeclaredFields();
        for(Field ff:f){          
            list.add(ff); 	
        }
       for(int i=0;i<list.size();i++){
    	  MateAnnotation mate=(MateAnnotation)list.get(i).getAnnotation(MateAnnotation.class);
    	      System.out.println(mate.toString());
    		  list.get(i).setAccessible(true);
    		  list.get(i).set(null, "***");
    	  
       }
          System.out.println(Config.m);
          System.out.println(Config.s);
	}
	

}
