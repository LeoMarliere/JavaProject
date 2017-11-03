package Main;

import java.util.ArrayList;
import java.util.List;

import objects.Book;
import objects.User;

public class BibliothequeGestion {

	public static List<Book> bookList;
	public static List<User> userList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bookList = createBookList();
		userList = createUserList();

	}

	/**
	 * Cette méthode créer et renvoi une liste de livre
	 * 
	 * @return
	 */
	public static List<Book> createBookList() {
		final List<Book> maListe = new ArrayList<>();
		
		
		List<String> auteur1 = new ArrayList<>();
		auteur1.add("Auteur1");
		
		List<String> auteur2 = new ArrayList<>();
		auteur1.add("Auteur2");
		
		List<String> auteur3 = new ArrayList<>();
		auteur1.add("Auteur3");
		
		List<String> auteur4 = new ArrayList<>();
		auteur1.add("Auteur4");
		
		List<String> auteur5 = new ArrayList<>();
		auteur1.add("Auteur5");
	
		List<String> auteur6 = new ArrayList<>();
		auteur1.add("Auteur6");
		
		List<String> auteur7 = new ArrayList<>();
		auteur1.add("Auteur7");
		
		List<String> auteur8 = new ArrayList<>();
		auteur1.add("Auteur8");
		
		List<String> auteur9 = new ArrayList<>();
		auteur1.add("Auteur9");
		
		List<String> auteur10 = new ArrayList<>();
		auteur1.add("Auteur10");
		

		final Book livre1 = new Book("1", "AAA", "Livre1", auteur1 , 4);
		final Book livre2 = new Book("2", "AAB", "Livre2", auteur2, 1);
		final Book livre3 = new Book("3", "AAC", "Livre3", auteur3, 3);
		final Book livre4 = new Book("4", "AAD", "Livre4", auteur4, 2);
		final Book livre5 = new Book("5", "AAE", "Livre5", auteur5, 7);
		final Book livre6 = new Book("6", "AAF", "Livre6", auteur6, 3);
		final Book livre7 = new Book("7", "AAG", "Livre7", auteur7, 5);
		final Book livre8 = new Book("8", "AAH", "Livre8", auteur8, 1);
		final Book livre9 = new Book("9", "AAI", "Livre9", auteur9, 3);
		final Book livre10 = new Book("10", "AAJ", "Livre10", auteur10, 5);


		maListe.add(livre1);
		maListe.add(livre2);
		maListe.add(livre3);
		maListe.add(livre4);
		maListe.add(livre5);
		maListe.add(livre6);
		maListe.add(livre7);
		maListe.add(livre8);
		maListe.add(livre9);
		maListe.add(livre10);


		return maListe;
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
}
