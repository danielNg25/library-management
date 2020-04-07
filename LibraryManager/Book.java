package LibraryManager;

public class Book {
	
	private int bookID;
	private String bookTitle;
	private int amount;
	private int available;
	
	
	public Book() {
		this.setBookID(0);
		this.setBookTitle("Unknow");
		this.setAmount(0);
		this.setAvailable(0);
	}
	
	public Book(int bookID, String bookTitle, int amount) {
		this.setBookID(bookID);
		this.setBookTitle(bookTitle);
		this.setAmount(amount);
		this.setAvailable(this.getAmount());
	}
	
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		if (available >= 0 && available <= this.amount)
			this.available = available;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public void showBookInfo() {
		System.out.println("Book ID: " + this.bookID);
		System.out.println("Book Title: " + this.bookTitle);
		System.out.println("Total Amount: " + this.amount);
		System.out.println("Available: " + this.available);
	}
	
}
