
public class main {

	  private String name;

	    // Méthode principale (main) pour tester la classe
	    public main(String[] args) {
	        // Création d'un donjon
	        Donjon donjon = new Donjon("Donjon ");
	        // Génération du donjon
	        donjon.generateDonjon();

	        // Test des getters et setters
	        System.out.println("Nom du donjon : " + donjon.getName());
	        donjon.setName("Donjon ...");
	        System.out.println("Nouveau nom du donjon : " + donjon.getName());
	    }

	    // Constructeur
	    public void Donjon(String name) {
	        this.name = name;
	    }

	    // Méthode pour générer le donjon
	    public void generateDonjon() {
	        // Logique de génération du donjon ici
	        System.out.println("Génération du donjon '" + name + "'...");
	        // Exemple de message de sortie
	        System.out.println("Donjon généré avec succès !");
	    }

	    // Méthode getter pour récupérer le nom du donjon
	    public String getName() {
	        return name;
	    }

	    // Méthode setter pour définir le nom du donjon
	    public void setName(String name) {
	        this.name = name;
	    }
	
}