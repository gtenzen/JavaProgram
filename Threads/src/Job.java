import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Job extends Thread {
        private int counter;

        @Override
        public void run() {
            synchronized(this) {
                for(int i = 0; i < 100000; i++){
                    counter++;
                
                this.notifyAll();}
            }
        }
    
    
    public static void main(String[] args) throws InterruptedException {
        /*Job job = new Job();
        job.start();
        synchronized(job) {
            job.wait();
        }
        
        System.out.println(job.counter);*/
    	String strValue="today is abs";
    	String a[]=strValue.split(" ");
    	System.out.println(a[0]);
    	List<String> lstWords = Arrays.asList(a);
		Collections.reverse(lstWords);
		System.out.println(lstWords.toString().replaceAll(",", "").
				replace("[", "").replace("]", ""));
    }}