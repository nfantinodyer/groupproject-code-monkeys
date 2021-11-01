
public class Map {
	private Entity[][] character;
	private int numRows;
	private int numCols;
	
	public Map(int r, int c) {
		character = new Entity[r][c];
		numRows = r;
		numCols = c;
	}
	
	public boolean canMove(Space s, boolean isUp, boolean isRight) {
		return false;
	}
	
	public boolean moveChara(Space s, boolean isUp, boolean isRight) {
		return false;
	}
	
	public String toString() {
		return "";
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public Entity getEnt(Space s) {
		return character[s.getRow()][s.getCol()];
	}
	
	public int getNumEnt() {
		return 0;
	}
	
	public void addEntity(EntityType type, int r, int c) {
		Entity e = new Entity(type, r, c);
		character[r][c] = e;
	}
	
	public void move(int nRow, int nCol) {
		
	}
	
	public boolean collision (Space s, EntityType type) {
		if (character[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return true;
		}
		
		if (character[s.getRow()][s.getCol()].getType() == EntityType.BARREL) {
			
		}
		
		if (character[s.getRow()][s.getCol()].getType() == EntityType.BANANA) {
			
		}
		
		if (character[s.getRow()][s.getCol()].getType() == EntityType.CHERRY) {
			
		}
		
		if (character[s.getRow()][s.getCol()].getType() == EntityType.MANGO) {
			
		}
		
		return false;
	}
	
}
