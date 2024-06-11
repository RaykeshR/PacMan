package PacManpackage;

public enum Sens {
	    NONE(0, 0), //le fantome ne bouge pas
	    UP(-1, 0),  //le fantome monte
	    DOWN(1, 0), //le fantome ddescend
	    LEFT(0, -1), //le fantome va à gauche
	    RIGHT(0, 1);  //le fantome va à droite

	    private final int dx; //déplacement en ligne
	    private final int dy; //déplacement en colonne

	    Sens(int a, int b) { //constructeur
	        this.dx = a; //initialise le déplacement en ligne
	        this.dy = b; //initialise le déplacement en colonne
	    }

	    public Sens RotationAntiHoraire() { //machine à état tourner dans le sens horaire
	        switch (this) { 
	            case UP: //si tourné vers le haut
	                return LEFT; //le fantome est maintenant orienté vers la gauche
	            case DOWN: //si tourné vers le bas
	                return RIGHT; //le fantome est maintenant orienté vers la droite
	            case LEFT: //si tourné vers la gauche
	                return DOWN; //le fantome est maintenant orienté vers le bas
	            case RIGHT: //si tourné vers la droite
	                return UP; //le fantome est maintenant orienté vers le haut
	            default: //si le fantome na pas de sens
	                return NONE; //le fantome est maintenant orienté comme avant
	        }
	    }

	    public Sens RotationHoraire() { //machine à état tourner dans le sens horaire
	        switch (this) {
	            case UP: //si tourné vers le haut
	                return RIGHT; //le fantome est maintenant orienté vers la droite
	            case DOWN: //si tourné vers le bas
	                return LEFT; //le fantome est maintenant orienté vers la gauche
	            case LEFT: //si tourné vers la gauche
	                return UP; //le fantome est maintenant orienté vers le haut
	            case RIGHT: //si tourné vers la droite
	                return DOWN; //le fantome est maintenant orienté vers le bas
	            default: //si le fantome n'a pas de sens
	                return NONE; //le fantome est maintenant orienté comme avant
	        }
	    }

	    public int getDx() { //obtenir dx
	        return dx; //renvoit le déplacement en ligne
	    }

	    public int getDy() { //obtenir dy
	        return dy; //renvoit le déplacement en colonne
	    }
}

