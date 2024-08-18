import java.util.Scanner;

public class Main {  // La classe est nommée "main" en minuscule
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Printer.printMessage("Bienvenue dans le donjon aventurier !");

        // Création du donjon
        Donjon donjon = new Donjon();

        for (int i = 1; i <= 8; i++) {
            Printer.printMessage("Choisissez une pièce où entrer (de 1 à 8) : ");
            int choix = scan.nextInt();

            // Vérification de la validité du choix du joueur
            if (choix >= 1 && choix <= 8) {
                donjon.entrerPiece(choix, scan);
                if (donjon.estVictoire()) {
                    Printer.printMessage("Félicitations ! Vous avez trouvé les 7 parchemins et vaincu le gardien!");
                    break;
                }
            } else {
                Printer.printMessage("Choix invalide. Fin du programme.");
                break;
            }
        }

        if (!donjon.estVictoire()) {
            Printer.printMessage("Vous avez fouillé toutes les pièces mais n'avez pas trouvé tous les parchemins. Essayez encore !");
        }

        scan.close();
    }
}
