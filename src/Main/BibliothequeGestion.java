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
	 * @return
	 */
	public static List<Book> createBookList(){
		List<Book> maListe = new ArrayList<>();
		
		Book livre1 = new Book("1", "AAA", "Livre1" ,"Auteur1", 4);
		Book livre2 = new Book("2", "AAB", "Livre2" ,"Auteur2", 1);
		Book livre3 = new Book("3", "AAC", "Livre3" ,"Auteur3", 3);
		Book livre4 = new Book("4", "AAD", "Livre4" ,"Auteur4", 2);
		Book livre5 = new Book("5", "AAE", "Livre5" ,"Auteur5", 7);
		Book livre6 = new Book("6", "AAF", "Livre6" ,"Auteur6", 3);
		Book livre7 = new Book("7", "AAG", "Livre7" ,"Auteur7", 5);
		Book livre8 = new Book("8", "AAH", "Livre8" ,"Auteur8", 1);
		Book livre9 = new Book("9", "AAI", "Livre9" ,"Auteur9", 3);
		Book livre10 = new Book("10", "AAJ", "Livre10" ,"Auteur10", 5);
		Book livre11 = new Book("11", "AAK", "Livre11" ,"Auteur11", 4);
		Book livre12 = new Book("12", "AAL", "Livre12" ,"Auteur12", 4);
		Book livre13 = new Book("13", "AAM", "Livre13" ,"Auteur13", 3);
		Book livre14 = new Book("14", "AAN", "Livre14" ,"Auteur14", 2);
		Book livre15 = new Book("15", "AAO", "Livre15" ,"Auteur15", 3);
		
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
		maListe.add(livre11);
		maListe.add(livre12);
		maListe.add(livre13);
		maListe.add(livre14);
		maListe.add(livre15);
		
		return maListe;
	}

	/**
	 * Cette méthode créer et renvoi une liste de user
	 * @return
	 */
	public static List<User> createUserList(){
		List<User> maListe = new ArrayList<>();
		
		User user1 = new User("Paul");
		User user2 = new User("Theo");
		User user3 = new User("Leo");
		User user4 = new User("Nicolas");
		User user5 = new User("Remi");
		
		maListe.add(user1);
		maListe.add(user2);
		maListe.add(user3);
		maListe.add(user4);
		maListe.add(user5);
		
		return maListe;
	}
}
