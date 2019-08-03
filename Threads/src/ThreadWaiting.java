import java.util.ArrayList;


public class ThreadWaiting // extends Thread 
{
	
	
	public static void main(String[] args) {
		
		Local loc=new Local();
		printt pr=new printt(loc);
		Add add=new Add(loc);
		Remove rem=new Remove(loc);
		
		
		
	}
	
}

class Local {
	
	ArrayList< Integer> list=new ArrayList<>();
	Boolean addrem=true;
	Boolean remprint=true;
	
public  void add(){
		
	synchronized (addrem) {
		System.out.println("add");
		for(int i=0;i<10;i++){
			
			list.add(10);
			addrem.notify();
		}
	}
	
	}
	
	public  void remove() throws InterruptedException{
		
		if(list.size()>0){
			synchronized (remprint) {
				System.out.println("re");
				for(int i=0;i<10;i++){
				list.remove(0);
				remprint=false;
				remprint.notify();
			}
		}}
		else
			synchronized (addrem) {
				addrem.wait();
			}
		
	}
	
	public void print1() throws InterruptedException{
		
		synchronized (remprint) {
			if(!remprint){
				remprint=true;
				System.out.println("object removed");
				remprint.wait();
			}
			else
				remprint.wait();
			
		}
	}
}
class Add implements Runnable

{
	Local loc;

	public Add( Local loc) {
		this.loc=loc;
		Thread t1=new Thread(this,"t1");
		t1.start();
	}	
	
	public void run(){
			loc.add();
		}
		
	
	
}

class Remove implements Runnable{
	
	Local loc;
	public Remove(Local loc) {
		this.loc=loc;
		Thread t2=new Thread(this,"t2");
		t2.start();
	}
	
	public void run(){
		try {
			loc.remove();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}

class printt implements Runnable{
	Local loc;
	public printt(Local loc) {
		// TODO Auto-generated constructor stub
	this.loc=loc;
	Thread t3=new Thread(this,"t3");
	t3.start();
	
	}
	@Override
	public void run() {
		try {
			loc.print1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}