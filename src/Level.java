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
	Vector<Entity> walls = null;
	Vector<Entity> mango = null;
	Vector<Entity> cherry= null;
	Vector<Entity> banana = null;
		
	

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
			setUpLevelMed();
		}else if(s == "large"){
			setUpLevelHard();
		}else {
			map = new Map(0,0);
			winSpace = new Space(0,0);
		}
		
		return null;
	}
	public void setUpLevelEasy(){
		walls = new Vector<Entity>();
		switcher = new Vector<Boolean>();
		vertic = new Vector<Boolean>();
		map = new Map(10,10);
		winSpace = new Space(9,5);
		barrelMove = 2;
		
		map.addEntity(EntityType.CHARACTER, 0, 2, false);
		//0 hori
		map.addEntity(EntityType.WALL, 0, 0, false);
		walls.add(new Entity(EntityType.WALL, 0, 0, false));
		//1 hori
		for (int i = 0; i < 10; i++) {
			if(i==0||i==2||i==3||i==4||i==6||i==7||i==8) {
				map.addEntity(EntityType.WALL, 1,i, false);
				walls.add(new Entity(EntityType.WALL, 1,i, false));
			}
		}
		//2 hori
		for (int i = 0; i < 10; i++) {
			if(i==0||i==2||i==6) {
				map.addEntity(EntityType.WALL, 2,i, false);
				walls.add(new Entity(EntityType.WALL, 2,i, false));
			}	
		}
		//3 hori
		for (int i = 0; i < 10; i++) {
			if(i==0||i==1||i==2||i==3||i==5||i==6||i==8) {
				map.addEntity(EntityType.WALL, 3,i, false);
				walls.add(new Entity(EntityType.WALL, 3,i, false));	
			}
		}
		//4 hori
		map.addEntity(EntityType.WALL, 4,5, false);
		map.addEntity(EntityType.WALL, 4,8, false);
		walls.add(new Entity(EntityType.WALL, 4,5, false));
		walls.add( new Entity(EntityType.WALL, 4,8, false));
		//5 hori
		for (int i = 0; i < 10; i++) {
			if(i==0||i==2||i==3||i==4||i==5||i==7||i==8||i==9) {
				map.addEntity(EntityType.WALL, 5,i, false);
				walls.add(new Entity(EntityType.WALL, 5,i, false));	
			}
		}
		//6 hori 
		map.addEntity(EntityType.WALL,  6,0, false);
		map.addEntity(EntityType.WALL,  6,2, false);
		walls.add(new Entity(EntityType.WALL, 6,0, false));
		walls.add(new Entity(EntityType.WALL, 6,2, false));
		//7 hori 8
		for (int i = 0; i < 10; i++) {
			if(i==0||i==1||i==2||i==4||i==5||i==6||i==7||i==8) {
				map.addEntity(EntityType.WALL, 7,i, false);
				walls.add(new Entity(EntityType.WALL, 7,i, false));	
			}
		}
		//8 hori
		map.addEntity(EntityType.WALL,  8,4, false);
		map.addEntity(EntityType.WALL, 8, 8, false);
		walls.add(new Entity(EntityType.WALL, 8,4, false));
		walls.add(new Entity(EntityType.WALL,  8, 8, false));
		// 9 hori
		for (int i = 0; i < 10; i++) {
			if(i==1||i==2||i==3||i==4||i==6) {
				map.addEntity(EntityType.WALL, 9,i, false);
				walls.add(new Entity(EntityType.WALL, 9,i, false));
			}
		}
		
		//add barrel
		map.addEntity(EntityType.BARREL, 0,9 ,false);
		switcher.add(false);
		vertic.add(false);
		map.addEntity(EntityType.BARREL, 4, 4,true);
		switcher.add(false);
		vertic.add(true);
		map.addEntity(EntityType.BARREL, 6,9,true);
		vertic.add(false);
		switcher.add(false);
		barrel.start();
		
		//add fruit
		//map.addEntity(null, barrelAmount, score, getAutoRepaintFlag());
	}

	public void setUpLevelMed(){
		map = new Map(15,15);
		winSpace = new Space(14,7);
		barrelMove = 4;
		walls = new Vector<Entity>();
		switcher = new Vector<Boolean>();
		vertic = new Vector<Boolean>();
		// chacater
		map.addEntity(EntityType.CHARACTER,  0,7, false);
		//0 horizintal
		map.addEntity(EntityType.WALL,  0,6, false);
		map.addEntity(EntityType.WALL,  0,10, false);
		walls.add(new Entity(EntityType.WALL,0,6, false));
		walls.add(new Entity(EntityType.WALL,  0,10, false));
		//1 hori
		for(int i = 0; i <15;i++) {
			if(i == 0 || i ==1|| i ==2|| i ==4|| i ==6|| i ==7|| i ==8|| i ==10|| i ==11|| i ==12|| i ==13) {
				map.addEntity(EntityType.WALL,  1,i, false);
				walls.add(new Entity(EntityType.WALL, 1,i, false));
			}
		}
		//2 hori 
		for(int i = 0; i <15;i++) {
			if(i==4||i==8||i==10) {
				map.addEntity(EntityType.WALL, 2,i, false);
				walls.add(new Entity(EntityType.WALL, 2,i, false));
			}
		}
		//3 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==2||i==4||i==6||i==7||i==8||i==10||i==12||i==14) {
				map.addEntity(EntityType.WALL, 3,i, false);
				walls.add(new Entity(EntityType.WALL, 3,i, false));
			}
		}
		//4 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==2||i==4||i==10||i==12||i==14) {
				map.addEntity(EntityType.WALL,  4,i, false);
				walls.add(new Entity(EntityType.WALL, 4,i, false));
			}
		}
		//5 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==2||i==4||i==5||i==6||i==8||i==9||i==10||i==12||i==13||i==14) {
				map.addEntity(EntityType.WALL,  5,i, false);
				walls.add(new Entity(EntityType.WALL, 5,i, false));
			}
		}
		//6 hori
		map.addEntity(EntityType.WALL, 6, 6, false);
		map.addEntity(EntityType.WALL,  6,8, false);
		walls.add(new Entity(EntityType.WALL, 6,6, false));
		walls.add(new Entity(EntityType.WALL, 6,8, false));
		//7 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==4||i==6||i==8||i==10||i==11||i==12||i==13) {
				map.addEntity(EntityType.WALL,  7,i, false);
				walls.add(new Entity(EntityType.WALL, 7,i, false));
			}
		}
		//8 hori 
		for(int i = 0; i <15;i++) {
			if(i==1||i==3||i==4||i==8||i==10||i==11) {
				map.addEntity(EntityType.WALL,  8,i, false);
				walls.add(new Entity(EntityType.WALL, 8,i, false));
			}
		}
		//9 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==3||i==8||i==13||i==14) {
				map.addEntity(EntityType.WALL,  9,i, false);
				walls.add(new Entity(EntityType.WALL, 9,i, false));
			}
		}
		//10 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==2||i==3||i==4||i==5||i==6||i==7||i==8||i==9||i==11||i==13) {
				map.addEntity(EntityType.WALL, 10,i, false);
				walls.add(new Entity(EntityType.WALL, 10,i, false));
			}
		}
		//11 hori
		map.addEntity(EntityType.WALL, 11, 11, false);
		map.addEntity(EntityType.WALL, 11,13, false);
		walls.add(new Entity(EntityType.WALL, 11,11, false));
		walls.add(new Entity(EntityType.WALL, 11,13, false));
		//12 hori
		for(int i = 0; i <15;i++) {
			if(i== 1 ||i== 2 ||i==3 ||i== 5||i==7||i==8||i==9||i==10||i==11||i==13) {
				map.addEntity(EntityType.WALL,  12,i, false);
				walls.add(new Entity(EntityType.WALL, 12,i, false));
			}
		}
		//13 hori
		for(int i = 0; i <15;i++) {
			if(i==1||i==3||i==5||i==8||i==10||i==13) {
				map.addEntity(EntityType.WALL,  13,i, false);
				walls.add(new Entity(EntityType.WALL, 13,i, false));
			}
		}
		//14 hori
		for(int i = 0; i <15;i++) {
			if(i==3||i==5||i==6||i==8) {
				map.addEntity(EntityType.WALL,  14,i, false);
				walls.add(new Entity(EntityType.WALL,14,i, false));
			}
		}
		
	}
	public void setUpLevelHard(){
		// to add
		map = new Map(25,25);
		winSpace = new Space(24,11);
		barrelMove = 6;
		walls = new Vector<Entity>();
		switcher = new Vector<Boolean>();
		vertic = new Vector<Boolean>();
		
		//player
		map.addEntity(EntityType.CHARACTER, 0, 0, false);
		
		//0 hori
		for (int i = 0; i < 25; i++) {
			if(i==8||i==20||i==21||i==22||i==23||i==24) {
				map.addEntity(EntityType.WALL, 0,i, false);
				walls.add(new Entity(EntityType.WALL, 0,i, false));	
			}
		}	
		//1 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==2||i==3||i==4||i==5||i==6||i==8||i==9||i==10||i==11||i==12||i==13||i==14||i==15||i==16||i==17||i==18) {
				map.addEntity(EntityType.WALL, 1,i, false);
				walls.add(new Entity(EntityType.WALL, 1,i, false));	
			}
		}
		//2 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==6||i==8||i==18||i==19||i==20||i==21||i==22||i==23) {
				map.addEntity(EntityType.WALL, 2,i, false);
				walls.add(new Entity(EntityType.WALL, 2,i, false));	
			}
		}
		//3 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==1||i==2||i==3||i==4||i==6||i==7||i==8||i==10||i==11||i==12||i==13||i==14||i==16) {
				map.addEntity(EntityType.WALL, 3,i, false);
				walls.add(new Entity(EntityType.WALL, 3,i, false));	
			}
		}
		//4 hori
		for (int i = 0; i < 25; i++) {
			if(i==4||i==14||i==16||i==18||i==19||i==20||i==21||i==22||i==23) {
				map.addEntity(EntityType.WALL, 4,i, false);
				walls.add(new Entity(EntityType.WALL, 4,i, false));	
			}
		}
		//5 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==2||i==3||i==4||i==6||i==8||i==9||i==10||i==11||i==12||i==14||i==16||i==18) {
				map.addEntity(EntityType.WALL, 5,i, false);
				walls.add(new Entity(EntityType.WALL, 5,i, false));	
			}
		}
		//6 hori
		for (int i = 0; i < 25; i++) {
			if(i==6||i==12||i==14||i==16||i==18||i==20||i==21||i==22||i==23||i==24) {
				map.addEntity(EntityType.WALL, 6,i, false);
				walls.add(new Entity(EntityType.WALL, 6,i, false));	
			}
		}
		//7 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==1||i==2||i==3||i==4||i==6||i==7||i==8||i==9||i==10||i==11||i==12||i==14||i==16||i==17||i==18) {
				map.addEntity(EntityType.WALL, 7,i, false);
				walls.add(new Entity(EntityType.WALL, 7,i, false));	
			}
		}
		//8 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==6||i==12||i==14||i==20||i==21||i==22||i==23||i==24) {
				map.addEntity(EntityType.WALL, 8,i, false);
				walls.add(new Entity(EntityType.WALL, 8,i, false));	
			}
		}
		//9 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==1||i==2||i==3||i==4||i==5||i==6||i==8||i==9||i==10||i==11||i==12||i==14||i==15||i==16||i==17||i==18||i==19||i==20) {
				map.addEntity(EntityType.WALL, 9,i, false);
				walls.add(new Entity(EntityType.WALL, 9,i, false));	
			}
		}
		//10 hori
		for (int i = 0; i < 25; i++) {
			if(i==8||i==14||i==22||i==23) {
				map.addEntity(EntityType.WALL, 10,i, false);
				walls.add(new Entity(EntityType.WALL, 10,i, false));	
			}
		}
		//11 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==1||i==2||i==4||i==5||i==6||i==7||i==8||i==9||i==10||i==11||i==12||i==14||i==16||i==17||i==18||i==19||i==20||i==21||i==22||i==23) {
				map.addEntity(EntityType.WALL, 11,i, false);
				walls.add(new Entity(EntityType.WALL, 11,i, false));	
			}
		}
		//12 hori
		for (int i = 0; i < 25; i++) {
			if(i==2||i==4||i==12||i==14||i==17||i==23) {
				map.addEntity(EntityType.WALL, 12,i, false);
				walls.add(new Entity(EntityType.WALL, 12,i, false));	
			}
		}
		//13 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==2||i==4||i==5||i==6||i==7||i==9||i==10||i==12||i==14||i==16||i==17||i==19||i==20||i==21||i==22||i==23) {
				map.addEntity(EntityType.WALL, 13,i, false);
				walls.add(new Entity(EntityType.WALL, 13,i, false));	
			}
		}
		//14 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==9||i==10||i==12||i==14||i==16||i==19) {
				map.addEntity(EntityType.WALL, 14,i, false);
				walls.add(new Entity(EntityType.WALL, 14,i, false));	
			}
		}
		//15 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==2||i==3||i==4||i==5||i==6||i==7||i==8||i==9||i==10||i==12||i==14||i==16||i==18||i==19||i==20||i==21||i==22||i==23||i==24) {
				map.addEntity(EntityType.WALL, 15,i, false);
				walls.add(new Entity(EntityType.WALL, 15,i, false));	
			}
		}
		//16 hori
		map.addEntity(EntityType.WALL, 16,14, false);
		walls.add(new Entity(EntityType.WALL, 16,14, false));
		//17 hori fix
		for (int i = 0; i < 25; i++) {
			if(i==1||i==2||i==3||i==4||i==5||i==6||i==7||i==8||i==9||i==10||i==11||i==12||i==13||i==14||i==16||i==17||i==18||i==20||i==22||i==23) {
				map.addEntity(EntityType.WALL, 17,i, false);
				walls.add(new Entity(EntityType.WALL, 17,i, false));	
			}
		}
		//18 hori
		for (int i = 0; i < 25; i++) {
			if(i==18||i==20||i==22||i==23) {
				map.addEntity(EntityType.WALL, 18,i, false);
				walls.add(new Entity(EntityType.WALL, 18,i, false));	
			}
		}
		//19 hori
		for (int i = 0; i < 25; i++) {
			if(i==0||i==1||i==2||i==3||i==4||i==6||i==8||i==9||i==10||i==11||i==12||i==14||i==15||i==16||i==18||i==20||i==22||i==23) {
				map.addEntity(EntityType.WALL, 19,i, false);
				walls.add(new Entity(EntityType.WALL, 19,i, false));	
			}
		}
		//20 hori fix
		for (int i = 0; i < 25; i++) {
			if(i==4||i==6||i==8||i==12||i==16||i==18||i==20||i==22) {
				map.addEntity(EntityType.WALL, 20,i, false);
				walls.add(new Entity(EntityType.WALL, 20,i, false));	
			}
		}
		//21 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==2||i==3||i==4||i==6||i==8||i==10||i==12||i==13||i==14||i==16||i==18||i==20||i==22||i==23||i==24) {
				map.addEntity(EntityType.WALL, 21,i, false);
				walls.add(new Entity(EntityType.WALL, 21,i, false));	
			}
		}
		//22 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==6||i==8||i==10||i==14||i==16||i==18||i==20||i==23||i==24) {
				map.addEntity(EntityType.WALL, 22,i, false);
				walls.add(new Entity(EntityType.WALL, 22,i, false));	
			}
		}
		//23 hori
		for (int i = 0; i < 25; i++) {
			if(i==1||i==2||i==3||i==4||i==5||i==6||i==8||i==10||i==11||i==12||i==14||i==15||i==16||i==18||i==20||i==21||i==22||i==23||i==24) {
				map.addEntity(EntityType.WALL, 23,i, false);
				walls.add(new Entity(EntityType.WALL, 23,i, false));	
			}
		}
		//24 hori
		for (int i = 0; i < 25; i++) {
			if(i==8||i==12||i==18) {
				map.addEntity(EntityType.WALL, 24,i, false);
				walls.add(new Entity(EntityType.WALL, 24,i, false));	
			}
		}
		//16 hori	
		//WALLS
			
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
	public Space getCharSpace() {
		return map.getCharacterSpace();
	}
	public void setCharSpace(int row, int col) {
		map.setCharacterSpace(row,col);
		
	}
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
	
	public Vector<Entity> getWalls() {
		return walls;
	}
	
	public Vector<Entity> getBarrels() {
		return map.getBarrels();
	}
	
	public Vector<Entity> getBananas() {
		return banana;
	}
	
	public Vector<Entity> getCherries() {
		return cherry;
	}
	
	public Vector<Entity> getMangos() {
		return mango;
	}
	
	public void checkPath() {
		Vector<Entity> checking = map.getBarrels();
		int o = 0;
		Boolean catcher = null;
		System.out.println("Now checking all barrel apths");
		for(Entity i: checking) {
			
			if(vertic.elementAt(o)) {
				if(switcher.elementAt(o)) {
					if (i.getCol()-1 >= 0) {
						if(map.wallCollision(new Space(i.getRow(),i.getCol()-1))) {
							catcher= !switcher.elementAt(o);
							switcher.setElementAt(catcher,o);
						}
					}else {
						continue;
					}
				}else {
					if (i.getCol()+1 <= 10) {
						if(map.wallCollision(new Space(i.getRow(),i.getCol()+1))) {
							catcher= !switcher.elementAt(o);
							switcher.setElementAt(catcher,o);
						}
					}else {
						continue;
					}
				}
				
			}else {
				if(switcher.elementAt(o)) {
					if (i.getRow()-1 >= 0) {
						if(map.wallCollision(new Space(i.getRow()-1,i.getCol()))) {
							catcher= !switcher.elementAt(o);
							switcher.setElementAt(catcher,o);
						}
					}else {
						continue;
					}
				}else {
					if (i.getRow()+1 <= 10) {
						if(map.wallCollision(new Space(i.getRow()+1,i.getCol()))) {
							catcher= !switcher.elementAt(o);
							switcher.setElementAt(catcher,o);
						}
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
	
	public Vector<Boolean> getSwitcher() {
		return switcher;
	}
	
	public Vector<Boolean> getVertic() {
		return vertic;
	}
	
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
