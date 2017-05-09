import java.util.concurrent.Semaphore;

public class Hen implements Runnable{

	private Basket basket;
	private Semaphore mutex, semaphore;

	public Hen(Basket basket, Semaphore mutex, Semaphore semaphore)
	{
		this.basket = basket;
		this.mutex = mutex;
		this.semaphore = semaphore;
	}

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				//when acquire() is called, int of Semaphore will minus 1,
				//when its 0, thread will be suspended.
				mutex.acquire();
				Egg egg = new Egg();
				this.basket.putEgg(egg);
				System.out.println(Thread.currentThread().getName() + " put an egg");
				//when release() is called, int of Semaphore will add 1
				mutex.release();
				
				semaphore.release();
				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
