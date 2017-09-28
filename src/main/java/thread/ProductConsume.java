package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProductConsume {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AtomicBoolean flag=new AtomicBoolean(false);
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(500);
		ProductThread a = new ProductThread();
		a.getQueue(queue,flag);
		ConsumeThread b = new ConsumeThread();
		b.putQueue(queue,flag);
		a.start();
		b.start();
	}

}

class ProductThread extends Thread {
	ArrayBlockingQueue<String> queue;
	AtomicBoolean flag;
	public void getQueue(ArrayBlockingQueue<String> queue,AtomicBoolean flag) {
		this.queue = queue;
		this.flag=flag;
	}

	public void run() {
		int i=0;
		while(true){
		 if(i>=10000)
			 break;
		 else{
	   try {
		queue.put("num" +i);
		i++;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 }	
		}
		flag.set(true);
		
	}
}

class ConsumeThread extends Thread {
	ArrayBlockingQueue<String> queue;
	AtomicBoolean flag;
	public void putQueue(ArrayBlockingQueue<String> queue,AtomicBoolean flag) {
		this.queue = queue;
		this.flag=flag;
	}
	public void run() {		
		while (true) {
			try {
				if(queue.isEmpty()&&flag.get())
					break;
				
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
