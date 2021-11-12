import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LevelSelectPane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 

	private GImage charOrang;
	private GImage charGorilla;
	private GImage charChimp;
	private GParagraph para;
	private GButton rect;

	public LevelSelectPane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Level Select", app.getWidth() / 2.3, app.getHeight() / 10);
		para.setFont("Arial-26");
		
		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		}

	@Override
	public void showContents() {
		program.add(para);
		program.add(rect);
	}

	@Override
	public void hideContents() {
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
