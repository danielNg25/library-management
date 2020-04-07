package LibraryManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	private static int option;
	
	public static void main(String args[]) {
		System.out.println("Welcome to Truong's Library Manager Application!");
		Library lib = new Library("Truong's Library");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				showMenu();
				askOption();
				if(option == 6)
					break;
				int bookID;
				switch (option){
				
					case 1:
						lib.showLibraryInfor();
						break;
						
					case 2:
						lib.addNewBook();
						break;
						
					case 3:
						System.out.println("3. Find a book");
						System.out.println("---------------------------------");
						System.out.println("Enter book's ID: ");
			
						bookID = scanner.nextInt();
						if (lib.findBook(bookID) == false) {
							System.out.println("Book not found!");
						}
						break;
						
					case 4:		
						System.out.println("4. Borrow a book");
						System.out.println("---------------------------------");
						System.out.println("Enter book's ID: ");
						
						bookID = scanner.nextInt();
						lib.borrowBook(bookID);
						
						break;
						
					case 5:
						System.out.println("5. Return a book");
						System.out.println("---------------------------------");
						System.out.println("Enter book's ID: ");
						
						bookID = scanner.nextInt();
						lib.returnBook(bookID);
						
						break;
					
					default:
						System.out.println("Wrong number!");
						break;
					}
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid number!");
			}
		}
			
		scanner.close();
		
	}
	
	public static void showMenu() {
		System.out.println("========== Main menu ==========");
		System.out.println("1. Show library information");
		System.out.println("2. Add new book");
		System.out.println("3. Find book");
		System.out.println("4. Borrow a book");
		System.out.println("5. Return a book");
		System.out.println("6. Exit");
		System.out.println("===============================");
		System.out.print("Enter menu ID (1-6): ");
	}
	
	public static void askOption() {
		Scanner scanner = new Scanner(System.in);
			option = scanner.nextInt();

		
	}
}
