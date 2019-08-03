
public class ths extends Thread{
	
	
	public void run(){
		System.out.println("inside");
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		ths obj= new ths();
		Thread t=new Thread(obj);
		t.start();
		Thread t1=new Thread(obj);
		t1.start();
		
	}

}
