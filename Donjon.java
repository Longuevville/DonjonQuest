import java.util.Random;
import java.util.Scanner;

public class Donjon {
    // Les objets qui se trouvent dans les pièces
    static class Mobilier {
        private String nom;
        private String contenu;
        private boolean estParchemin;

        public Mobilier(String nom, boolean estParchemin) {
            this.nom = nom;
            this.estParchemin = estParchemin;
            this.contenu = estParchemin ? "Un parchemin ancien" : generateRandomContent();
        }

        public String getNom() {
            return nom;
        }

        public String getContenu() {
            return contenu;
        }

        public boolean isParchemin() {
            return estParchemin;
        }

        private String generateRandomContent() {
            String[] contenus = {"Une vieille clé rouillée", "Un joyau scintillant", "Rien d'intéressant", "Un piège !"};
            Random random = new Random();
            return contenus[random.nextInt(contenus.length)];
        }
    }

    // Classe interne Piece
    static class Piece {
        private Mobilier[][] mobilier;

        public Piece(Mobilier[][] mobilier) {
            this.mobilier = mobilier;
        }

        public void afficherPiece() {
            System.out.println("La pièce contient les objets suivants :");
            for (int i = 0; i < mobilier.length; i++) {
                for (int j = 0; j < mobilier[i].length; j++) {
                    if (mobilier[i][j] != null) {
                        System.out.println("- " + mobilier[i][j].getNom());
                    }
                }
            }
        }

        public int fouillerPiece(Scanner scan) {
            System.out.println("Quel objet voulez-vous fouiller ?");
            for (int i = 0; i < mobilier.length; i++) {
                for (int j = 0; j < mobilier[i].length; j++) {
                    if (mobilier[i][j] != null) {
                        System.out.println("(" + (i * mobilier[i].length + j + 1) + ") " + mobilier[i][j].getNom());
                    }
                }
            }

            int choix = scan.nextInt();
            Mobilier objetChoisi = null;

            outerloop:
            for (int i = 0; i < mobilier.length; i++) {
                for (int j = 0; j < mobilier[i].length; j++) {
                    if (mobilier[i][j] != null && (i * mobilier[i].length + j + 1) == choix) {
                        objetChoisi = mobilier[i][j];
                        break outerloop;
                    }
                }
            }

            if (objetChoisi != null) {
                System.out.println("Vous fouillez le " + objetChoisi.getNom() + " et trouvez : " + objetChoisi.getContenu());
                if (objetChoisi.isParchemin()) {
                    System.out.println("Vous avez trouvé un parchemin !");
                    return 1;  // Retourne 1 si un parchemin est trouvé
                }
            } else {
                System.out.println("Choix invalide.");
            }
            return 0;  // Retourne 0 si aucun parchemin n'est trouvé
        }
    }

    // Tableau des pièces
    private Piece[] pieces;
    private int parcheminsTrouves;

    public Donjon() {
        pieces = new Piece[8];
        parcheminsTrouves = 0;

        // Répartir aléatoirement 7 parchemins dans le donjon
        Random random = new Random();
        int parcheminsRestants = 7;

        for (int i = 0; i < 8; i++) {
            int parcheminsDansCettePiece = random.nextInt(Math.min(3, parcheminsRestants) + 1);
            pieces[i] = new Piece(generateTableauMobilier(3, 3, parcheminsDansCettePiece));
            parcheminsRestants -= parcheminsDansCettePiece;
        }
    }

    // Méthode pour entrer dans une pièce
    public void entrerPiece(int numeroPiece, Scanner scan) {
        Printer.printMessage("Vous entrez dans la pièce " + numeroPiece + ".");
        
        // Proposer au joueur de fouiller la pièce
        Printer.askQuestion("Voulez-vous fouiller cette pièce ? (oui/non)");
        String reponse = scan.next();
        if (reponse.equalsIgnoreCase("oui")) {
            pieces[numeroPiece - 1].afficherPiece();
            int parcheminTrouve = pieces[numeroPiece - 1].fouillerPiece(scan);
            parcheminsTrouves += parcheminTrouve;
        } else {
            Printer.printMessage("Vous décidez de ne pas fouiller la pièce.");
        }
    }

    public boolean estVictoire() {
        return parcheminsTrouves >= 7;
    }

    // Méthode pour générer un tableau de mobilier avec un certain nombre de parchemins
    private Mobilier[][] generateTableauMobilier(int rows, int cols, int parchemins) {
        Random random = new Random();
        Mobilier[][] tableauMobilier = new Mobilier[rows][cols];

        String[] typesDeMobilier = {"Chaise", "Table", "Lampe", "Armoire", "Bureau"};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (parchemins > 0 && random.nextBoolean()) {
                    tableauMobilier[i][j] = new Mobilier("Parchemin", true);
                    parchemins--;
                } else if (random.nextBoolean()) {
                    int index = random.nextInt(typesDeMobilier.length);
                    String nomMobilier = typesDeMobilier[index];
                    tableauMobilier[i][j] = new Mobilier(nomMobilier, false);
                }
            }
        }

        return tableauMobilier;
    }
}
