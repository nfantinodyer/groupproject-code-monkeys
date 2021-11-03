import java.util.*;
public class Level {
	String mapSize;
	Map map;
	int barrelMove;
	Space winSpace;
	Vector<LeaderBoard> lead = new Vector<LeaderBoard>();
	
	
	
	public Level createLevel(String s) {
		mapSize = s;
		
		if(s == "small") {
			map = new Map(7,7);
			winSpace = new Space(0,0);
			setUpLevelEasy();
		}else if(s == "medium") {
			map = new Map(14,14);
			winSpace = new Space(0,0);
			setUpLevelMed();
		}else if(s == "large"){
			map = new Map(21,21);
			winSpace = new Space(0,0);
			setUpLevelHard();
		}else {
			map = new Map(0,0);
			winSpace = new Space(0,0);
		}
		
		return null;
	}
	public void setUpLevelEasy(){
		
	}
	public void setUpLevelMed(){
		
	}
	public void setUpLevelHard(){
		
	}
	public Space getWin() {
		return null;
	}
	public String toString() {
		return null;
	}
	public void setWin(Space s) {
		
	}
	public Boolean moveChara(Space s, int m){
		return false;
	}
	public int timer() {
		return 0;
	}
	public int moveBarrel(int i) {
		return 0;
	}
	public int getMapSize() {
		return 0;
	}
	
	//to add
	//incorpate keyboard listeners from interfacable.java

}
