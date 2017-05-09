import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args)
	{
		//share resource
		Basket basket = new Basket();
		//mutex makes sure only one thread keep going,
		//initial int for the constructor has to be 1
		Semaphore mutex = new Semaphore(1);
		//semaphore is the max number of threads that
		//are allowed to access the share resource at the same time
		Semaphore semaphore = new Semaphore(0);
		
		Hen hen = new Hen(basket, mutex, semaphore);
		Jack jack = new Jack(basket, mutex, semaphore);
		
		Thread thread1 = new Thread(hen, "hen");
		Thread thread2 = new Thread(jack, "jack_0");
		Thread thread3 = new Thread(jack, "jack_1");
		Thread thread4 = new Thread(jack, "jack_2");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
