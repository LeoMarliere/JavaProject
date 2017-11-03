package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import objects.Bibliotheque;
import objects.Book;
import objects.User;

public class BibliothequeGestion  {

	public static List<Book> bookList;
	public static List<User> userList;
	public static Bibliotheque bibliotheque;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bibliotheque = new Bibliotheque();
		userList = createUserList();

	}

	/**
	 * Cette méthode créer et renvoi une liste de user
	 * 
	 * @return
	 */
	public static List<User> createUserList() {
		
		final List<User> maListe = new ArrayList<>();

		final User user1 = new User("Paul");
		final User user2 = new User("Theo");
		final User user3 = new User("Leo");
		final User user4 = new User("Nicolas");
		final User user5 = new User("Remi");

		maListe.add(user1);
		maListe.add(user2);
		maListe.add(user3);
		maListe.add(user4);
		maListe.add(user5);

		return maListe;
	}

	@Override
	public Optional<Book> getBook(String id) {
		Book theBook = null;
		
				
		
		return null;
	}

	@Override
	public Optional<String> addBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrowBook(String id, String username) throws BookNotFoundException, UnavailableBookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBook(String id, String username) throws BookNotFoundException, AllBooksAlreadyReturnedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchBooks(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}
}
