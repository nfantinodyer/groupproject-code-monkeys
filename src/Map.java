
public class Map {
	Entity[][] character;
	
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
		return 0;
	}
	
	public int getNumRows() {
		return 0;
	}
	
	public Entity getEnt(Space s) {
		
	}
	
	public int getNumEnt() {
		return 0;
	}
	
	public void addEntity(EntityType type, int r, int c) {
		
	}
	
	public void move(int nRow, int nCol) {
		
	}
	
	public boolean collision (Space s, EntityType type) {
		return false;
	}
	
}
