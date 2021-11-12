import java.util.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import acm.program.*;

public class Level extends GraphicsProgram implements EventListener, ActionListener,KeyListener {
	String mapSize;
	Map map;
	int barrelMove = 0;
	Space winSpace;
	private int score = 0;
	private int numLives = 3;
	Vector<LeaderBoard> lead = new Vector<LeaderBoard>();
	Timer barrel = new Timer(1000, this);
	

	public void run() {
		System.out.println("hey boyi i'm workng here");
		barrel.start();
	}
	
	public static void main(String[] args) {
		new Level().start();
	}
	
	public void init() {
		addKeyListeners();
		addMouseListeners();
		requestFocus();
	}
	
	public Level createLevel(String s) {
		mapSize = s;
		
		if(s == "small") {
			map = new Map(10,10);
			winSpace = new Space(9,5);
			barrelMove = 2;
			setUpLevelEasy();
		}else if(s == "medium") {
			map = new Map(15,15);
			winSpace = new Space(14,7);
			barrelMove = 4;
			setUpLevelMed();
		}else if(s == "large"){
			map = new Map(25,25);
			winSpace = new Space(24,11);
			barrelMove = 6;
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
		
		//player
		map.addEntity(EntityType.CHARACTER, 0, 0, false);
		
		//WALLS
		//Three Horizontal 
		for(int i = 1; i < 3; i++) 
		{ 
			map.addEntity(EntityType.WALL, i, 0, false);
			map.addEntity(EntityType.WALL, 7+i, 0, false);
			map.addEntity(EntityType.WALL, 21+i, 1, false);
			map.addEntity(EntityType.WALL, 13+i, 1, false);
			map.addEntity(EntityType.WALL, 11+i, 2, false);
			map.addEntity(EntityType.WALL, 3+i, 4, false);
			map.addEntity(EntityType.WALL, 11+i, 4, false);
			map.addEntity(EntityType.WALL, 19+i, 4, false);
			map.addEntity(EntityType.WALL, 1+i, 6, false);
			map.addEntity(EntityType.WALL, 9+i, 8, false);
			map.addEntity(EntityType.WALL, 13+i, 9, false);
			map.addEntity(EntityType.WALL, 13+i, 10, false);
			map.addEntity(EntityType.WALL, 21+i, 10, false);
			map.addEntity(EntityType.WALL, 19+i, 12, false);
			map.addEntity(EntityType.WALL, 21+i, 14, false);
			map.addEntity(EntityType.WALL, 13+i, 16, false);
			map.addEntity(EntityType.WALL, 11+i, 17, false);
			map.addEntity(EntityType.WALL, 13+i, 19, false);
			map.addEntity(EntityType.WALL, 21+i, 24, false);
		}
		
		//Three Vertical
		for(int i = 0; i < 3; i++) 
		{
			map.addEntity(EntityType.WALL, 3, 1+i, false);
			map.addEntity(EntityType.WALL, 5, 1+i, false);
			map.addEntity(EntityType.WALL, 11, 5+i, false);
			map.addEntity(EntityType.WALL, 13, 5+i, false);
			map.addEntity(EntityType.WALL, 9, 9+i, false);
			map.addEntity(EntityType.WALL, 11, 9+i, false);
			map.addEntity(EntityType.WALL, 19, 9+i, false);
			map.addEntity(EntityType.WALL, 19, 14+i, false);
			map.addEntity(EntityType.WALL, 17, 16+i, false);
			map.addEntity(EntityType.WALL, 7, 16+i, false);
			map.addEntity(EntityType.WALL, 13, 20+i, false);
			map.addEntity(EntityType.WALL, 21, 22+i, false);
		}
		
		//Four Vertical
		for(int i = 0; i < 4; i++) 
		{
			map.addEntity(EntityType.WALL, 19, i, false);
			map.addEntity(EntityType.WALL, 7, 1+i, false);
			map.addEntity(EntityType.WALL, 1, 2+i, false);
			map.addEntity(EntityType.WALL, 23, 2+i, false);
			map.addEntity(EntityType.WALL, 5, 8+i, false);
			map.addEntity(EntityType.WALL, 3, 10+i, false);
			map.addEntity(EntityType.WALL, 23, 21+i, false);
		}
		
		//Other
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 11, i, false);}
		for(int i = 0; i < 7; i++) 
		{map.addEntity(EntityType.WALL, 15, 2+i, false);}
		for(int i = 0; i < 6; i++) 
		{map.addEntity(EntityType.WALL, 9, 1+i, false);}
		for(int i = 0; i < 4; i++) 
		{map.addEntity(EntityType.WALL, 5+i, 6, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 19+i, 6, false);}
		for(int i = 0; i < 14; i++) 
		{map.addEntity(EntityType.WALL, 17, 1+i, false);}
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 21, 2+i, false);}
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 3, 7+i, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 7, 7+i, false);}
		for(int i = 0; i < 3; i++) 
		{map.addEntity(EntityType.WALL, i, 8, false);}
		for(int i = 0; i < 10; i++) 
		{map.addEntity(EntityType.WALL, 1, 9+i, false);}
		for(int i = 0; i < 14; i++) 
		{map.addEntity(EntityType.WALL, 3+i, 14, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 5+i, 12, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 11+i, 12, false);}
		for(int i = 0; i < 6; i++) 
		{map.addEntity(EntityType.WALL, 19+i, 8, false);}
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 23+i, 12, false);}
		for(int i = 0; i < 4; i++) 
		{map.addEntity(EntityType.WALL, 3+i, 17, false);}
		for(int i = 0; i < 4; i++) 
		{map.addEntity(EntityType.WALL, 20+i, 17, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 0, 20+i, false);}
		for(int i = 0; i < 6; i++) 
		{map.addEntity(EntityType.WALL, 2, 18+i, false);}
		for(int i = 0; i < 6; i++) 
		{map.addEntity(EntityType.WALL, 4, 18+i, false);}
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 5+i, 18, false);}
		for(int i = 0; i < 6; i++) 
		{map.addEntity(EntityType.WALL, 9, 15+i, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 11, 18+i, false);}
		for(int i = 0; i < 7; i++) 
		{map.addEntity(EntityType.WALL, 18+i, 18, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 6, 20+i, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 8, 20+i, false);}
		for(int i = 0; i < 5; i++) 
		{map.addEntity(EntityType.WALL, 15, 20+i, false);}
		for(int i = 0; i < 7; i++) 
		{map.addEntity(EntityType.WALL, 17+i, 20, false);}
		for(int i = 0; i < 4; i++) 
		{map.addEntity(EntityType.WALL, 16+i, 23, false);}
		for(int i = 0; i < 3; i++) 
		{map.addEntity(EntityType.WALL, 16+i, 24, false);}
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 10, 23+i, false);}
		for(int i = 0; i < 2; i++) 
		{map.addEntity(EntityType.WALL, 12+i, 24, false);}
		
		//Singles
		map.addEntity(EntityType.WALL, 23, 11, false);
		map.addEntity(EntityType.WALL, 21, 14, false);
		map.addEntity(EntityType.WALL, 11, 16, false);
		map.addEntity(EntityType.WALL, 22, 24, false);
		map.addEntity(EntityType.WALL, 23, 15, false);
	}
	public Space getWin() {
		return winSpace;
	}
	public String toString() {
		return null;
	}
	public void setWin(Space s) {
		map.setWinSpace(s);
	}
	public int getScore() {
		return score;
	}
	public int getLives() {
		return numLives;
	}
	public Boolean moveChara(Space s, int m){
		if (!map.wallCollision(s)) {
			if (map.bananaCollision(s)) {
				score += 5;
				return true;
			}
			if (map.cherryCollision(s)) {
				score += 2;
				return true;
			}
			if (map.mangoCollision(s)) {
				score += 1;
				return true;
			}
			if (map.barrelCollision(s)) {
				--numLives;
				map.resetChara();
				return true;
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
	public String getMapSize() {
		return mapSize;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		map.moveBarrels(barrelMove, false);
	}

	
	
	@Override
	public void keyPressed(KeyEvent e) {
		Space movenment;
	    int key = e.getKeyCode();

	    if (key == KeyEvent.VK_LEFT) {
	        System.out.println("going left");
	        movenment = new Space(map.getCharacterRow(),map.getCharacterCol()-1);
	        map.moveChara(movenment);
	    }

	    if (key == KeyEvent.VK_RIGHT) {
	    	System.out.println("going right");
	    	movenment = new Space(map.getCharacterRow(),map.getCharacterCol()+1);
	    	map.moveChara(movenment);
	    }

	    if (key == KeyEvent.VK_UP) {
	    	System.out.println("going up");
	    	movenment = new Space(map.getCharacterRow()+1,map.getCharacterCol());
	    	map.moveChara(movenment);
	    }

	    if (key == KeyEvent.VK_DOWN) {
	    	System.out.println("going down");
	    	movenment = new Space(map.getCharacterRow()-1,map.getCharacterCol());
	    	map.moveChara(movenment);
	    }
	}
	//to add
	//incorpate keyboard listeners from interfacable.java

}
