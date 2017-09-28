package thread;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class DynaticConcurrentThread {
	
	
	static AtomicBoolean bool = new AtomicBoolean(false);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		make();
		
	}
	public static void make(){ 
		ConcurrentMap<String, ConcurrentLinkedQueue<String>> listMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<String>>();
		int i = 0;
		int j;
		for (i = 0; i < 100; i++) {
			j = i % 5;
			if (listMap.get(Integer.toString(j)) == null) {
				// System.out.println(listMap.get(j));
				listMap.put(Integer.toString(j), new ConcurrentLinkedQueue<String>());
				listMap.get(Integer.toString(j)).add("$$" + i);
				WorkThread work = new WorkThread();
				System.out.println("new work");
				work.setName("Work" + j);
				work.getList(listMap.get(Integer.toString(j)), bool, work.getName());
				work.start();
			} else {
				listMap.get(Integer.toString(j)).add("num" + i);
			}
		}
		bool.set(true);
	}

}

class WorkThread extends Thread {
	ConcurrentLinkedQueue<String> list;
	AtomicBoolean bool;
	String name = null;

	public void getList(ConcurrentLinkedQueue<String> list, AtomicBoolean bool, String name) {
		this.bool = bool;
		this.list = list;
		this.name = name;
	}

	public void run() {
		System.out.println("%%%%%%%%%%%");
		while (true) {
			if (list.isEmpty() && bool.get()) {
				break;
			}
			if (!list.isEmpty()) {
				System.out.println(name + ": " + list.poll());
			}
		}

	}

}