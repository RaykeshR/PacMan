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
	        this.dx = a; 
	        this.dy = b; 
	    }

	    public Sens RotationAntiHoraire() { //machine à état tourner dans le sens horaire
	        switch (this) { 
	            case UP:
	                return LEFT;
	            case DOWN:
	                return RIGHT;
	            case LEFT:
	                return DOWN;
	            case RIGHT:
	                return UP;
	            default:
	                return NONE;
	        }
	    }

	    public Sens RotationHoraire() { //machine à état tourner dans le sens horaire
	        switch (this) {
	            case UP:
	                return RIGHT;
	            case DOWN:
	                return LEFT;
	            case LEFT:
	                return UP;
	            case RIGHT:
	                return DOWN;
	            default:
	                return NONE;
	        }
	    }

	    public int getDx() { //obtenir dx
	        return dx; //renvoit le déplacement en ligne
	    }

	    public int getDy() { //obtenir dy
	        return dy; //renvoit le déplacement en colonne
	    }
}

