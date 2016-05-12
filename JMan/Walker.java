import java.awt.Color;

public class Walker extends Piece {

	public Walker(int x, int y, int c, Map m) {
		super(Piece.WALKER, m);
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

	public Walker(int x, int y, Color c, Map m) {
		super(Piece.WALKER, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}

	@Override
	public void act() {
		if (!this.hasActed()) {
			if (Piece.rand(1, 4) > 3) {
				int i = Piece.rand(0, 3);
				int x = this.getX();
				int y = this.getY();
				if (i == 0) {
					if(this.getMap().isEmpty(x-1, y)){
						this.getMap().move(x, y, x-1, y);
						this.setX(this.getX()-1);
					}
				} else if (i == 1){
					if(this.getMap().isEmpty(x, y-1)){
						this.getMap().move(x, y, x, y-1);
						this.setY(this.getY()-1);
					}
				}
				else if (i == 2){
					if(this.getMap().isEmpty(x+1, y)){
						this.getMap().move(x, y, x+1, y);
						this.setX(this.getX()+1);
					}
				}
				else if (i == 3){
					if(this.getMap().isEmpty(x, y+1)){
						this.getMap().move(x, y, x, y+1);
						this.setY(this.getY()+1);
					}
				}
					
			}
		}
		this.setActed(true);
	}

	public String toString() {
		String color = "";
		return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
	}
}