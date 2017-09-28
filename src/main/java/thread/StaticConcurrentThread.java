package thread;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class StaticConcurrentThread {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 long start =System.currentTimeMillis();
	
     ConcurrentLinkedQueue<String> list0 =new ConcurrentLinkedQueue<String>();
     ConcurrentLinkedQueue<String> list1 =new ConcurrentLinkedQueue<String>();
     ConcurrentLinkedQueue<String> list2 =new ConcurrentLinkedQueue<String>();
     ConcurrentLinkedQueue<String> list3 =new ConcurrentLinkedQueue<String>();
     ConcurrentLinkedQueue<String> list4 =new ConcurrentLinkedQueue<String>();
     AtomicBoolean bool=new AtomicBoolean(false);
     MusterThread Muster =new MusterThread();
     Muster.setName("Muster");
     Muster.getList(list0, list1, list2, list3, list4, bool);
     WorkThread0 Work0=new WorkThread0();
     Work0.setName("Work0");
     Work0.getList0(list0, bool, Work0.getName());
     WorkThread0 Work1=new WorkThread0();
     Work1.setName("Work1");
     Work1.getList0(list1, bool, Work1.getName());
     WorkThread0 Work2=new WorkThread0();
     Work2.setName("Work2");
     Work2.getList0(list2, bool, Work2.getName());
     WorkThread0 Work3=new WorkThread0();
     Work3.setName("Work3");
     Work3.getList0(list3, bool, Work3.getName());
     WorkThread0 Work4=new WorkThread0();
     Work4.setName("Work4");
     Work4.getList0(list4, bool, Work4.getName());
    // WorkThread0  =new WorkThread0(); 
     Muster.start();
     Work0.start();
     Work1.start();
     Work2.start();
     Work3.start();
     Work4.start();
     long end =System.currentTimeMillis();
     System.out.println(end-start);
	}

}
class MusterThread extends Thread{
	AtomicBoolean bool;
	ConcurrentLinkedQueue<String> list0 =new ConcurrentLinkedQueue<String>();
    ConcurrentLinkedQueue<String> list1 =new ConcurrentLinkedQueue<String>();
    ConcurrentLinkedQueue<String> list2 =new ConcurrentLinkedQueue<String>();
    ConcurrentLinkedQueue<String> list3 =new ConcurrentLinkedQueue<String>();
    ConcurrentLinkedQueue<String> list4 =new ConcurrentLinkedQueue<String>();
    public void getList(ConcurrentLinkedQueue<String> list0,ConcurrentLinkedQueue<String> list1,ConcurrentLinkedQueue<String> list2,
    		ConcurrentLinkedQueue<String> list3,ConcurrentLinkedQueue<String> list4,AtomicBoolean bool){
    	this.bool=bool;
    	this.list0=list0;
    	this.list1=list1;
    	this.list2=list2;
    	this.list3=list3;
    	this.list4=list4;
    	
    }
	public void run(){
		int i=0;
		int j;
		while(true){
			if(i>=10000){
				break;
			}
			j=i%5;
			switch(j){
			case 0 : list0.add("num"+i); break;
			case 1 : list1.add("num"+i); break;
			case 2 : list2.add("num"+i); break;
			case 3 : list3.add("num"+i); break;
			case 4 : list4.add("num"+i); break;			
			}
			++i;
		}
		bool.set(true);		
	}
	
}
class WorkThread0 extends Thread{
	ConcurrentLinkedQueue<String> list0;
	AtomicBoolean bool;
	String name=null;
	public void getList0(ConcurrentLinkedQueue<String> list0,AtomicBoolean bool,String name){
		this.bool=bool;
		this.list0=list0;
		this.name=name;
	}
	
	public void run(){
		while (true){
			if(list0.isEmpty()&&bool.get()){
				break;
			}
			if(!list0.isEmpty()){
				System.out.println(name+": "+list0.poll());
			}
		}
		
	}
	
}

