

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Boolean salir = true;
		while (salir) {
			String opcion = input.next();
			switch (opcion) {
				case "r":
					break;
				case "l":
					break;
				case "e":
					break;
				case "x":
					input.close();
					break;
				default:
					break;
			}
		}
	}
}
