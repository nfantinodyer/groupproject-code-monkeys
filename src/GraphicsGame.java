import java.awt.event.KeyEvent;

import acm.graphics.GLabel;

public class GraphicsGame extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
	
	private GLabel lives = new GLabel("LIVES:", 10, 25);
	private GLabel score = new GLabel("SCORE:", 1250, 25);

	public GraphicsGame(MainApplication app) {
		this.program = app;
		
		lives.setFont("Arial-26");
		score.setFont("Arial-26");
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
