package Project;
public class Book {
	private int id;
	private String isbn;
	private String auteur;
	private String titre;
	private int nbExemplaire;

	public Book(int id, String isbn, String auteur, String titre, int nbExemplaire){
			this.id = id;
			this.isbn = isbn;
			this.auteur = auteur;
			this.titre = titre;
			this.nbExemplaire = nbExemplaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbExemplaire() {
		return nbExemplaire;
	}

	public void setNbExemplaire(int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", auteur=" + auteur + ", titre=" + titre + ", nbExemplaire="
				+ nbExemplaire + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
