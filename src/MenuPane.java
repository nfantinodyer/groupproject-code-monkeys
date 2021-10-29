import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GButton rect;
	private GButton exit;
	private GImage img;
	private final int BUTTON_SIZE = 60;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Play Game", app.getWidth()/2-BUTTON_SIZE*2, app.getHeight()/2+BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
		rect.setFillColor(Color.RED);
		exit = new GButton("Exit Game", app.getWidth()/2-BUTTON_SIZE/2, app.getHeight()/2+BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
		exit.setFillColor(Color.RED);
		
		img = new GImage("codemonjey.png", 250, 150);
	}

	@Override
	public void showContents() {
		program.add(rect);
		program.add(exit);
		program.add(img);
	}

	@Override
	public void hideContents() {
		program.remove(rect);
		program.remove(exit);
		program.remove(img);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToSome();
		}
		if(obj == exit)
		{
			System.exit(0);
		}
	}
}
