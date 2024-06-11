package PacManpackage;

public enum Sens {
	    NONE(0, 0), //le fantome ne bouge pas
	    UP(-1, 0),  //le fantome monte
	    DOWN(1, 0), //le fantome ddescend
	    LEFT(0, -1), //le fantome va à gauche
	    RIGHT(0, 1);  //le fantome va à droite

	    private final int dx;
	    private final int dy;

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

	    public Sens RotationHoraire() { //machine à état tourner dans le sens antihoraire
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
	    public Sens Droite() {
	       return RIGHT; 
	    }

	    public int getDx() { //obtenir dx
	        return dx;
	    }

	    public int getDy() { //obtenir dy
	        return dy;
	    }

}


//Example
/*
public class PacMan {
    private Direction direction;

    public void move() {
        int newX = getX() + direction.getDx();
        int newY = getY() + direction.getDy();
        // update the position of the Pac-Man
	}

	public void turnLeft() {
		direction = direction.turnLeft();
	}

	public void turnRight() {
		direction = direction.turnRight();
	}
}
*/


