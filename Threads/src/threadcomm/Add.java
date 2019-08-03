package threadcomm;

class Add implements Runnable

{
	Local loc;

	public Add( Local loc) {
		this.loc=loc;
		Thread t1=new Thread(this,"t1");
		t1.start();
	}	
	
	public void run(){
		
		System.out.println("addddd");
		for(int i=0;i<1;i++)
			loc.add();
		}
		
	
	
}
