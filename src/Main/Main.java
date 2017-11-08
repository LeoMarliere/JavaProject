package Main;


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
		
//		On créé les livres
		Book book1 = new Book(1, "AAA", "Auteur1", "Titre1", 2);
		Book book2 = new Book(2, "AAB", "Auteur2", "Titre2", 2);
		Book book3 = new Book(3, "AAC", "Auteur3", "Titre3", 2);
		Book book4 = new Book(4, "AAD", "Auteur4", "Titre4", 2);
		Book book5 = new Book(5, "AAE", "Auteur5", "Titre5", 2);
		
//		On les ajoute quelques livres a notre liste de livre
		List <Book>listBook=new ArrayList<Book>();		
		listBook.add(book1);
		listBook.add(book2);
		listBook.add(book3);
		

//		On créé les utilisateurs
		User user1= new User(1, "Capon");
		User user2= new User(2, "Charclo");
		User user3= new User(3, "Titou");

//		On les ajoute à notre liste de d'utilisateur
		List <User>listUser= new ArrayList<User>();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
		
//		On créé notre bibliothèqque
		bibi = new Bibliotheque(listUser, listBook);
		
//		On ajoute des exemplaires de livre
		System.out.println("\n ---------------1-----------------\n");
		System.out.println("Tous les livres : "+bibi.getBooks());
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Livre avec ID = 1 : "+bibi.getBook("1"));
		System.out.println("Livre avec ID = 2 : "+bibi.getBook("2"));
		System.out.println("Livre avec ID = 3 : "+bibi.getBook("3"));
		
		System.out.println("ON AJOUTE DES EXEMPLAIRES");
		bibi.addBook("AAA");
		bibi.addBook("AAB");
		bibi.addBook("AAB");
		bibi.addBook("AAC");
	
		
//		On verifie l'etat de la bibliothèque
		System.out.println("\n ---------------2-----------------\n");
		System.out.println("Tous les livres : "+bibi.getBooks());
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Livre avec ID = 1 : "+bibi.getBook("1"));
		System.out.println("Livre avec ID = 2 : "+bibi.getBook("2"));
		System.out.println("Livre avec ID = 3 : "+bibi.getBook("3"));
		
		System.out.println("\n ---------------3-----------------\n");
		
//		Des utilisateurs empruntent des livres
		System.out.println("DES UTILISATEUR EMPRUNTENT DES LIVRES");
		try{
		bibi.borrowBook("1", "Capon");
		bibi.borrowBook("1", "Charclo");
		bibi.borrowBook("2", "Titou");
//		On verifie si le livre demandé est bien présent dans la bibliothèque
		}catch( LibraryException e){
			System.err.println(e);
		}
		
//		On verifie l'etant des livres
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Tous les livres : "+bibi.getBooks());
		
//		On verifie l'etant des utilisateurs
		System.out.println("ETAT DES UTILISATEURS");
		System.out.println(user1.getUsername()+" a "+user1.getBook());
		System.out.println(user2.getUsername()+" a "+user2.getBook());
		System.out.println(user3.getUsername()+" a "+user3.getBook());
		
		System.out.println("\n ---------------4-----------------\n");
		
//		Des utilisateur rendent des livres
		System.out.println("LES UTILISATEUR NOUS REND DES LIVRES");
		try{
		bibi.returnBook("1", "Capon");
		bibi.returnBook("2", "Titou");
		bibi.returnBook("1", "Charclo");
//		On verifie si le livre rendu correspond bien
		}catch(LibraryException e){
			System.err.println(e);
		}
		
		System.out.println("ETAT DE LA BIBLIOTHEQUE");
		System.out.println("Tous les livres : "+bibi.getBooks());

		System.out.println("ETAT DES UTILISATEURS");
		System.out.println(user1.getUsername()+" a "+user1.getBook());
		System.out.println(user2.getUsername()+" a "+user2.getBook());
		System.out.println(user3.getUsername()+" a "+user3.getBook());
		
		System.out.println("\n ---------------5-----------------\n");		
		System.out.println("ON RECHERCHE UN LIVRE");
		System.out.println("Recherche 1 : "+bibi.searchBooks("Titre3"));
		System.out.println("Recherche 2 : "+bibi.searchBooks("Auteur1"));

	}

}
