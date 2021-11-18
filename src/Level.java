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
	int barrelAmount =0;
	int min = 0;
	int max = 0;
	Random randNum = new Random();
	Space winSpace;
	private int score = 0;
	private int numLives = 3;
	Vector<LeaderBoard> lead = new Vector<LeaderBoard>();
	Timer barrel = new Timer(1000, this);
	Vector<Boolean> switcher = null;
	Vector<Boolean> vertic = null;
	

	public void run() {
		System.out.println("hey boyi i'm workng here");
		barrel.start();
		for (int i = 0; i < 10;i++) {
		setUpLevelEasy();
		}
	}
	
	
	public void init() {
		addKeyListeners();
		addMouseListeners();
		requestFocus();
	}
	
	public Level createLevel(String s) {
		mapSize = s;
		//made created of small level as defualt for testing purposes "SO REMOVE THIS LATER ON WITH s= "small""
		if(s== "small") {
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
		switcher = new Vector<Boolean>();
		vertic = new Vector<Boolean>();
		//DELETE
		max = 3;
		min = 1;
		int locMin = 1;
		int locMax = 6;
		map = new Map(10,10);
		winSpace = new Space(9,5);
		barrelMove = 2;
		
		map.addEntity(EntityType.CHARACTER, 0, 0, false);
		//0 hori
		map.addEntity(EntityType.WALL, 0, 0, false);
		//1 hori
		map.addEntity(EntityType.WALL, 0, 1, false);
		map.addEntity(EntityType.WALL, 2, 1, false);
		map.addEntity(EntityType.WALL, 3, 1, false);
		map.addEntity(EntityType.WALL, 4, 1, false);
		map.addEntity(EntityType.WALL, 6, 1, false);
		map.addEntity(EntityType.WALL, 7, 1, false);
		map.addEntity(EntityType.WALL, 8, 1, false);
		//2 hori
		map.addEntity(EntityType.WALL, 0, 2, false);
		map.addEntity(EntityType.WALL, 2, 2, false);
		map.addEntity(EntityType.WALL, 6, 2, false);
		//3 hori
		map.addEntity(EntityType.WALL, 0, 3, false);
		map.addEntity(EntityType.WALL, 1, 3, false);
		map.addEntity(EntityType.WALL, 2, 3, false);
		map.addEntity(EntityType.WALL, 3, 3, false);
		map.addEntity(EntityType.WALL, 5, 3, false);
		map.addEntity(EntityType.WALL, 6, 3, false);
		map.addEntity(EntityType.WALL, 8, 3, false);
		//4 hori
		map.addEntity(EntityType.WALL, 5, 4, false);
		map.addEntity(EntityType.WALL, 8, 4, false);
		//5 hori
		map.addEntity(EntityType.WALL, 0, 5, false);
		map.addEntity(EntityType.WALL, 2, 5, false);
		map.addEntity(EntityType.WALL, 3, 5, false);
		map.addEntity(EntityType.WALL, 4, 5, false);
		map.addEntity(EntityType.WALL, 5, 5, false);
		map.addEntity(EntityType.WALL, 7, 5, false);
		map.addEntity(EntityType.WALL, 8, 5, false);
		map.addEntity(EntityType.WALL, 9, 5, false);
		//6 hori 
		map.addEntity(EntityType.WALL, 0, 6, false);
		map.addEntity(EntityType.WALL, 2, 6, false);
		//7 hori 8
		map.addEntity(EntityType.WALL, 0, 7, false);
		map.addEntity(EntityType.WALL, 1, 7, false);
		map.addEntity(EntityType.WALL, 2, 7, false);
		map.addEntity(EntityType.WALL, 4, 7, false);
		map.addEntity(EntityType.WALL, 5, 7, false);
		map.addEntity(EntityType.WALL, 6, 7, false);
		map.addEntity(EntityType.WALL, 7, 7, false);
		map.addEntity(EntityType.WALL, 8, 7, false);
		//8 hori
		map.addEntity(EntityType.WALL, 4, 8, false);
		map.addEntity(EntityType.WALL, 8, 8, false);
		// 9 hori
		map.addEntity(EntityType.WALL, 1, 9, false);
		map.addEntity(EntityType.WALL, 2, 9, false);
		map.addEntity(EntityType.WALL, 3, 9, false);
		map.addEntity(EntityType.WALL, 4, 9, false);
		map.addEntity(EntityType.WALL, 6, 9, false);
		
		//add barrell
		map.addEntity(EntityType.BARREL, 9,0 ,false);
		switcher.add(false);
		vertic.add(false);
		map.addEntity(EntityType.BARREL, 4, 4,true);
		switcher.add(false);
		vertic.add(true);
		map.addEntity(EntityType.BARREL, 9, 6,true);
		vertic.add(false);
		switcher.add(false);
	}
	public void setUpLevelMed(){
		// chacater
		map.addEntity(EntityType.CHARACTER, 7, 0, false);
		//0 horizintal
			map.addEntity(EntityType.WALL, 6, 0, false);
			map.addEntity(EntityType.WALL, 10, 0, false);
		//1 hori
			map.addEntity(EntityType.WALL, 0, 1, false);
			map.addEntity(EntityType.WALL, 1, 1, false);
			map.addEntity(EntityType.WALL, 2, 1, false);
			map.addEntity(EntityType.WALL, 4, 1, false);
			map.addEntity(EntityType.WALL, 6, 1, false);
			map.addEntity(EntityType.WALL, 7, 1, false);
			map.addEntity(EntityType.WALL, 8, 1, false);
			map.addEntity(EntityType.WALL, 10, 1, false);
			map.addEntity(EntityType.WALL, 11, 1, false);
			map.addEntity(EntityType.WALL, 12, 1, false);
			map.addEntity(EntityType.WALL, 13, 1, false);
		
		//2 hori 
			map.addEntity(EntityType.WALL, 4, 2, false);
			map.addEntity(EntityType.WALL, 8, 2, false);
			map.addEntity(EntityType.WALL, 10, 2, false);
		//3 hori
			map.addEntity(EntityType.WALL, 1, 3, false);
			map.addEntity(EntityType.WALL, 2, 3, false);
			map.addEntity(EntityType.WALL, 4, 3, false);
			map.addEntity(EntityType.WALL, 6, 3, false);
			map.addEntity(EntityType.WALL, 7, 3, false);
			map.addEntity(EntityType.WALL, 8, 3, false);
			map.addEntity(EntityType.WALL, 10, 3, false);
			map.addEntity(EntityType.WALL, 12, 3, false);
			map.addEntity(EntityType.WALL, 14, 3, false);
		//4 hori
			map.addEntity(EntityType.WALL, 1, 4, false);
			map.addEntity(EntityType.WALL, 2, 4, false);
			map.addEntity(EntityType.WALL, 4, 4, false);
			map.addEntity(EntityType.WALL, 10, 4, false);
			map.addEntity(EntityType.WALL, 12, 4, false);
			map.addEntity(EntityType.WALL, 14, 4, false);
		//5 hori
			map.addEntity(EntityType.WALL, 5, 1, false);
			map.addEntity(EntityType.WALL, 5, 2, false);
			map.addEntity(EntityType.WALL, 5, 4, false);
			map.addEntity(EntityType.WALL, 5, 5, false);
			map.addEntity(EntityType.WALL, 5, 6, false);
			map.addEntity(EntityType.WALL, 5, 8, false);
			map.addEntity(EntityType.WALL, 5, 9, false);
			map.addEntity(EntityType.WALL, 5, 10, false);
			map.addEntity(EntityType.WALL, 5, 12, false);
			map.addEntity(EntityType.WALL, 5, 13, false);
			map.addEntity(EntityType.WALL, 5, 14, false);
		//6 hori
			map.addEntity(EntityType.WALL, 6, 6, false);
			map.addEntity(EntityType.WALL, 8, 6, false);
		//7 hori
			map.addEntity(EntityType.WALL, 1, 7, false);
			map.addEntity(EntityType.WALL, 4, 7, false);
			map.addEntity(EntityType.WALL, 6, 7, false);
			map.addEntity(EntityType.WALL, 8, 7, false);
			map.addEntity(EntityType.WALL, 10, 7, false);
			map.addEntity(EntityType.WALL, 11, 7, false);
			map.addEntity(EntityType.WALL, 12, 7, false);
			map.addEntity(EntityType.WALL, 13, 7, false);
		//8 hori 
			map.addEntity(EntityType.WALL, 1, 8, false);
			map.addEntity(EntityType.WALL, 3, 8, false);
			map.addEntity(EntityType.WALL, 4, 8, false);
			map.addEntity(EntityType.WALL, 8, 8, false);
			map.addEntity(EntityType.WALL, 10, 8, false);
			map.addEntity(EntityType.WALL, 11, 8, false);
		//9 hori
			map.addEntity(EntityType.WALL, 1, 9, false);
			map.addEntity(EntityType.WALL, 3, 9, false);
			map.addEntity(EntityType.WALL, 8, 9, false);
			map.addEntity(EntityType.WALL, 12, 9, false);
			map.addEntity(EntityType.WALL, 14, 9, false);
		//10 hori
			map.addEntity(EntityType.WALL, 1, 10, false);
			map.addEntity(EntityType.WALL, 2, 10, false);
			map.addEntity(EntityType.WALL, 3, 10, false);
			map.addEntity(EntityType.WALL, 4, 10, false);
			map.addEntity(EntityType.WALL, 5, 10, false);
			map.addEntity(EntityType.WALL, 6, 10, false);
			map.addEntity(EntityType.WALL, 7, 10, false);
			map.addEntity(EntityType.WALL, 8, 10, false);
			map.addEntity(EntityType.WALL, 9, 10, false);
			map.addEntity(EntityType.WALL, 11, 10, false);
			map.addEntity(EntityType.WALL, 13, 10, false);
		//11 hori
			map.addEntity(EntityType.WALL, 11, 11, false);
			map.addEntity(EntityType.WALL, 13, 11, false);
		//12 hori
			map.addEntity(EntityType.WALL, 1, 12, false);
			map.addEntity(EntityType.WALL, 2, 12, false);
			map.addEntity(EntityType.WALL, 3, 12, false);
			map.addEntity(EntityType.WALL, 5, 12, false);
			map.addEntity(EntityType.WALL, 7, 12, false);
			map.addEntity(EntityType.WALL, 8, 12, false);
			map.addEntity(EntityType.WALL, 9, 12, false);
			map.addEntity(EntityType.WALL, 10, 12, false);
			map.addEntity(EntityType.WALL, 11, 12, false);
			map.addEntity(EntityType.WALL, 13, 12, false);
		//13 hori
			map.addEntity(EntityType.WALL, 1, 13, false);
			map.addEntity(EntityType.WALL, 3, 13, false);
			map.addEntity(EntityType.WALL, 5, 13, false);
			map.addEntity(EntityType.WALL, 8, 13, false);
			map.addEntity(EntityType.WALL, 10, 13, false);
			map.addEntity(EntityType.WALL, 13, 13, false);
		//14 hori
			map.addEntity(EntityType.WALL, 3, 14, false);
			map.addEntity(EntityType.WALL, 5, 14, false);
			map.addEntity(EntityType.WALL, 6, 14, false);
			map.addEntity(EntityType.WALL, 8, 14, false);
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
	public int getNumRows() {
		return map.getNumRows();
	}
	public int getNumCols() {
		return map.getNumCols();
	}
	//DELETE
	/*
	public boolean barrelCreate(Space s) {
		// FOR TESTING ONLY
		if(map.getEnt(s)==null) {
			System.out.println("nuthing to worry here");
		}else {
			System.out.println("Uh-oh check out put");
		}
		if (map.wallCollision(s)) {
			return true;
		}else {
			return false;
		}
		*/	
	public void collision(Space s){
		if (!map.wallCollision(s)) {
			if (map.bananaCollision(s)) {
				score += 10;
				System.out.println("Banana collected!! +10 points");
			}
			if (map.cherryCollision(s)) {
				score += 7;
				System.out.println("Cherry collected!! +7 points");
			}
			if (map.mangoCollision(s)) {
				System.out.println("Cherry collected!! +7 points");
				score += 5;
				
			}
			if (map.barrelCollision(s)) {
				System.out.println("Barrel collsion detected!!!");
				--numLives;
				map.resetChara();
				
			}
		}
	}
	public int timer() {
		return barrel.getDelay();
	}
	public int moveBarrel(int i) {
		barrelMove = i;
		return barrelMove;
	}
	
	public void checkPath() {
		ArrayList<Entity> checking = map.barrels;
		int o = 0;
		Boolean catcher = null;
		System.out.println("Now checking all barrel apths");
		for(Entity i: checking) {
			
			if(vertic.elementAt(o)) {
				if(switcher.elementAt(o)) {
					if(map.wallCollision(new Space(i.getRow(),i.getCol()-1))) {
						catcher= !switcher.elementAt(o);
						switcher.setElementAt(catcher,o);
					}else {
						continue;
					}
				}else {
					if(map.wallCollision(new Space(i.getRow(),i.getCol()+1))) {
						catcher= !switcher.elementAt(o);
						switcher.setElementAt(catcher,o);
					}else {
						continue;
					}
				}
				
			}else {
				if(switcher.elementAt(o)) {
					if(map.wallCollision(new Space(i.getRow()-1,i.getCol()))) {
						catcher= !switcher.elementAt(o);
						switcher.setElementAt(catcher,o);
					}else {
						continue;
					}
				}else {
					if(map.wallCollision(new Space(i.getRow()+1,i.getCol()))) {
						catcher= !switcher.elementAt(o);
						switcher.setElementAt(catcher,o);
					}else {
						continue;
					}
				}
			}
		}
	}
	public String getMapSize() {
		return mapSize;
	}
	//REMOVE COMMENT
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("now checking movenment");
		checkPath();
		System.out.println("Now moving narrels");
		map.moveBarrels(1, vertic,switcher);
	}

	
	
	@Override
	public void keyPressed(KeyEvent e) {
		Space movenment;
	    int key = e.getKeyCode();

	    if (key == KeyEvent.VK_LEFT) {
	        System.out.println("going left");
	        movenment = new Space(map.getCharacterRow(),map.getCharacterCol()-1);
	        map.moveChara(movenment);
	        collision(movenment);
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
	    	collision(movenment);
	    }
	    
	    
	    
	    if (key == KeyEvent.VK_A) {
	        System.out.println("going left (WASD)");
	        movenment = new Space(map.getCharacterRow(),map.getCharacterCol()-1);
	        map.moveChara(movenment);
	        collision(movenment);
	    }

	    if (key == KeyEvent.VK_D) {
	    	System.out.println("going right (WASD)");
	    	movenment = new Space(map.getCharacterRow(),map.getCharacterCol()+1);
	    	map.moveChara(movenment);
	    	collision(movenment);
	    }

	    if (key == KeyEvent.VK_W) {
	    	System.out.println("going up (WASD)");
	    	movenment = new Space(map.getCharacterRow()+1,map.getCharacterCol());
	    	map.moveChara(movenment);
	    	collision(movenment);
	    }

	    if (key == KeyEvent.VK_S) {
	    	System.out.println("going down (WASD)");
	    	movenment = new Space(map.getCharacterRow()-1,map.getCharacterCol());
	    	map.moveChara(movenment);
	    	collision(movenment);
	    }
	}
	
	public static void main(String[] args) {
		new Level().start();
	}
	
}
