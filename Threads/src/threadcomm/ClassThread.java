package threadcomm;

class Defualt{
	private double actBal=1000;
	
	int j=0;
public  void debit(double amt) throws InterruptedException{
		
			System.out.println("account bal is insufficient");
			if(j==1){
			
			synchronized (this) {
				
				
				this.wait();
				
				
				
			}
			}
			actBal -= amt;
			System.out.println(actBal);
			synchronized (this) {
				j=1;
				this.notify();
			}
			
		}
	public  void credit(double amt) throws InterruptedException {
		
		if(j==0){
		synchronized (this) {
			this.wait();
			
			
		}
		}
		actBal+=amt;
		System.out.println(actBal);
		System.out.println("after credit the bal is "+actBal);
		synchronized (this) {
			j=0;
			this.notify();
		}
		
			
			
			
	}
	
}
class Debit extends Thread{
	Defualt d;
	public Debit(Defualt d1) {
		d= d1;
	}
	

	public void run(){
		System.out.println(Thread.currentThread().getName());
		try {
			for(int i=0;i<5;i++)
			d.debit(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Credit extends Thread{
	Defualt d;
	public Credit (Defualt d1)
	{
		d= d1;
		
	}
	public void run(){
		System.out.println(Thread.currentThread().getName());
		try {
			for(int i=0;i<5;i++)
			d.credit(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class ClassThread {

	
	public static void main(String[] args) {
		Defualt d1 = new Defualt();
		Credit c = new Credit(d1);
		Debit d = new Debit(d1);
		
		d.start();
		
		c. start();
	}

}
