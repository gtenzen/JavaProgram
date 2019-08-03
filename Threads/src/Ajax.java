


public class Ajax implements Runnable{

	private   int value;
	private int i=0;
	public synchronized void months() throws InterruptedException{
		
		setValue(15);
		/*Thread.sleep(5000);*/
	}
	
public synchronized int getValue() {
		return value;
	}

public synchronized  void setValue(int value) {
	this.value = value;
}

public synchronized void year() throws InterruptedException{
		
		setValue(20);
		/*Thread.sleep(5000);*/
	}
	public  void run(String s) throws InterruptedException{
		if(s.equals("january")){
			System.out.println("january"+s);
			months();
			
		}
		if(s.equals("year")){
			System.out.println("year"+s);
			year();
			
		}
		System.out.println(value);
		}
		
	
	
	public static void main(String[] args) throws InterruptedException {
		Ajax s=new Ajax();
		Thread t= new Thread(s);
		t.setName("first");
		t.start();
		
		Thread t1= new Thread(s);
		t1.setName("second");
		
		t1.start();
		
		}
		
	
	@Override
	public void run() {
		if(i==0){
			
			System.out.println(Thread.currentThread().getName());
		try {
			i=1;
			
			run("january");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		else if (i==1){
			i=0;
			
			System.out.println(Thread.currentThread().getName());
			try {
				run("year");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



}
