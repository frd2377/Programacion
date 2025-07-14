package view;

public class Main {

	public static void main(String[] args) {
		try {
			ViewProducts viewProducts = new ViewProducts();
			viewProducts.setVisible(true);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
	}
	
	
}
