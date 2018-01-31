package after.items;

import java.awt.Graphics;
import java.awt.Toolkit;

public class GravityPoint extends AbstractItem {

	private double gravity;
	
	private int height;
	private int width;
	
	public GravityPoint() {
		super();
	}

	/**
	 * @return the gravity
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * @param gravity the gravity to set
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void applyGravity(Bird bird) {
		if (this.getPositionX() > bird.getPositionX()) {
			bird.applyGravityX(gravity);
		} 
		if (this.getPositionX() < bird.getPositionX()) {
			bird.applyGravityX(-gravity);
		} 
		if (this.getPositionY() > bird.getPositionY()) {
			bird.applyGravityY(gravity);
		} 
		if (this.getPositionY() < bird.getPositionY()) {
			bird.applyGravityY(-gravity);
		} 
	}
	
	// Pour une quelconque raison, ne marche pas quand on appelle la méthode paint de AbstractItem.
	// A méditer.
	@Override
	public void paint(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage(this.getImgBuffer()), (int) this.getPositionX() - width / 2,
				(int) this.getPositionY() - height / 2, height, width, null);
	}
	
}
