import java.util.concurrent.Semaphore;

public class Jack implements Runnable{

	private Basket basket;
	private Semaphore mutex, semaphore;

	public Jack(Basket basket, Semaphore mutex, Semaphore semaphore)
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
				//since initial int of semaphore is 0,
				//Jack thread has to wait till Hen thread release().
				this.semaphore.acquire();
				
				this.mutex.acquire();
				this.basket.getEgg();
				System.out.println(Thread.currentThread().getName() + " get an egg");
				this.mutex.release();
				
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
