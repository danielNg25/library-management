package LibraryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Random;

public class Library {
	
	private String libraryName;
	private List<Book> bookList;
	private static int numberOfBooks;
	public static final int MAX_NUMBER_BOOKS = 100;
	
	
	public Library(String name) {
		this.libraryName = name;
		this.bookList = new ArrayList<> ();
	}
	
	
	public void addNewBook() {
		if (numberOfBooks >= MAX_NUMBER_BOOKS) {
			System.out.println("The library is full!");
		}
		else {
			Scanner scannerInt = new Scanner(System.in);
			Scanner scannerLine = new Scanner(System.in);
			System.out.println("2. Add a new book");
			System.out.println("---------------------------------");
			System.out.println("Enter book's information:");
			int bookID;
			while (true) {
				int test = 0;
				System.out.print(" (1) Book ID: ");
				bookID = scannerInt.nextInt();
				for (Book book: bookList ) {
					if (book.getBookID() == bookID) {
						System.out.println("Book's ID already exists!");
						test = 1;
						break;
					}
				}
				if (test == 0)
					break;
			}
			
			System.out.print(" (2) Book Title: ");
			String bookTitle = scannerLine.nextLine();
			System.out.print(" (3) Amount: ");
			int amount = scannerInt.nextInt();
			Book book = new Book(bookID, bookTitle, amount);
			bookList.add(book);
			
		}	
		
	}
	
	public boolean findBook(int bookID) {

		for (Book book: bookList ) {
			if (book.getBookID() == bookID) {
				book.showBookInfo();
				return true;
			}
		}
		return false;
	}
	
	public void borrowBook(int bookID) {
		int test = 0;
		for (Book book: bookList ) {
			if (book.getBookID() == bookID) {
				test = 1;
				book.showBookInfo();
				if (book.getAvailable() == 0) {
					System.out.println("No more book to borrow!");
				}
				else {
					System.out.println("The book is borrowed successfully!");
					book.setAvailable(book.getAvailable() - 1);
					book.showBookInfo();
					break;
				}
			}
		}
		if (test == 0)
			System.out.println("Book not found!");
		
	}
	
	public void returnBook(int bookID) {
		int test = 0;
		for (Book book: bookList ) {
			if (book.getBookID() == bookID) {
				test = 1;
				book.showBookInfo();
				if (book.getAvailable() == book.getAmount()) {
					System.out.println("Is that our Library's book???");
				}
				else {
					System.out.println("The book is returned successfully!");
					book.setAvailable(book.getAvailable() + 1);
					book.showBookInfo();
					break;
				}
			}
		}
		if (test == 0)
			System.out.println("Book not found!");
	}
	
	public void showLibraryInfor() {
		System.out.println(this.libraryName);
		System.out.println(numberOfBooks);
		for (Book book: bookList ) {
			book.showBookInfo();
		}
	}
	
	public boolean findBook(String keyword) {
		String[] keyList = keyword.split(" ");
		int test = 0;
		for (Book book: this.bookList) {
			for (String key: keyList) {
				if (book.getBookTitle().contains(key)) {
					test = 1;
					book.showBookInfo();
					break;					
				}
			}
			
		}
		if (test != 0)
			return true;
		return false;
		
	}
	
	public Book getALuckyBook() {
		Random rand = new Random();
		Book luckyBook = this.bookList.get(rand.nextInt(this.bookList.size()));
		return luckyBook;
	}
		
		
	
}
