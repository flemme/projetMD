package after.items;

import after.conf.GameConfiguration;
import after.utils.Point;

public class Bird extends AbstractItem {
	private Point birdVelocity; // informations relatives à l'oiseau

	private String imgPathStill;
	private String imgPathFlying;
	private String imgPathFast;

	private boolean stopping;
	private double gravity;

	public Bird() {
		super();
		stopping = false;
	}

	// *********** GETTERS & SETTERS ****************

	/**
	 * @return the birdVelocity
	 */
	public Point getBirdVelocity() {
		return birdVelocity;
	}

	/**
	 * @param birdVelocity
	 *            the birdVelocity to set
	 */
	public void setBirdVelocity(Point birdVelocity) {
		this.birdVelocity = birdVelocity;
	}

	/**
	 * @return the hasStopped
	 */
	public boolean isStopping() {
		return stopping;
	}

	/**
	 * @param hasStopped
	 *            the hasStopped to set
	 */
	public void setStopping(boolean stopped) {
		this.stopping = stopped;
	}

	public void setBirdVelocityX(double px) {
		birdVelocity.setPx(px);
	}

	public void setBirdVelocityY(double py) {
		birdVelocity.setPy(py);
	}

	public double getBirdVelocityX() {
		return this.getBirdVelocity().getPx();
	}

	public double getBirdVelocityY() {
		return this.getBirdVelocity().getPy();
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
	 * @return the heigth
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param heigth
	 *            the heigth to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	// ****** GRAVITY RELATED METHOD *******

	public void applyGravityX(double gravity) {
		setBirdVelocityX(getBirdVelocityX() + gravity);
	}

	public void applyGravityY(double gravity) {
		setBirdVelocityY(getBirdVelocityY() + gravity);
	}

	// ****** BOOLEANS METHODS ***************

	public boolean hitSomething(Point pos, double width) {
		return Point.distance(this.getPositionX(), this.getPositionY(), pos.getPx(), pos.getPy()) < (this.width + width)
				/ 2;
	}

	public boolean nearGravPoint(Point pos, double width) {
		return Point.distance(this.getPositionX(), this.getPositionY(), pos.getPx(),
				pos.getPy()) < ((this.width + width) / 2) + 125;
	}

	public boolean hitFloor() {
		return this.getPositionY() >= GameConfiguration.BOT - 5
				&& this.getBirdVelocity().getPy() > GameConfiguration.SPEED_MIN;
	}

	public boolean hitWall() {
		return (this.getPositionX() >= GameConfiguration.RIGHT && this.getBirdVelocityX() > GameConfiguration.SPEED_MIN)
				|| (this.getPositionX() <= GameConfiguration.LEFT
						&& this.getBirdVelocityX() < -GameConfiguration.SPEED_MIN);
	}

	public boolean bounceTooSlow() {
		return Double.compare(Math.abs(this.getBirdVelocityY()), GameConfiguration.SPEED_MIN) < 0
				|| Double.compare(Math.abs(this.getBirdVelocityX()), GameConfiguration.SPEED_MIN) < 0;
	}

	public boolean birdFast() {
		return Math.abs(this.getBirdVelocityX()) > 10
				|| Math.abs(this.getBirdVelocityY()) > 10;
	}
	/**
	 * @return the gravity
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * @param gravity
	 *            the gravity to set
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	/**
	 * @return the imgPathStill
	 */
	public String getImgPathStill() {
		return imgPathStill;
	}

	/**
	 * @param imgPathStill
	 *            the imgPathStill to set
	 */
	public void setImgPathStill(String imgPathStill) {
		this.imgPathStill = imgPathStill;
	}

	/**
	 * @return the imgPathFlying
	 */
	public String getImgPathFlying() {
		return imgPathFlying;
	}

	/**
	 * @param imgPathFlying
	 *            the imgPathFlying to set
	 */
	public void setImgPathFlying(String imgPathFlying) {
		this.imgPathFlying = imgPathFlying;
	}

	/**
	 * @return the imgPathFast
	 */
	public String getImgPathFast() {
		return imgPathFast;
	}

	/**
	 * @param imgPathFast
	 *            the imgPathFast to set
	 */
	public void setImgPathFast(String imgPathFast) {
		this.imgPathFast = imgPathFast;
	}
}
