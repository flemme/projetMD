package after.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import after.conf.GameConfiguration;
import after.game.AngryBirds;
import after.items.*;
import after.utils.Point;

public class Stage {

	private List<Bird> listBirds;
	private List<Pig> listPigs;
	private GravityPoint gravPoint;
	private Sling sling;

	private String groundImgPath;
	private String backgroundImgPath;
	
	private Point messagePos;
	private Point scorePos;

	private double gravity;
	private int score; 
	private String message;
	
	public Stage() {
		this.listBirds = new ArrayList<Bird>();
		this.listPigs = new ArrayList<Pig>();
	}
	
	// ---- GETTERS & SETTERS ----
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
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the slingshot
	 */
	public Sling getSling() {
		return sling;
	}

	/**
	 * @param slingshot
	 *            the slingshot to set
	 */
	public void setSling(Sling sling) {
		this.sling = sling;
	}

	/**
	 * @return the messagePos
	 */
	public Point getMessagePos() {
		return messagePos;
	}

	/**
	 * @param messagePos
	 *            the messagePos to set
	 */
	public void setMessagePos(Point messagePos) {
		this.messagePos = messagePos;
	}

	/**
	 * @return the scorePos
	 */
	public Point getScorePos() {
		return scorePos;
	}

	/**
	 * @param scorePos
	 *            the scorePos to set
	 */
	public void setScorePos(Point scorePos) {
		this.scorePos = scorePos;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the groundImgPath
	 */
	public String getGroundImgPath() {
		return groundImgPath;
	}

	/**
	 * @param groundImgPath
	 *            the groundImgPath to set
	 */
	public void setGroundImgPath(String groundImgPath) {
		this.groundImgPath = groundImgPath;
	}

	/**
	 * @return the backgroundImgPath
	 */
	public String getBackgroundImgPath() {
		return backgroundImgPath;
	}

	/**
	 * @param backgroundImgPath
	 *            the backgroundImgPath to set
	 */
	public void setBackgroundImgPath(String backgroundImgPath) {
		this.backgroundImgPath = backgroundImgPath;
	}

	/**
	 * @return the listBirds
	 */
	public List<Bird> getListBirds() {
		return listBirds;
	}

	/**
	 * @param listBirds
	 *            the listBirds to set
	 */
	public void setListBirds(List<Bird> listBirds) {
		this.listBirds = listBirds;
	}

	/**
	 * @return the listPigs
	 */
	public List<Pig> getListPigs() {
		return listPigs;
	}

	/**
	 * @param listPigs
	 *            the listPigs to set
	 */
	public void setListPigs(List<Pig> listPigs) {
		this.listPigs = listPigs;
	}

	/**
	 * @return the gravPoint
	 */
	public GravityPoint getGravPoint() {
		return gravPoint;
	}

	/**
	 * @param gravPoint the gravPoint to set
	 */
	public void setGravPoint(GravityPoint gravPoint) {
		this.gravPoint = gravPoint;
	}

	public void addBird(Bird bird) {
		listBirds.add(bird);
	}
	
	public void addPig(Pig pig) {
		listPigs.add(pig);
	}

	// ---- GRAPHIC METHODS ----
	public void paint(Graphics g) {
		drawBackground(g);
		drawGround(g);
		
		gravPoint.paint(g);
		
		drawMessage(g, messagePos);
		drawScore(g, scorePos);
	}

	public void drawBackground(Graphics g) {		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(backgroundImgPath),0, 0, null);
	}
	
	public void drawGround(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 500, 800, 800);
	}

	public void drawMessage(Graphics g, Point messagePos) {
		g.setColor(Color.BLACK);
		g.drawString(message,
				(int) GameConfiguration.messagePos.getPx(),
				(int) GameConfiguration.messagePos.getPy());
	}

	public void drawScore(Graphics g, Point scorePos) {
		g.setColor(Color.BLACK);
		g.drawString("score: " + score,
				(int) GameConfiguration.scorePos.getPx(),
				(int) GameConfiguration.scorePos.getPy());

	}
	
}
