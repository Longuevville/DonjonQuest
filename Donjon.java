import java.util.Random;
import java.util.Scanner;

public class Donjon {
	 // Les objets qui se trouvent dans les pièces
    static class Mobilier {
        private String nom;

        public Mobilier(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }
    }

    // Tableau des pièces
    private room[] pieces;

    public Donjon() {
        pieces = new room[8];
        for (int i = 0; i < 8; i++) {
            pieces[i] = new room(generateTableauMobilier(3, 3));
        }
    }

    // Méthode pour entrer dans une pièce
    public void entrerPiece(int numeroPiece) {
        Printer.printMessage("Vous entrez dans la pièce " + numeroPiece + ".");
        pieces[numeroPiece - 1].afficherPiece();
        
        // Proposer au joueur de fouiller la pièce
        Printer.askQuestion("Voulez-vous fouiller cette pièce ? (oui/non)");
        Scanner scan = new Scanner(System.in);
        String reponse = scan.next();
        if (reponse.equalsIgnoreCase("oui")) {
            pieces[numeroPiece - 1].fouillerPiece();
        } else {
            Printer.printMessage("Vous décidez de ne pas fouiller la pièce.");
        }
        scan.close();
    }

    // Méthode pour générer un tableau de mobilier
    private Mobilier[][] generateTableauMobilier(int rows, int cols) {
        Random random = new Random();
        Mobilier[][] tableauMobilier = new Mobilier[rows][cols];

        String[] typesDeMobilier = {"Chaise", "Table", "Lampe", "Armoire", "Bureau"};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (random.nextBoolean()) { // Probabilité de 50% d'avoir un mobilier dans une case du tableau
                    int index = random.nextInt(typesDeMobilier.length);
                    String nomMobilier = typesDeMobilier[index];
                    tableauMobilier[i][j] = new Mobilier(nomMobilier);
                }
            }
        }

        return tableauMobilier;
    }
}
