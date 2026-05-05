import java.util.ArrayList;
import javax.swing.JComponent;

public class CarQueue implements Runnable
{
	ArrayList<Integer> directions = new ArrayList<>();
	private CarQueue myCar;
	JComponent component;
	
	public CarQueue()
	{
		component = new CarPanel(0, 0, 1, myCar);
	}
	public void addToQueue()
	{
		directions.add(0);
		directions.add(1);
		directions.add(2);
		directions.add(3);
	}
	
	public int deleteQueue()
	{
		int direction = directions.get(0);
		directions.remove(0);
		return direction;
	}

	@Override
	public void run()
	{
		try
		{
			Runnable r = new CarQueue();
			Thread t = new Thread(r);
			Car a = new Car(10, 20, component);
			Car b = new Car(50, 90, component);
			Car c = new Car(120, 60, component);
			Car d = new Car(200, 80, component);
			Car e = new Car(150, 40, component);
			
			t.start();
			for (int i = 0; i < 5; i++)
			{
				myCar.addToQueue();
			}
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
