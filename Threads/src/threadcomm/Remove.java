package threadcomm;

class Remove implements Runnable{
	
	Local loc;
	public Remove(Local loc) {
		this.loc=loc;
		Thread t2=new Thread(this,"t2");
		t2.start();
	}
	
	public void run(){
		try {
			System.out.println("remmmmmm");
			for(int i=0;i<2;i++)
			loc.remove();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}