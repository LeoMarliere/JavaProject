package objects;

import java.util.List;

public class Book {

	private String id;
	private String isbn;
	private String titre;
	private final List<String> auteur;
	private int nb_Exemplaire;

	public Book(String id, String isbn, String titre, List<String> auteur, int nb_Exemplaire) {
		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
		this.nb_Exemplaire = nb_Exemplaire;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List getAuteur() {
		return auteur;
	}

	public void setAuteur(String nomDauteur) {
		this.auteur.add(nomDauteur);
	}

	public int getNb_Exemplaire() {
		return nb_Exemplaire;
	}

	public void setNb_Exemplaire(int nb_Exemplaire) {
		this.nb_Exemplaire = nb_Exemplaire;
	}

}
