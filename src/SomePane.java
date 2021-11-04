import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 

	private GImage img;
	private GParagraph para;
	private GButton rect;

	public SomePane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Character Select", 300, 50);
		para.setFont("Arial-26");
		
		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		//img = new GImage("robot head.jpg", 0, 0);
		
	}

	@Override
	public void showContents() {
		//program.add(img);
		program.add(para);
		program.add(rect);
	}

	@Override
	public void hideContents() {
		//program.remove(img);
		program.remove(para);
		program.remove(rect);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToMenu();
		}
		
	}
}
