import java.util.Scanner;
import java.util.Random;



public class room extends main{

	
	//les objets dans les pieces
	
	class Mobilier {
	    private String nom;
	    
	    public Mobilier(String nom) {
	        this.nom = nom;
	    }
	    
	    public String getNom() {
	        return nom;
	    }
	}

	
	//tabeau de mobillier
	
	int rows = 3; //les lignes
	int cols = 3; //les colonnes
	
	//declaration du tableau de mobilier
	
    Mobilier[][] tableauMobilier = generateTableauMobillier(rows, cols);

    
    //afficher le tableau de mobilier
		
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            Mobilier mobilier = tableauMobilier[i][j];
            if (mobilier != null) {
                System.out.print(mobilier.getNom() + "\t"); //c est plus joli
            } else {
                System.out.print("Vide\t");
            }
        }
        System.out.println();
    }

    
    //Methode pour generer un tableau de mobilier
   public static  Mobilier[][] generateTableauMobillier(int rows, int cols){
        Random random = new Random();
        Mobilier[][] tableauMobilier = new Mobilier[rows][cols];
        
        String[] typesDeMobilier = {"Chaise", "Table",  "Lampe", "Armoire", "Bureau"};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (random.nextBoolean()) { // Probabilité de 50% d'avoir un mobilier dans une case
                    int index = random.nextInt(typesDeMobilier.length);
                    String nomMobilier = typesDeMobilier[index];
                    tableauMobilier[i][j] = new Mobilier(nomMobilier);
                }
            }
        }
        
        return tableauMobilier;
    }
    
    
    public static void  enter(){
			System.out.println("Vous vous retrouvez prisonnier dans une salle sombre");
			
		}

	}
}


