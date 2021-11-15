import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class LevelSelectPane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program;
	GraphicsGame game = new GraphicsGame(program);
	
	private GParagraph para;
	private GButton rect;
	private GLabel easyLabel = new GLabel("Easy", 232, 200);
	private GLabel mediumLabel = new GLabel("Medium", 725, 200);
	private GLabel hardLabel = new GLabel("Hard", 1232, 200);
	private GImage easyLevel;
	private GImage mediumLevel;
	private GImage hardLevel;
	private GButton levelSelect = new GButton("SELECTED", 0, 0, 0, 0);
	private GButton next = new GButton("NEXT", 1400, 700, 60, 60);

	public LevelSelectPane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Level Select", 700, 75);
		para.setFont("Arial-26");
		
		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		easyLevel = new GImage("EasyMap.png", 130, 250);
		mediumLevel = new GImage("MediumMap.png", 630, 255);
		hardLevel = new GImage("HardMap.png", 1130, 240);
		
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
		program.add(easyLevel);
		program.add(mediumLevel);
		program.add(hardLevel);
	}

	@Override
	public void hideContents() {
		program.remove(para);
		program.remove(rect);
		program.remove(easyLabel);
		program.remove(mediumLabel);
		program.remove(hardLabel);
		program.remove(easyLevel);
		program.remove(mediumLevel);
		program.remove(hardLevel);
		program.remove(levelSelect);
		program.remove(next);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		
		if (levelSelect.isVisible()) {
			program.remove(levelSelect);
			program.remove(next);
		}
		if (obj == easyLevel) {
			levelSelect = new GButton("SELECTED", 230, 575, 100, 50);
		}
		if (obj == mediumLevel) {
			levelSelect = new GButton("SELECTED", 730, 575, 100, 50);
		}
		if (obj == hardLevel) {
			levelSelect = new GButton("SELECTED", 1230, 575, 100, 50);
		}
		
		levelSelect.setFillColor(Color.RED);
		next.setFillColor(Color.RED);
		program.add(levelSelect);
		program.add(next);
		
		if (levelSelect.isVisible()) {
			program.add(next);
		}
		if (obj == next) {
			if (levelSelect.getX() == 230) {
				game.setupEasy();
			}
			else if (levelSelect.getX() == 730) {
				game.setupMedium();
			}
			else {
				game.setupHard();
			}
			program.switchToGame();
		}
		if (obj == rect) {
			program.switchToCharSelect();
		}
	}
}
