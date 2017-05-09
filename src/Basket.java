import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Egg> eggs = new ArrayList<Egg>();
	
	public void putEgg(Egg egg)
	{
		eggs.add(egg);
	}
	
	public void getEgg()
	{
		eggs.get(0);
		eggs.remove(0);
	}
}
