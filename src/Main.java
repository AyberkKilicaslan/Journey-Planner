import java.io.FileNotFoundException;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		
		try {
			Application app = new Application();
		} catch (FileNotFoundException e) {
			System.out.println("Application did not work");
		}
		
	}
}
