package PacManpackage;

public enum Sens {
	    NONE(0, 0), 
	    UP(-1, 0), 
	    DOWN(1, 0), 
	    LEFT(0, -1), 
	    RIGHT(0, 1); 

	    private final int dx;
	    private final int dy;

	    Sens(int dx, int dy) {
	        this.dx = dx;
	        this.dy = dy;
	    }

	    public Sens turnLeft() {
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

	    public Sens turnRight() {
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

	    public int getDx() {
	        return dx;
	    }

	    public int getDy() {
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


