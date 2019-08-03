package threadcomm;

import java.util.ArrayList;

class Local {
	
	ArrayList< Integer> list=new ArrayList<>();
	String addrem=new String("A");
	String remprint=new String("B");
	Boolean r1=false;
	Boolean r2=true;
	
public  void add(){
		
	synchronized (addrem) {
		
		
			System.out.println("add");
			list.add(10);
			
			try{
				
			addrem.notifyAll();}
			catch(Exception e){
				System.out.println("add exception");
			}
			
			System.out.println("after add notify");
		
	}
	
	}
	
	public  void remove() throws InterruptedException{
		
			System.out.println(list.size());
		if(list.size()>0){
			System.out.println(Thread.currentThread().getName());
			synchronized (remprint) {
				System.out.println(Thread.holdsLock(remprint));
				
				
					System.out.println("re");
					
				list.remove(0);
				//remprint="C";
				r2=false;
				if(r1){
					System.out.println("r11111111111");
					r1=false;
					try{
						System.out.println(Thread.holdsLock(remprint));
				remprint.notifyAll();}
					catch(Exception e)
					{System.out.println("exception");}
					finally{
						
					}
				System.out.println("after nofity of remove");
				
				}
			}
		}
		else {
			synchronized (addrem) {
				System.out.println("check");
				addrem.wait();
				System.out.println("ahter");
			}
		}
		}
	
	
	public void print1() throws InterruptedException{
		
				if(!r2){
		synchronized (remprint) {
			System.out.println(Thread.activeCount()+"Print");
				remprint="B";
				System.out.println("object removed");
				//remprint.wait();
			}}
			else {
				synchronized (remprint) {
					System.out.println("pppppp");
					r1=true;
				remprint.wait();
				System.out.println("after print wait");
				
			}
				
			
		}}
	}
