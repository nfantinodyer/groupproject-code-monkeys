import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;

public class GraphicsGame extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program;
	private static final int LIFE_WIDTH = 40;
	private static final int LIFE_HEIGHT = 40;
	public static final int WINDOW_WIDTH = 1600;
	public static final int WINDOW_HEIGHT = 800;
	private Level level = new Level();
	
	private GLabel lives = new GLabel("LIVES: ", 10, 30);
	private GLabel score = new GLabel("SCORE: 0", 1250, 25);
	private GImage character;
	private GImage entities;
	private GRect winSpace;
	private GRect wall;
	
	//used in keyEvents
	private double x;
	private double y;
	private int row;
	private int col;
	
	private int monkey = 0;
	private int points = 0;
	Vector<Entity> barrels = new Vector<Entity>();
	Vector<Entity> walls = new Vector<Entity>();
	Vector<Entity> bananas = new Vector<Entity>();
	Vector<Entity> cherries = new Vector<Entity>();
	Vector<Entity> mangos = new Vector<Entity>();
	private String s = "";
	
	
	private ArrayList<GLine> gridLines = new ArrayList<GLine>();

	public GraphicsGame(MainApplication app) {
		this.program = app;
		
		lives.setFont("Arial-26");
		score.setFont("Arial-26");
		lives.setColor(Color.RED);
		score.setColor(Color.RED);
	}
	
	public void setMonkey(int monkey) {
		this.monkey = monkey;
	}
	
	public int getMonkey() {
		return monkey;
	}
	
	public void setupEasy() {
		level.createLevel("small");
		s="easy";
	}
	
	public void setupMedium() {
		level.createLevel("medium");
		s="medium";
	}
	
	public void setupHard() {
		level.createLevel("large");
		s="hard";
	}
	
	public void resize()
	{
		if(s=="easy")
		{
			character.scale(.2);
		}
		else if(s=="medium")
		{
			character.scale(.15);
		}
		else
		{
			character.scale(.11);
		}
			
	}
	
	private void drawEntities() {
		//entities will be reused in this method for character, barrels, and fruits
		//not working yet, need images in folder
		
		walls = level.getWalls();
		barrels = level.getBarrels();
		bananas = level.getBananas();
		cherries = level.getCherries();
		mangos = level.getMangos();
		
		
		
		for (Entity temp:walls) {
			wall = new GRect(temp.getRow() * spaceWidth(), temp.getCol() * spaceHeight(), spaceWidth(), spaceHeight());
			wall.setFillColor(Color.BLACK);
			wall.setFilled(true);
			program.add(wall);
		}
		
		int startRow = level.map.getStartSpace().getRow();
		int startCol = level.map.getStartSpace().getCol();
		if(monkey == 1)
		{
			character = new GImage("Chimp_Cartoon.jpg", startRow * spaceHeight(), startCol * spaceWidth());
		}
		else if(monkey==2)
		{
			character = new GImage("Gorilla_Cartoon.jpg", startRow * spaceHeight(), startCol * spaceWidth());
		}
		else
		{
			character = new GImage("Orangutan_Cartoon.jpg", startRow * spaceHeight(), startCol * spaceWidth());
		}
		resize();
		program.add(character);
		
		for (Entity temp:barrels) {
			entities = new GImage("barrel.png", temp.getRow() * spaceWidth(), temp.getCol() * spaceHeight());
			program.add(entities);
		}
		
		/*for (Entity temp:bananas) {
			entities = new GImage("Banana.png", temp.getRow() * spaceWidth(), temp.getCol() * spaceHeight());
			program.add(entities);
		}
		
		for (Entity temp:cherries) {
			entities = new GImage("Cherry.png", temp.getRow() * spaceWidth(), temp.getCol() * spaceHeight());
			program.add(entities);
		}
		
		for (Entity temp:mangos) {
			entities = new GImage("Mango.png", temp.getRow() * spaceWidth(), temp.getCol() * spaceHeight());
			program.add(entities);
		}*/
	}
	
	private void drawLives() {
		GOval lifeOne = new GOval(100, 5, LIFE_WIDTH, LIFE_HEIGHT);
		GOval lifeTwo = new GOval(150, 5, LIFE_WIDTH, LIFE_HEIGHT);
		GOval lifeThree = new GOval(200, 5, LIFE_WIDTH, LIFE_HEIGHT);
		
		lifeOne.setFilled(true);
		lifeTwo.setFilled(true);
		lifeThree.setFilled(true);
		
		lifeOne.setFillColor(Color.red);
		lifeTwo.setFillColor(Color.red);
		lifeThree.setFillColor(Color.red);
		
		program.add(lifeOne);
		program.add(lifeTwo);
		program.add(lifeThree); 
		
	}
	
	private void drawWinningSpace() {
		int winRow = level.getWin().getRow();
		int winCol = level.getWin().getCol();
		
		winSpace = new GRect(winRow * spaceWidth(), winCol * spaceHeight(), spaceWidth(), spaceHeight());
		winSpace.setFillColor(Color.RED);
		winSpace.setFilled(true);
		program.add(winSpace);
	}
	
	private void drawGridLines(String s) {
		int num = 0;
		if(s=="hard")
		{num = 25;}
		else if(s=="medium")
		{num = 15;}
		else
		{num=10;}
		for (int i = 0; i < num; ++i) {
			
			GLine gridLine = new GLine(0, spaceHeight()*i, WINDOW_WIDTH, spaceHeight()*i);
			gridLines.add(gridLine);
		}
		for (int i = 0; i < num; ++i) {
			
			GLine gridLine = new GLine(spaceWidth()*i, 0, spaceWidth()*i,WINDOW_HEIGHT );
			gridLines.add(gridLine);
		}
		for(GLine l:gridLines)
		{
			program.add(l);
		}
	}
	
	public void removeGridLines()
	{
		for(GLine l:gridLines)
		{
			program.remove(l);
		}
	}
	
	private double spaceWidth() {
		int num = 0;
		if(s=="hard")
		{num = 25;}
		else if(s=="medium")
		{num = 15;}
		else
		{num=10;}
		return WINDOW_WIDTH / num;
	}
	
	private double spaceHeight() {
		int num = 0;
		if(s=="hard")
		{num = 25;}
		else if(s=="medium")
		{num = 15;}
		else
		{num=10;}
		return WINDOW_HEIGHT / num;
	}

	@Override
	public void showContents() {
		drawEntities();
		program.add(lives);
		program.add(score);
		drawGridLines(s);
		drawWinningSpace();
		drawLives();
	}

	@Override
	public void hideContents() {
		program.remove(lives);
		program.remove(score);
		removeGridLines();
		program.remove(winSpace);
	}

	@Override
	public void keyPressed(KeyEvent e) {	
		x = character.getLocation().getX();
		y = character.getLocation().getY();
		row = (int)(y / spaceWidth());
		col = (int)(x / spaceHeight());
		Space s;
		
		if (e.getKeyChar() == 'w') {
			s = new Space(row-1, col);
			for (Entity temp:walls) {
				if (temp.getSpace() == s) {
					return;
				}
			}
			character.setLocation(row * spaceWidth(), (col+1) * spaceHeight());
			
			level.collision(s);
			if ((row-1) >= 0) {
				if (s != level.getCharSpace()) {
					character.setLocation(row * spaceWidth(), col * spaceHeight());
					return;
				}
				character.setLocation((row-1) * spaceWidth(), col * spaceHeight());
			}
		}
		if (e.getKeyChar() == 'a') {
			s = new Space(row, col-1);
			for (Entity temp:walls) {
				if (temp.getSpace() == s) {
					return;
				}
			}
			character.setLocation(row * spaceWidth(), (col+1) * spaceHeight());
			
			level.collision(s);
			if ((col-1) >= 0) {
				if (s != level.getCharSpace()) {
					character.setLocation(row * spaceWidth(), col * spaceHeight());
					return;
				}
				character.setLocation(row * spaceWidth(), (col-1) * spaceHeight());
			}
		}
		if (e.getKeyChar() == 's') {
			s = new Space(row+1, col);
			for (Entity temp:walls) {
				if (temp.getSpace() == s) {
					return;
				}
			}
			character.setLocation(row * spaceWidth(), (col+1) * spaceHeight());
			
			level.collision(s);
			if ((row+1) <= (WINDOW_HEIGHT / spaceHeight())) {
				if (s != level.getCharSpace()) {
					character.setLocation(row * spaceWidth(), col * spaceHeight());
					return;
				}
				character.setLocation((row+1) * spaceWidth(), col * spaceHeight());
			}
		}
		if (e.getKeyChar() == 'd') {
			s = new Space(row, col+1);
			for (Entity temp:walls) {
				if (temp.getSpace() == s) {
					return;
				}
			}
			character.setLocation(row * spaceWidth(), (col+1) * spaceHeight());
			
			level.collision(s);
			if ((col+1) <= (WINDOW_WIDTH / spaceWidth())) {
				if (s != level.getCharSpace()) {
					character.setLocation(row * spaceWidth(), col * spaceHeight());
					return;
				}
			}
		}
		if (level.getLives() == 0) {
			program.switchToLevelSelect(null);
		}
		score = new GLabel("SCORE: " + level.getScore(), 1250, 25);
		program.add(score);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
