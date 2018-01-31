package after.items;

import java.awt.Graphics;
import java.awt.Toolkit;

import after.utils.Point;

public abstract class AbstractItem {

	protected Point position;
	protected String imgBuffer;
	protected int height;
	protected int width;

	// --- GETTERS & SETTERS

	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	public double getPositionX() {
		return position.getPx();
	}

	public double getPositionY() {
		return position.getPy();
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
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
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the imgBuffer
	 */
	public String getImgBuffer() {
		return imgBuffer;
	}

	/**
	 * @param imgBuffer
	 *            the imgBuffer to set
	 */
	public void setImgBuffer(String imgBuffer) {
		this.imgBuffer = imgBuffer;
	}

	// --- GRAPHIC METHOD ---
	public void paint(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage(this.getImgBuffer()), (int) this.getPositionX() - width / 2,
				(int) this.getPositionY() - height / 2, height, width, null);
	}

}
