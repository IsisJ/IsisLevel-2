package org.jointheleague;

public class Arrays {

	public static void main(String[] args) {

		String[] names = new String[3];
		int[] numbers = new int[3];

		names[2] = "David";
		names[0] = "Esme";
		names[1] = "Isis";
		//names[3] = "Michiyo";
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		numbers[2] = 3;
		numbers[1] = 2;
		numbers[0] = 1;
		for( int i= 2; i>=0; i--){
			System.out.println(numbers[i]);
		}

	}

}
