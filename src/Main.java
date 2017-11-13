

import java.util.ArrayList;
import java.util.List;

import Exception.LibraryException;
import Project.Bibliotheque;
import Project.Book;
import Project.IBibliotheque;
import Project.User;

public class Main {

	private static IBibliotheque bibi;

	public static void main(String[] args) throws LibraryException {

		// On crée les livres
		final Book book1 = new Book("AAA", "Victor Hugo", "Les Miserables", 2);
		final Book book2 = new Book("AAB", "Voltaire", "Candide", 2);
		final Book book3 = new Book("AAC", "Arthur Conan Doyle", "Le Chien des Baskerville", 2);

		// On les ajoute quelques livres à notre liste de livres
		final List<Book> listBook = new ArrayList<Book>();
		listBook.add(book1);
		listBook.add(book2);
		listBook.add(book3);

		// On crée les utilisateurs
		final User user1 = new User(1, "Capon");
		final User user2 = new User(2, "Exodia");
		final User user3 = new User(3, "Titouan");

		// On les ajoute à notre liste de d'utilisateur
		final List<User> listUser = new ArrayList<User>();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);

		// On crée notre bibliothèqque
		bibi = new Bibliotheque(listUser, listBook);

		// On ajoute des exemplaires de livre
		System.out.println("\n ---------------1-----------------\n");
		System.out.println("Etat des livres : " + bibi.getBooks());
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Livre avec ID = 1 : " + bibi.getBook("1"));
		System.out.println("Livre avec ID = 2 : " + bibi.getBook("2"));
		System.out.println("Livre avec ID = 3 : " + bibi.getBook("3"));
		System.out.println("Livre avec ID = 4 : " + bibi.getBook("4"));
		System.out.println();
		System.out.println("ON AJOUTE DES EXEMPLAIRES");
		bibi.addBook("AAA");
		bibi.addBook("AAB");
		bibi.addBook("AAB");
		bibi.addBook("AAC");
		bibi.addBook("AAR");

		// On vérifie l'état de la bibliothèque
		System.out.println("\n ---------------2-----------------\n");
		System.out.println("Etat des livres : " + bibi.getBooks());
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Livre avec ID = 1 : " + bibi.getBook("1"));
		System.out.println("Livre avec ID = 2 : " + bibi.getBook("2"));
		System.out.println("Livre avec ID = 3 : " + bibi.getBook("3"));

		System.out.println("\n ---------------3-----------------\n");

		// Des utilisateurs empruntent des livres
		System.out.println("DES UTILISATEUR EMPRUNTENT DES LIVRES");
		// On vérifie si le livre demandé est bien présent dans la bibliothèque

		bibi.borrowBook("1", "Capon");
		bibi.borrowBook("1", "Exodia");
		bibi.borrowBook("1", "Exodia");
		bibi.borrowBook("2", "Titouan");
		System.out.println();
		// On vérifie l'etat des livres
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Etat des livres : " + bibi.getBooks());
		System.out.println();

		// On vérifie l'etat des utilisateurs
		System.out.println("ETAT DES UTILISATEURS");
		System.out.println(user1.getUsername() + " a " + user1.getBook());
		System.out.println(user2.getUsername() + " a " + user2.getBook());
		System.out.println(user3.getUsername() + " a " + user3.getBook());

		System.out.println();

		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Livre avec ID = 1 : " + bibi.getBook("1"));
		System.out.println("Livre avec ID = 2 : " + bibi.getBook("2"));
		System.out.println("Livre avec ID = 3 : " + bibi.getBook("3"));

		System.out.println("\n ---------------4-----------------\n");

		// Des utilisateurs rendent des livres
		System.out.println("LES UTILISATEURS NOUS REND DES LIVRES");
		// On vérifie si le livre rendu correspond bien

		bibi.returnBook("1", "Capon");
		bibi.returnBook("1", "Exodia");
		bibi.returnBook("2", "Titouan");
		bibi.returnBook("2", "Titouan");
		bibi.returnBook("42", "Titouan");

		System.out.println();
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Etat des livres : " + bibi.getBooks());

		System.out.println();
		System.out.println("ETAT DES UTILISATEURS");
		System.out.println(user1.getUsername() + " a " + user1.getBook());
		System.out.println(user2.getUsername() + " a " + user2.getBook());
		System.out.println(user3.getUsername() + " a " + user3.getBook());

		System.out.println();

		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Livre avec ID = 1 : " + bibi.getBook("1"));
		System.out.println("Livre avec ID = 2 : " + bibi.getBook("2"));
		System.out.println("Livre avec ID = 3 : " + bibi.getBook("3"));

		System.out.println("\n ---------------5-----------------\n");
		System.out.println("ON RECHERCHE UN LIVRE");
		System.out.println("Recherche 1 : " + bibi.searchBooks("Le Chien des Baskerville"));
		System.out.println("Recherche 2 : " + bibi.searchBooks("Victor Hugo"));
		System.out.println("Recherche 3 : " + bibi.searchBooks("B2O"));

	}

}
