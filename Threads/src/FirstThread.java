class FirstThread {

 public static void main(String [] args) {

SecondThread b = new SecondThread();
b.setName("Second");

 b.start();



 synchronized(b) {

 System.out.println("Waiting for b to complete...");

 System.out.println("Value is: " + b.value);

 }

 }}
 class SecondThread extends Thread {

 int value;



 public void run() {
System.out.println("run");
 synchronized(this) {
	 System.out.println(this);

 for(int i=0;i<10;i++) {

 value += i;

 }

 notify();

 }}}