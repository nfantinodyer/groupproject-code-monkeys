public class Entity {
	private Space space;
	private EntityType type;
	
	public Entity(EntityType tp, int row, int col){
		type =tp ;
		space = new Space(row,col);
	}
	void move(int nRow, int nCol){
		space  = new Space(getRow()+nRow,getCol()+nCol);
	}
	
	public Space getSpace() {
		return space;
	}
	public int getRow() {
		return space.getRow();
	}
	public int getCol(){
		return space.getCol();
	}
	
	public EntityType getType(){
		return type;
	}
	public String toString() {
		return "";
		
	}
	
}

