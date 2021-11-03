import java.util.*;
public class Level {
	String mapSize;
	Map map;
	int barrelMove;
	Space winSpace;
	private int score = 0;
	private int numLives = 3;
	Vector<LeaderBoard> lead = new Vector<LeaderBoard>();
	
	
	
	public Level createLevel(String s) {
		mapSize = s;
		
		if(s == "small") {
			map = new Map(5,6);
			winSpace = new Space(0,6);
			setUpLevelEasy();
		}else if(s == "medium") {
			map = new Map(8,9);
			winSpace = new Space(8,0);
			setUpLevelMed();
		}else if(s == "large"){
			map = new Map(10,10);
			winSpace = new Space(0,0);
			setUpLevelHard();
		}else {
			map = new Map(0,0);
			winSpace = new Space(0,0);
		}
		
		return null;
	}
	public void setUpLevelEasy(){
		for(int i = 0; i < 4; i++) {
			map.addEntity(EntityType.WALL, 1, 6-i, false);
		}
		for(int i = 0; i < 4; i++) {
			map.addEntity(EntityType.WALL, 3, i, false);
		}
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
		//FIXME
		//CHANGE SCORE TO ACTUAL FRUIT VALUES
		if (map.wallCollision(s)) {
			if (map.bananaCollision(s)) {
				score += 0;
			}
			if (map.cherryCollision(s)) {
				score += 0;
			}
			if (map.mangoCollision(s)) {
				score += 0;
			}
			if (map.barrelCollision(s)) {
				--numLives;
				//FIXME
				/*
				 either give cooldown and keep player in same space,
				 allowing them to move past
				 OR
				 reset player to start of map
				 */
			}
		}
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
