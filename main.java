import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenue dans le donjon aventurier !");

        // Création du donjon
        Donjon donjon = new Donjon();

        // Proposition au joueur de choisir une pièce
        System.out.println("Choisissez une pièce où entrer (de 1 à 8) : ");
        int choix = scan.nextInt();

        // Vérification de la validité du choix du joueur
        if (choix >= 1 && choix <= 8) {
            donjon.entrerPiece(choix);
        } else {
            System.out.println("Choix invalide. Fin du programme.");
        }

        scan.close();
    }
}