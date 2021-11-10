import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
	
	/*private String MONKEY = "Chimp_Cartoon.png";
	private String GORILLA = "Gorilla_Cartoon.png;";
	private String ORANGUTAN = "Orangutan_Cartoon.png"; */
	private GImage charOrang;
	private GImage charGorilla;
	private GImage charMonkey;
	private GParagraph para;
	private GButton rect;

	public SomePane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Character Select", app.getWidth() / 2.3, app.getHeight() / 10);
		para.setFont("Arial-26");
		
		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		charMonkey = new GImage("Chimp_Cartoon.jpg", 250, 200);
		charGorilla = new GImage("Gorilla_Cartoon.jpg", 650, 200);
		charOrang = new GImage ("Orangutan_Cartoon.jpg", 950, 200);
		
		
	}

	@Override
	public void showContents() {
		program.add(para);
		program.add(rect);
		program.add(charOrang);
		program.add(charGorilla);
		program.add(charMonkey);
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
