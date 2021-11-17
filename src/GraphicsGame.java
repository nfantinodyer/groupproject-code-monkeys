import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;

public class GraphicsGame extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program;
	public static final int WINDOW_WIDTH = 1600;
	public static final int WINDOW_HEIGHT = 800;
	private Level level = new Level();
	
	private GLabel lives = new GLabel("LIVES:", 10, 25);
	private GLabel score = new GLabel("SCORE:", 1250, 25);
	
	private ArrayList<GLine> gridLines = new ArrayList<GLine>();

	public GraphicsGame(MainApplication app) {
		this.program = app;
		
		lives.setFont("Arial-26");
		score.setFont("Arial-26");
	}
	
	public void setupEasy() {
		level.createLevel("small");
	}
	
	public void setupMedium() {
		level.createLevel("medium");
	}
	
	public void setupHard() {
		level.createLevel("large");
	}
	
	private void setupLevel() {
		drawGridLines();
	}
	
	private void drawGridLines() {
		GLine gridLine;
		
		for (int i = 1; i < level.getNumCols(); ++i) {
			gridLine = new GLine(spaceWidth() * i, 0, spaceWidth() * i, WINDOW_WIDTH);
			gridLines.add(gridLine);
		}
		for (int i = 1; i < level.getNumRows(); ++i) {
			gridLine = new GLine(0, spaceHeight() * i, WINDOW_HEIGHT, spaceHeight() * i);
			gridLines.add(gridLine);
		}
	}
	
	private double spaceWidth() {
		return WINDOW_WIDTH / level.getNumCols();
	}
	
	private double spaceHeight() {
		return WINDOW_HEIGHT / level.getNumRows();
	}

	@Override
	public void showContents() {
		program.add(lives);
		program.add(score);
	}

	@Override
	public void hideContents() {
		program.remove(lives);
		program.remove(score);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
