import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class CharacterSelectPane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
	private GLabel orangLabel;
	private GLabel gorillaLabel;
	private GLabel monkeyLabel;
	private GButton charSelect;
	private GImage charOrang;
	private GImage charGorilla;
	private GImage charMonkey;
	private GParagraph para;
	private GButton rect;
	private static final String LABEL_FONT = "Arial-Bold-32";

	public CharacterSelectPane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Character Select", app.getWidth() / 2.3, app.getHeight() / 10);
		para.setFont("Arial-26");
		
		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		//charMonkey = new GImage("Chimp_Cartoon.jpg", 250, 200);
		//charGorilla = new GImage("Gorilla_Cartoon.jpg", 650, 200);
		//charOrang = new GImage ("Orangutan_Cartoon.jpg", 950, 200);
		
		monkeyLabel = new GLabel("Monkey", 375, 525);
		gorillaLabel = new GLabel("Gorilla", 700, 525);
		orangLabel =  new GLabel("Orangutan", 1025, 525);
		
		monkeyLabel.setFont(LABEL_FONT);
		gorillaLabel.setFont(LABEL_FONT);
		orangLabel.setFont(LABEL_FONT);
	}

	@Override
	public void showContents() {
		program.add(para);
		program.add(rect);
		//program.add(charOrang);
		//program.add(charGorilla);
		//program.add(charMonkey);
		program.add(gorillaLabel);
		program.add(monkeyLabel);
		program.add(orangLabel);
	}

	@Override
	public void hideContents() {
		program.remove(para);
		program.remove(rect);
		program.remove(gorillaLabel);
		program.remove(monkeyLabel);
		program.remove(orangLabel);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToMenu();
		}
		/*
		if (obj == orangLabel) {
			charSelect = new GButton("SELECTED", 100, 100, 100, 100);
		}
		if (obj == gorillaLabel) {
			charSelect = new GButton("SELECTED", 100, 100, 100, 100);
		}
		if (obj == monkeyLabel) {
			charSelect = new GButton("SELECTED", 100, 100, 100, 100);
		}
		program.add(charSelect);*/
	}
}
