import java.util.ArrayList;

public class Map {
	private Entity[][] map;
	private Entity character;
	private int numRows;
	private int numCols;
	private int numEntities = 0;
	private Space winningSpace;
	ArrayList<Entity> barrels;
	
	public Map(int r, int c) {
		map = new Entity[r][c];
		numRows = r;
		numCols = c;
	}
	
	public boolean canMove(Space s, boolean isUp, boolean isRight) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return false;
		}
		if (s.getRow() > numRows || s.getCol() > numCols) {
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
	
	public void setWinSpace(Space winningSpace) {
		this.winningSpace = winningSpace;
	}
	
	public void addEntity(EntityType type, int r, int c, boolean b) {
		Entity e = new Entity(type, r, c, b);
		map[r][c] = e;
		
		if (type != EntityType.WALL) {
			numEntities++;
		}
		
		if (type == EntityType.BARREL) {
			barrels.add(e);
		}
		
		if (type == EntityType.CHARACTER) {
			character = new Entity(type, r, c, b);
		}
	}
	
	public void moveBarrels(int nRow, int nCol) {
		
	}
	
	public boolean wallCollision (Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return true;
		}
		return false;
	}
	
	public boolean barrelCollision(Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.BARREL) {
			return true;
		}
		return false;
	}
	
	public boolean bananaCollision(Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.BANANA) {
			return true;
		}
		return false;
	}
		
	public boolean cherryCollision(Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.CHERRY) {
			return true;
		}
		return false;
	}
		
	public boolean mangoCollision(Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.MANGO) {
			return true;
		}
		return false;
	}
}
