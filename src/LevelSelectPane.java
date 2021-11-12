import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class LevelSelectPane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
	
	private GParagraph para;
	private GButton rect;
	private GLabel easyLabel = new GLabel("Easy", 225, 200);
	private GLabel mediumLabel = new GLabel("Medium", 725, 200);
	private GLabel hardLabel = new GLabel("Hard", 1225, 200);
	private GImage easyLevel;
	private GImage mediumLevel;
	private GImage hardLevel;

	public LevelSelectPane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Level Select", 700, 75);
		para.setFont("Arial-26");
		
		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		//easyLevel = new GImage("EasyMap.png", 225, 250);
		//mediumLevel = new GImage("MediumMap.png", 725, 250);
		//hardLevel = new GImage("HardMap.png", 1225, 250);
		
		easyLabel.setFont("Arial-26");
		easyLabel.setColor(Color.YELLOW);
		
		mediumLabel.setFont("Arial-26");
		mediumLabel.setColor(Color.ORANGE);
		
		hardLabel.setFont("Arial-26");
		hardLabel.setColor(Color.RED);
		}

	@Override
	public void showContents() {
		program.add(para);
		program.add(rect);
		program.add(easyLabel);
		program.add(mediumLabel);
		program.add(hardLabel);
		//program.add(easyLevel);
		//program.add(mediumLevel);
		//program.add(hardLevel);
	}

	@Override
	public void hideContents() {
		program.remove(para);
		program.remove(rect);
		program.remove(easyLabel);
		program.remove(mediumLabel);
		program.remove(hardLabel);
		//program.remove(easyLevel);
		//program.remove(mediumLevel);
		//program.remove(hardLevel);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToCharSelect();
		}
		
	}
}
