
public class EjemploGroovy {

	public static void main(String[] args) {
		
		String[] list = new String[] {"Rod", "Carlos", "Chris"};
		
		for (String item : list) {
			
			if (item.length() <= 4) System.out.println(item);
			
		}
		
	}
}
