package threadcomm;

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
			System.out.println("prinnn");
			for(int i=0;i<2;i++)
			loc.print1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}