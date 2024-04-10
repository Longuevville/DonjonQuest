public class room {
    private Donjon.Mobilier[][] mobilier;

    public room(Donjon.Mobilier[][] mobilier) {
        this.mobilier = mobilier;
    }

    // Méthode pour afficher la pièce
    public void afficherPiece() {
        System.out.println("Vous regardez autour de vous et vous voyez :");
        for (int i = 0; i < mobilier.length; i++) {
            for (int j = 0; j < mobilier[i].length; j++) {
                Donjon.Mobilier meuble = mobilier[i][j];
                if (meuble != null) {
                    System.out.print(meuble.getNom() + "\t");
                } else {
                    System.out.print("C'est vide\t");
                }
            }
            System.out.println();
        }
    }

    // Méthode pour fouiller la pièce
    public void fouillerPiece() {
        System.out.println("Vous commencez à fouiller la pièce...");
        // Ajout futur de la logique pour fouiller une piece , y penser
        // afficher détails de chaque objets ou pas ?
        // monstres ?
    }
}