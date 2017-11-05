package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Exception.AllBooksAlreadyReturnedException;
import Exception.BookNotFoundException;
import Exception.UnavailableBookException;
import objects.Bibliotheque;
import objects.Book;
import objects.User;

public class BibliothequeGestion implements IBibliotheque  {

	public static List<User> userList;
	public static Bibliotheque bibliotheque;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		userList = createUserList();
		
		// On crée notre Instance Bibliotheque
		bibliotheque = Bibliotheque.getInstance();
		// On recupere notre Interface
		IBibliotheque interfaceBibliotheque = new BibliothequeGestion();
		
		// On peut ensuite appeler les méthodes
		Optional<Book> monBook = interfaceBibliotheque.getBook("1");
		List<Book> listeDeToutLesLivres = interfaceBibliotheque.getBooks();

	}

	/**
	 * Cette méthode créer et renvoi une liste de user
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

	// ------------- Méthode a implementer -------------
	
	 /**
	  * Get a book from its id
	  *
	  * @param id the id of the wanter book
	  * @return a book with the given id if there is one
	  */
	// ---------- Done ---------
	@Override
	public Optional<Book> getBook(String id) {
		Book theBook = null;
		HashMap<Integer, Book> bookList = new HashMap<Integer, Book>();
		bookList = bibliotheque.getBooks();
		for (Map.Entry<Integer, Book> book : bookList.entrySet()) {
			Book oneBook = book.getValue();
			if (oneBook.getId().equalsIgnoreCase(id)) {
				theBook = oneBook;
				System.out.println("Object Book séléctionné :");
				System.out.println(theBook.getTitre());
				System.out.println(book.getKey() + " : " + book.getValue());
			}
		}
		return Optional.ofNullable(theBook);
	}
	
	
	/**
	  * Add a book with the given ISBN
	  *
	  * @param isbn the ISBN
	  * @return the id of the added book if the isbn exists
	  */
	public Optional<String> addBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	  * Borrow a book from the library
	  *
	  * @param id the id of the borrowed book
	  * @param username the name of the user
	  * @throws BookNotFoundException if no book in the library has the given id
	  * @throws UnavailableBookException if all books in the library with the given id
	 have been borrowed
	  */
	public void borrowBook(String id, String username) throws BookNotFoundException, UnavailableBookException {
		// TODO Auto-generated method stub
		
	}


	public void returnBook(String id, String username) throws BookNotFoundException, AllBooksAlreadyReturnedException {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Get all books of the library
	 * @return
	 */
	// ---------------- Done -----------------
	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Book> listeDesLivres = new ArrayList<Book>();
		HashMap<Integer, Book> bookList = new HashMap<Integer, Book>();
		bookList = bibliotheque.getBooks();
		for (Map.Entry<Integer, Book> book : bookList.entrySet()) {
			Book oneBook = book.getValue();
			listeDesLivres.add(oneBook);
		}
		return listeDesLivres;
	}


	/**
	  * Return all books with an author, a title or an ISBN matching the search term
	  *
	  * @param searchTerm the searched term
	  * @return the books matching the search term
	  */
	public List<Book> searchBooks(String searchTerm) {
		// TODO Auto-generated method stub
		List<Book> listeDesLivres = new ArrayList<Book>();
		HashMap<Integer, Book> bookList = new HashMap<Integer, Book>();
		bookList = bibliotheque.getBooks();
		// On fait nos tests sur tous les livres
		for (Map.Entry<Integer, Book> book : bookList.entrySet()) {
			Book oneBook = book.getValue();
			List<String> auteurList = oneBook.getAuteur();
			String titre = oneBook.getTitre();
			String isbn = oneBook.getIsbn();
			// On test le titre
			if (titre.equalsIgnoreCase(searchTerm)) {
				listeDesLivres.add(oneBook);
			} // On test l'isbn
			else if(isbn.equalsIgnoreCase(searchTerm)) {
				listeDesLivres.add(oneBook);
			} // On test le nom de l'auteur
			else {
				for (String unAuteur : auteurList ) {
					if (unAuteur.equalsIgnoreCase(searchTerm)) {
						listeDesLivres.add(oneBook);
					}
				}	
			}	
		}
		return listeDesLivres;
	}
	
	
}
