import java.awt.*;
import java.awt.Color;

public class JMan extends Piece {

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

	public JMan(int x, int y, Color c, Map m) {
		super(Piece.JMAN, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}

	public void act() {
	}

	private boolean isStep(Piece p) {
		return this.getColor() == Color.YELLOW && p.getColor() == Color.GREEN
				|| this.getColor() == Color.GREEN && p.getColor() == Color.RED
				|| this.getColor() == Color.RED && p.getColor() == Color.YELLOW;
	}

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
						this.setY(y - 1);
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x, y - 1);
						this.setY(y - 1);
					}
				}
			} else if (i == 1) {
				if (this.getMap().isInGrid(x, y + 1)) {
					p = this.getMap().pieceAt(x, y + 1);
					if (p == null) {
						this.getMap().move(x, y, x, y + 1);
						this.setY(y + 1);
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x, y + 1);
						this.setY(y + 1);
					}
				}
			} else if (i == 2) {
				if (this.getMap().isInGrid(x - 1, y)) {
					p = this.getMap().pieceAt(x - 1, y);
					if (p == null) {
						this.getMap().move(x, y, x - 1, y);
						this.setX(x - 1);
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x - 1, y);
						this.setX(x - 1);
					}
				}
			} else if (i == 3) {
				if (this.getMap().isInGrid(x + 1, y)) {
					p = this.getMap().pieceAt(x + 1, y);
					if (p == null) {
						this.getMap().move(x, y, x + 1, y);
						this.setX(x + 1);
					} else if (p.getType() != 0 && this.isStep(p)) {
						this.setColor(p.getColor());
						this.getMap().move(x, y, x + 1, y);
						this.setX(x + 1);
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