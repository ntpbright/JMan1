import java.awt.*;
import java.awt.Color;

/** An instance of this class is a J*Man.
There should at most one J*Man in a game board at a time*/
public class JMan extends Piece {
	
	/** Constructor: a new J*Man at position (x, y) on Map m
    with color red if c = 0, green if c = 1, and yellow if c = 2. */
	public JMan(int x, int y, int c, Map m) {
		super(Piece.JMAN, m);
		this.setX(x);
		this.setY(y);
		if (c == 0) {
			this.setColor(Color.RED);
		} else if (c == 1) {
			this.setColor(Color.GREEN);
		} else if (c == 2) {
			this.setColor(Color.YELLOW);
		}
	}
	
	/** Constructor: a new J*Man at position (x, y) on Map m
    with color c. Precondition: c is one of
    Color.RED, Color.GREEN, and Color.YELLOW.*/
	public JMan(int x, int y, Color c, Map m) {
		super(Piece.JMAN, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}
	
	 /** J*Man should move based on what button is pushed.
    This method is not used. */
	public void act() {
	}

	/** Move J*Man one step based on the value of i:
    0 = up, 1 = down, 2 = left, 3 = right. */
	private boolean isStep(Piece p) {
		return this.getColor() == Color.YELLOW && p.getColor() == Color.GREEN
				|| this.getColor() == Color.GREEN && p.getColor() == Color.RED
				|| this.getColor() == Color.RED && p.getColor() == Color.YELLOW;
	}

	/** = representation of this piece */
	public void step(int i) {
		Piece p;
		int x = this.getX();
		int y = this.getY();
		try {
			if (i == 0) {
				if (this.getMap().isInGrid(x,y - 1)) {
					p = this.getMap().pieceAt(x,y - 1);
					if (p == null) {
						this.getMap().move(x, y, x, y - 1);
						
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x, y - 1);
						
					}
				}
			} else if (i == 1) {
				if (this.getMap().isInGrid(x, y + 1)) {
					p = this.getMap().pieceAt(x, y + 1);
					if (p == null) {
						this.getMap().move(x, y, x, y + 1);
						
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x, y + 1);
						
					}
				}
			} else if (i == 2) {
				if (this.getMap().isInGrid(x - 1, y)) {
					p = this.getMap().pieceAt(x - 1, y);
					if (p == null) {
						this.getMap().move(x, y, x - 1, y);
						
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x - 1, y);
						
					}
				}
			} else if (i == 3) {
				if (this.getMap().isInGrid(x + 1, y)) {
					p = this.getMap().pieceAt(x + 1, y);
					if (p == null) {
						this.getMap().move(x, y, x + 1, y);
						
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x + 1, y);
						
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			this.setX(x);
			this.setY(y);
		}
		this.setActed(true);
	}

	public String toString() {
		String color = "";
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}