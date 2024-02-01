import java.util.Scanner;
public class main {

	  public String Donjon;

	    public static void main(String[] args) {
	    	//test
	    	//Affiché un messagge pour demander au joueur si il veut jouer
	    	//Si oui appelé la classe room
	    	//Si non quitté le programme
	    	
	    //creation obt scanner et joueur
	    	Scanner scan = new Scanner(System.in);
	    	Player player = new Player();
	    	room room = new room();
	    	
	    // message de bienvenue lugubre
	    	System.out.println("Veux tu rentrer dans le donjon aventurier ?  (oui/non");
	    	
	    // lire reponse	
	    	String reponse = scan.next();
	    	
	    // si oui appelé classe room
	    	
	    	if ( reponse.equalsIgnoreCase("oui")) {
	  
	    		
	    ////creation d'une instance d'une piece
	    		
	    		
	    		room.enter();
	    		
	    //si joueur ne vveux pas jouer
	    	}else if(reponse.equalsIgnoreCase("non")) {
	    		System.out.println("Vous manquez de courage et repartez");
	    		
	    //Fermeture du jeu
	    		System.exit(0);
	    		scan.close();
	   //verif 		
	    		
	    		
	    	}
	    }
	
}