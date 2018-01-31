package after.items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import after.conf.GameConfiguration;
import after.utils.Point;

public class Sling extends AbstractItem {

	private String backImgPath;
	private String frontImgPath;
	
	public Sling() {
		super();
	}


	/**
	 * @return the backImgPath
	 */
	public String getBackImgPath() {
		return backImgPath;
	}

	/**
	 * @param backImgPath the backImgPath to set
	 */
	public void setBackImgPath(String backImgPath) {
		this.backImgPath = backImgPath;
	}

	/**
	 * @return the frontImgPath
	 */
	public String getFrontImgPath() {
		return frontImgPath;
	}

	/**
	 * @param frontImgPath the frontImgPath to set
	 */
	public void setFrontImgPath(String frontImgPath) {
		this.frontImgPath = frontImgPath;
	}
	

	public void drawBackSlingshot(Graphics g) {
		imgBuffer = backImgPath;
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(imgBuffer), 
				100, GameConfiguration.BOT - height + 4, 
				null);
	}
	
	public void drawFrontSlingshot(Graphics g) {
		imgBuffer = frontImgPath; 
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(imgBuffer), 
				71, GameConfiguration.BOT - height - 2, 
				null);
	}


	public void drawRubber(Graphics g, Point birdPos, Point mousePos) {
		g.setColor(Color.BLUE);
		g.drawLine((int) birdPos.getPx(), (int) birdPos.getPy(),
				(int) mousePos.getPx(), (int) mousePos.getPy()); // montre l'angle et la vitesse
	}

	

}
