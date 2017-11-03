package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bibliotheque {
	
	private HashMap<Integer, Book> books = new HashMap<Integer,Book>();
	
	public Bibliotheque(HashMap<Integer, Book> books) {
		
		this.books = books;
		
		// Ensuite on crée nos listes d'auteurs
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
		
		// Avec, on crée nos différents books
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
		
		// Puis on ajoute ces books dans le HashMap
		books.put(1, livre1);
		books.put(2, livre2);
		books.put(3, livre3);
		books.put(4, livre4);
		books.put(5, livre5);
		books.put(6, livre6);
		books.put(7, livre7);
		books.put(8, livre8);
		books.put(9, livre9);
		books.put(10, livre10);
	
	}
}
