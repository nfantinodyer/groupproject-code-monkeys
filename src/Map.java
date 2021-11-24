import java.util.ArrayList;
import java.util.Vector;

public class Map {
	private Entity[][] map;
	private Entity character;
	private Space startSpace;
	private int numRows;
	private int numCols;
	private int numEntities = 0;
	private Space winningSpace;
	Vector<Entity> barrels = new Vector<Entity>();
	
	public Map(int r, int c) {
		map = new Entity[r][c];
		numRows = r;
		numCols = c;
	}
	
	public boolean canMove(Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return false;
		}
		else if (s.getRow() > numRows || s.getCol() > numCols) {
			return false;
		}
		return true;
	}
	
	public boolean moveChara(Space s) {
		if (canMove(s)) {
			map[character.getRow()][character.getCol()].move(s.getRow(), s.getCol());
		}
		return canMove(s);
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
	
	public Space getWinSPace() {
		return winningSpace;
	}
	
	public Space getStartSpace() {
		return startSpace;
	}
	
	public Space getCharacterSpace() {
		return character.getSpace();
	}
	
	public int getCharacterRow() {
		return character.getRow();
	}
	
	public int getCharacterCol() {
		return character.getCol();
	}
	
	public void resetChara() {
		character.setSpace(startSpace.getRow(), startSpace.getCol());
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
			startSpace = new Space(r, c);
		}
	}
	
	public Vector<Entity> getBarrels() {
		return barrels;
	}
	
	public void moveBarrels(int nSpaces, Vector<Boolean> vertical, Vector<Boolean>switchy) {
		int p =0;
		for (Entity i: barrels) {
			if (vertical.elementAt(p)) {
				if(switchy.elementAt(p)) {
					i.setSpace(i.getRow(), i.getCol()-1);
				}else {
					i.setSpace(i.getRow(), i.getCol()+1);
				}
			}else { 
				if(switchy.elementAt(p)) {
					i.setSpace(i.getRow()-1, i.getCol());
				}else {
					i.setSpace(i.getRow()+1, i.getCol());
				}
			}
			p++;
		}
	}
	
	public boolean wallCollision (Space s) {
		if(s.getRow()>=numRows||s.getCol()>=numCols) {
			return true;
		}
		if (map[s.getRow()][s.getCol()] == null) {
			return false;
		}
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
			return true;
		}
		return false;
	}
	
	public boolean barrelCollision(Space s) {
		if (map[s.getRow()][s.getCol()].getType() == EntityType.WALL) {
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
		if(map[s.getRow()][s.getCol()] ==  null) {
			return false;
		}
		if (map[s.getRow()][s.getCol()].getType() == EntityType.MANGO) {
			return true;
		}
		return false;
	}
}
