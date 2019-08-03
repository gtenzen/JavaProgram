public class Dead implements Runnable

{
	Boolean b = true;
	public final char value[] = null;

	public Dead(String s) {

		// this.value[0]=s.charAt(0);
	}

	public static void main(String[] args) {

		Dead d = new Dead("AMIT");
		String s = new String("Ravi");

		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		t2.start();

	}

	public void method1() throws InterruptedException {
		synchronized (String.class) {
			System.out.println(Thread.holdsLock(String.class));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("In string before after");
			synchronized (Integer.class) {
				System.out.println("dfassafas");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	public void method2() throws InterruptedException {

		synchronized (Integer.class) {
			System.out.println("In Integer before sleep");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("In Integer before After");
			synchronized (String.class) {
				System.out.println("dfas");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

	@Override
	public void run() {

		if (b) {
			b = false;
			try {
				method1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			try {
				method2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
