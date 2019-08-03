package threadcomm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executor=Executors.newSingleThreadExecutor();
		
		for(int i=0;i<26;i++) {
			executor.execute(new Task());
			executor.execute(new Task());
		}
		//Thread.sleep(10l);
		executor.shutdownNow();

	}

}

class Task implements Runnable {
	
	private static char smallLetter= 'a';
	private static char capitalLetter= 'A';
	private static boolean flag=true;

	@Override
	public void run() {

		if (flag) {
			System.out.println(capitalLetter);
			flag=false;
			capitalLetter++;
		}else {
			flag=true;
			System.out.println(smallLetter);
			smallLetter++;
		}
		
	}
	
	
	
}
