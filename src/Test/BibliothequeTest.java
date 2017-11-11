package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Exception.LibraryException;
import Project.Bibliotheque;
import Project.Book;
import Project.User;
import junit.framework.TestCase;

public class BibliothequeTest extends TestCase {

	List<Book> listofbooks = new ArrayList();
	List<User> listofUsers = new ArrayList();

	public void testgetBook() {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		listofbooks.add(booktotest);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		final Optional result = Optional.of(bibliothequetotest.getBook("4"));
		// then ?
		assertNotNull(result);
	}

	public void testgsearchBooksByAuteur() {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		final Book booktotest2 = new Book(5, "456DEF", "Voltaire", "Candide", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		final List<Book> result = bibliothequetotest.searchBooks("Voltaire");
		// then ?
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	public void testgsearchBooksByIsbn() {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		final Book booktotest2 = new Book(5, "456DEF", "Voltaire", "Zadig", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		final List<Book> result1 = bibliothequetotest.searchBooks("123ABC");
		final List<Book> result2 = bibliothequetotest.searchBooks("456DEF");
		// then ?
		assertNotNull(result1);
		assertNotNull(result2);
		assertEquals(1, result1.size());
		assertEquals(1, result2.size());
	}

	public void testgsearchBooksByTitre() {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		final Book booktotest2 = new Book(5, "456DEF", "Voltaire", "Zadig", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		final List<Book> result1 = bibliothequetotest.searchBooks("Candide");
		final List<Book> result2 = bibliothequetotest.searchBooks("Zadig");
		// then ?
		assertNotNull(result1);
		assertNotNull(result2);
		assertEquals(1, result1.size());
		assertEquals(1, result2.size());
	}

	public void testBorrowBook() throws LibraryException {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		final User usertotest = new User(0, "Croquet");
		listofUsers.add(usertotest);
		listofbooks.add(booktotest);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		bibliothequetotest.borrowBook("4", "Croquet");
		// then ?
		final List<Book> bibliothequelistofbooks = bibliothequetotest.getBooks();
		final List<User> bibliothequelistofuser = bibliothequetotest.getUser();
		final Book thebookbeanborrow = bibliothequelistofbooks.get(0);
		final User theuserwhoborrowbook = bibliothequelistofuser.get(0);
		final int numberofbookborrowbyuser = theuserwhoborrowbook.getBook().size();
		final int numberofbookinbibliotheque = thebookbeanborrow.getNbExemplaire();
		assertEquals(0, numberofbookinbibliotheque);
		assertEquals(1, numberofbookborrowbyuser);
	}

	public void testReturnBook() throws LibraryException {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		final User usertotest = new User(0, "Croquet");
		listofbooks.add(booktotest);
		usertotest.setBook(listofbooks);
		listofUsers.add(usertotest);

		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);

		// when ?
		bibliothequetotest.returnBook("4", "Croquet");

		// then ?
		final User userwithbook = bibliothequetotest.getUser().get(0);
		final List<Book> Userlistofbook = userwithbook.getBook();
		final int numberofthesamebook = Userlistofbook.get(0).getNbExemplaire();
		assertEquals(1, numberofthesamebook);
	}

	public void testAddBook() throws LibraryException {
		// what ?
		final Book booktotest = new Book(4, "123ABC", "Voltaire", "Candide", 1);
		final User usertotest = new User(0, "Croquet");
		listofUsers.add(usertotest);
		listofbooks.add(booktotest);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		bibliothequetotest.addBook("123ABC");
		// then ?
		final List<Book> bibliothequelistofbooks = bibliothequetotest.getBooks();
		final Book thebookadded = bibliothequelistofbooks.get(0);
		final int numberofbookinbibliotheque = thebookadded.getNbExemplaire();
		assertEquals(2, numberofbookinbibliotheque);
	}
}
