import java.awt.Color;

/**
 * 
 * @author Nuttapatprom Chongamorkulprapa
 *
 */
public class Block extends Piece {
	//Constuctor
	public Block(int x, int y, Map m){
        super(Piece.BLOCK, m);
        this.setX(x);
        this.setY(y);
        this.setColor(Color.WHITE);
    }
	
	@Override
	public void act() {
		this.setActed(true);
	}
	
    public String toString() {
        String color= "";
        return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
    }
}
