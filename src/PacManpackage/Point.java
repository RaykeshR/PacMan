package PacManpackage;


public class Point {
	private int x;
    private int y;
    private boolean EnCoursDeDigestion;
	// Position dans le Plateau (Matrice)
	int Px,Py;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.EnCoursDeDigestion = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEaten() {
        return EnCoursDeDigestion;
    }

    public void eat() {
        EnCoursDeDigestion = true;
    }

	/**
	 * @return the px
	 */
	public int getPx() {
		return Px;
	}

	/**
	 * @return the py
	 */
	public int getPy() {
		return Py;
	}

	
	/**
	 * Dans la matrice, c'est repésentée par des 3
	 * renvoie les objets de la classe point correspondont aux point sur le plateau.
	 */
	public Point[] LesPointstandard(int n) {
		Plateau get = new Plateau();
	    int[][] P = get.getPlateau();
	    int nombreELements = count(P, 3);
	    Point[] points = new Point[nombreELements];
	    int index = 0;
	    for (int i = 0; i < P.length; i++) {
	        for (int j = 0; j < P[i].length; j++) {
	            if (P[i][j] == 3) {
	                points[index] = new Point(i * n, j * n);
	                points[index].Px = i;
	                points[index].Py = j;
	                index++;
	            }
	        }
	    }
	    return points;
	}

	private int count(int[][] matrix, int value) {
	    int count = 0;
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	            if (matrix[i][j] == value) {
	                count++;
	            }
	        }
	    }
	    return count;
	}
	
	
	/**
	 * 
	 * renvoie les objets de la classe point correspondont aux Gros point sur le plateau.
	 * n=10
	 */
	public Point[] LesBonus(int n) {
		Plateau get = new Plateau();
	    int[][] P = get.getPlateau();
	    int nombreELements = count(P, 4);
	    Point[] points = new Point[nombreELements];
	    int index = 0;
	    for (int i = 0; i < P.length; i++) {
	        for (int j = 0; j < P[i].length; j++) {
	            if (P[i][j] == 4) {
	                points[index] = new Point(i * n, j * n);
	                points[index].Px = i;
	                points[index].Py = j;
	                index++;
	            }
	        }
	    }
	    return points;
	}
	
	
}
