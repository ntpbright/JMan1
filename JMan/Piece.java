import java.awt.*;

public abstract class Piece{
	private int x, y, type;
	private boolean acted;
	private Map m;
	private Color color;
	
    /** Constants that identify the kind of a piece. */
    public static final int BLOCK= 0;  // piece is a block
    public static final int JMAN= 1;   // piece is the J*man
    public static final int WALKER= 2; // piece is a walker
    public static final int PILLAR= 3; // piece is a pillar
  
    public Piece(int t, Map m){
        this.type = t;
        this.m = m;
        this.acted = false;
    }
    
    public int getType(){
        return this.type;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public String getColorWord() {
    	String colorWord = "";
    	if(color.equals(Color.RED)){
    		colorWord = "Red";
    	}	else if(color.equals(Color.YELLOW)){
    		colorWord = "Yellow";
    	}	else if(color.equals(Color.GREEN)){
    		colorWord = "Green";
    	}	else if(color.equals(Color.WHITE)){
    		colorWord = "White";
    	}
        return colorWord;
    }
    
    public boolean hasActed(){
        return this.acted;
    }
    
    public Map getMap(){
        return this.m;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setColor(Color c){
        this.color = c;
    }
    
    public void setActed(boolean acted){
        this.acted = acted;
    }
    
    public abstract void act();
   
    public static int rand(int lo, int hi){
        return (int)(Math.random()*(hi-lo+1))+lo;
    }
    
}