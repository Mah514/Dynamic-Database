


import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		CVR cvr = new CVR();
		
		System.out.println("Please set the length of the keys: ");
		int keylength = keyboard.nextInt();
		
		cvr.setKeylength(keylength);
		
		System.out.println("Please enter the threshold: ");
		int threshold = keyboard.nextInt();
		
		cvr.setThreshold(threshold);
		System.out.println("How many keys would do you want?: ");
		int numKeys = keyboard.nextInt();
		
		System.out.println("Logging " + numKeys + " keys from our database into CVR");
		
		try {
		Scanner f = new Scanner(new FileInputStream("ar_test_file1.txt"));
		
		String s = f.next();
		int numberOfCars = 0;
		
		while (f.hasNext() && numberOfCars < numKeys) {
			if (s.length() == keylength) {
				System.out.println("Please enter an identifier (value) for the license plate " + s);
				String identifier = keyboard.next();
				cvr.add(s, identifier);
				numberOfCars++;
			}
			s = f.next();
			
			
		}
		System.out.println("Your CVR's Sequence has " + cvr.getS().getSize() + " license plates and they are " + cvr.getS().allKeys());	
		System.out.println("Your CVR's Hashtable has " + cvr.getH().getSize() + " license plates and they are " + cvr.getH().allKeys());
		
		System.out.println("How many license plates would you like to generate? ");
		int newLP = keyboard.nextInt();
		
		System.out.println("Generating " + newLP + " new unique license plates = ");
		cvr.generate2(newLP);
		
		String conti = "";
		do {

			System.out.println("What would you like to do? ADD | REMOVE | NEXT | PREV | GETVALUE");
			String todo = keyboard.next();
			
			if (todo.equalsIgnoreCase("ADD")) {
				String loop = "";
				do {
					System.out.println("Enter a license plate: ");
					String lp = keyboard.next();
					System.out.println("Enter the identifier(value): ");
					String id = keyboard.next();
					cvr.add(lp, id);
					System.out.println("Your car " + lp + " " + id + " has been added to CVR!");
					System.out.println("Your CVR's Sequence has " + cvr.getS().getSize() + " license plates and they are " + cvr.getS().allKeys());	
					System.out.println("Your CVR's Hashtable has " + cvr.getH().getSize() + " license plates and they are " + cvr.getH().allKeys());
					System.out.println("Hashtable number of buckets " + cvr.getH().getNumBuckets());
					System.out.println("Continue? YES | NO");
					loop = keyboard.next();
				} while (loop.equalsIgnoreCase("YES"));
			}
	
		
			if (todo.equalsIgnoreCase("REMOVE")) {
				String loop = "";
				do {
					System.out.println("Enter a license plate: ");
					String lp = keyboard.next();
					//need to check if it exists, like if it doesn't exist, 
					cvr.remove(lp);
				//	System.out.println("Your car " + lp + " has been removed from CVR!");
					System.out.println("Now you have " + cvr.allKeys());
					System.out.println("Your CVR's Sequence has " + cvr.getS().getSize() + " license plates and they are " + cvr.getS().allKeys());	
					System.out.println("Your CVR's Hashtable has " + cvr.getH().getSize() + " license plates and they are " + cvr.getH().allKeys());
					System.out.println("Hashtable number of buckets " + cvr.getH().getNumBuckets());
					System.out.println("Continue? YES | NO");
					loop = keyboard.next();
				} while (loop.equalsIgnoreCase("YES"));
			}
		
			if (todo.equalsIgnoreCase("NEXT")) {
				String loop = "";
				do {
					System.out.println("Check the key next to the key = ");
					String answer = keyboard.next();
					System.out.print("The key after " + answer + " in the database ");
					System.out.print(cvr.allKeys());
					System.out.print(" is ");
					System.out.print(cvr.nextKey(answer));
					System.out.print("\nYou currently have " );
					System.out.println(cvr.allKeys());
					System.out.println("\nContinue? YES | NO");
					loop = keyboard.next();
				} while (loop.equalsIgnoreCase("YES"));
			}
		
		
			if (todo.equalsIgnoreCase("PREV")) {
				String loop = "";
				do {
					System.out.println("Check the key before to the key = ");
					String answer = keyboard.next();
					System.out.print("The key before " + answer + " in the database ");
					System.out.print(cvr.allKeys());
					System.out.print(" is ");
					System.out.print(cvr.prevKey(answer));
					System.out.print("\nYou currently have " );
					System.out.println(cvr.allKeys());
					System.out.println("\nContinue? YES | NO");
					loop = keyboard.next();
				} while (loop.equalsIgnoreCase("YES"));
			}
		
			if (todo.equalsIgnoreCase("GETVALUE")) {
				String loop = "";
				do {
					System.out.println("Enter a license plate: ");
					String lp = keyboard.next();
					System.out.println("Your plate " + lp + " is matched with " + cvr.getValues(lp));
					System.out.println("Your CVR's Sequence has " + cvr.getS().getSize() + " license plates and they are " + cvr.getS().allKeys());	
					System.out.println("Your CVR's Hashtable has " + cvr.getH().getSize() + " license plates and they are " + cvr.getH().allKeys());
					System.out.println("Continue? YES | NO");
					loop = keyboard.next();
				} while (loop.equalsIgnoreCase("YES"));
			}
		
			System.out.println("Another action? YES | NO");
			conti = keyboard.next();
		
		
		} while (conti.equalsIgnoreCase("YES"));
			
		}catch(IOException e){
			System.out.println("not found");
		}
		
		System.out.println("Thank you for using the CVR");
		
	}

}


