import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Veux-tu rentrer dans le donjon aventurier ? (oui/non)");

        String reponse = scan.next();

        if (reponse.equalsIgnoreCase("oui")) {
            room.enter();
            System.out.println("Voulez-vous fouiller le mobilier ? (oui/non)");
            String fouillerReponse = scan.next();
            if (fouillerReponse.equalsIgnoreCase("oui")) {
                room.fouillerMobilier();
            } else {
                System.out.println("Vous décidez de ne pas fouiller le mobilier.");
            }
        } else if (reponse.equalsIgnoreCase("non")) {
            System.out.println("Vous manquez de courage et repartez.");
        } else {
            System.out.println("Réponse invalide. Fin du programme.");
        }

        scan.close();
    }
}