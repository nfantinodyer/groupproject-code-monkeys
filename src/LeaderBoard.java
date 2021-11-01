
public class LeaderBoard {
	private String name;
	private String mapSize;
	private int score;
	

	LeaderBoard(String n,String m, int s){
		name=n;
		mapSize=m;
		score=s;
	}
	
	
	public void setName(String n) {
		name =n;
	}
	
	public void setScore(int s) {
		score=s;
	}
	
	public void setSize(String M) {
		mapSize=M;
	}
	public String getName() {
		return name;
	}
	public String getMapSize() {
		return mapSize;
	}
	public int getScore() {
		return score;
	}
}
