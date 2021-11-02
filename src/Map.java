
public class Map {
	private Entity[][] map;
	private Entity character;
	private int numRows;
	private int numCols;
	private int numEntities = 1;
	
	public Map(int r, int c) {
		map = new Entity[r][c];
		numRows = r;
		numCols = c;
	}
	
	public boolean canMove(Space s, boolean isUp, boolean isRight) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return false;
		}
		return true;
	}
	
	public boolean moveChara(Space s, boolean isUp, boolean isRight) {
		if (canMove(s, isUp, isRight) == true) {
			map[character.getRow()][character.getCol()].move(s.getRow(), s.getCol());
		}
		return canMove(s, isUp, isRight);
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
		return map[s.getRow()][s.getCol()];
	}
	
	public int getNumEnt() {
		return numEntities;
	}
	
	public void addEntity(EntityType type, int r, int c) {
		Entity e = new Entity(type, r, c);
		map[r][c] = e;
		
		if (type == EntityType.BARREL) {
			numEntities++;
		}
		
		if (type == EntityType.CHARACTER) {
			character = new Entity(type, r, c);
		}
	}
	
	public void move(int nRow, int nCol) {
		
	}
	
	public boolean collision (Space s, EntityType type) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return true;
		}
		
		if (map[s.getRow()][s.getCol()].getType() == EntityType.BARREL) {
			
		}
		
		if (map[s.getRow()][s.getCol()].getType() == EntityType.BANANA) {
			
		}
		
		if (map[s.getRow()][s.getCol()].getType() == EntityType.CHERRY) {
			
		}
		
		if (map[s.getRow()][s.getCol()].getType() == EntityType.MANGO) {
			
		}
		
		return false;
	}
	
}
