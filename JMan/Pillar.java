import java.awt.Color;
/**
 * 
 * @author Nuttapatprom Chongamorkulprapa
 *
 */
public class Pillar extends Piece {
	//Constructor
	public Pillar(int x, int y, int c, Map m) {
		super(Piece.PILLAR, m);
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
	//constructor
	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}
	//set color in play game
	@Override
	public void act() {
		if (!this.hasActed()) {
			int randomNum = rand(1,3);
			if (randomNum > 2) {
				int randColor = Piece.rand(0, 2);
				if (randColor == 0)
					this.setColor(Color.RED);
				else if (randColor == 1)
					this.setColor(Color.YELLOW);
				else if (randColor == 2)
					this.setColor(Color.GREEN);
			}
			this.setActed(true);
		}
	}

	public String toString() {
		String color = "";
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}
}
