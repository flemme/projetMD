package after.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import after.items.*;
import after.background.Stage;
import after.collision.*;
import after.conf.GameConfiguration;
import after.items.Bird;
import after.items.GravityPoint;
import after.items.Pig;
import after.pattern.ICollisionStrategy;
import after.pattern.StageBuilder;
import after.utils.Point;

public class AngryBirds extends Panel implements Runnable, MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1612609160549826721L;

	private StageBuilder stageBuilder;
	
	private List<String> listStages;
	private Stage currentStage;
	private int indexStage;
	
	private List<Bird> listBirds;
	private List<Pig> listPigs;
	private GravityPoint gravPoint;

	private Bird currentBird;
	private Pig currentPig;
	private int indexBird;

	private Sling slingshot;
	private ICollisionStrategy birdAction;

	private int score = 0;

	private Point mousePos; // position de la souris lors de la sélection
	private boolean gameOver; // vrai lorsque le joueur a touché un bord ou le cochon
	private boolean gameWon;
	private boolean selecting; // vrai lorsque le joueur sélectionne l'angle et la vitesse
	
	private Image buffer; // image pour le rendu hors écran

	// ------ CONSTRUCTEUR -----------
	
	public AngryBirds() {
		addMouseListener(this);
		addMouseMotionListener(this);

		stageBuilder = new StageBuilder();
		listStages = new ArrayList<String>();
		indexStage = 0;

		init();
		new Thread(this).start();
	}
	
	

	// ----- Controller --------

	/**
	 * @return the gameWon
	 */
	public boolean isGameWon() {
		return gameWon;
	}


	/**
	 * @param gameWon the gameWon to set
	 */
	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}


	void init() {
		gameOver = false;
		selecting = true;
		mousePos = new Point();
		indexBird = 0;
		
		loadStage();
		initItems();
	}
	
	public void initItems() {
		listBirds = currentStage.getListBirds();
		listPigs = currentStage.getListPigs();
		slingshot = currentStage.getSling();
		gravPoint = currentStage.getGravPoint();
		
		currentBird = listBirds.get(indexBird);
		currentBird.setImgBuffer(currentBird.getImgPathStill());
		currentBird.setGravity(currentStage.getGravity());
		
		currentStage.setMessage(GameConfiguration.selectMessage);
	}
	
	public void initStages() {
		listStages.add("FIRST");
		listStages.add("SECOND");
	}
	
	public void loadStage() {
		if (indexStage >= listStages.size()) {
			indexStage = 0;
			initStages();
			currentStage = stageBuilder.createStage(listStages.get(0), score);
		}
		else {
			currentStage = stageBuilder.createStage(listStages.get(indexStage), score);
		}
	}

	// boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et
	// teste les conditions de victoire
	public void run() {
		while (true) {
			// un pas de simulation toutes les 10ms
			try {
				Thread.currentThread().sleep(9);
			} catch (InterruptedException e) {
			}

			if (!gameOver && !selecting) {
				
				if (currentBird.birdFast()) {
					currentBird.setImgBuffer(currentBird.getImgPathFast());
				} 
				else {
					currentBird.setImgBuffer(currentBird.getImgPathFlying());
				}
				
				currentBird.setGravity(currentStage.getGravity());
				
				birdAction = new CollisionMove();
				birdAction.executeCollisionAction(currentBird);
				removePig();

				if (currentBird.isStopping()) {
					updateGame();
				}

				else if (currentBird.bounceTooSlow() 
						&& currentBird.getPositionY() >= GameConfiguration.BOT -5) 
				{
					birdAction = new CollisionStopping();
					birdAction.executeCollisionAction(currentBird);

				} else if (currentBird.nearGravPoint(gravPoint.getPosition(), gravPoint.getWidth())) {
					birdAction = new CollisionGravPoint(gravPoint);
					birdAction.executeCollisionAction(currentBird);

				} else if (currentBird.hitFloor()) {
					birdAction = new CollisionFloor();
					birdAction.executeCollisionAction(currentBird);

				} else if (currentBird.hitWall()) {
					birdAction = new CollisionWall();
					birdAction.executeCollisionAction(currentBird);
				}
				// redessine
				repaint();
			}
		}
	}
	

	public void removePig() {

		listPigs.removeIf(pig -> {
			boolean condition = currentBird.hitSomething(pig.getPosition(), pig.getWidth());
			if (condition) {
				birdAction = new CollisionPig();
				birdAction.executeCollisionAction(currentBird);
				score++;
				currentStage.setScore(score);
			}
			return condition;
		});
		updateGame();

	}

	public void updateGame() {

		if (listPigs.isEmpty()) {
			gameWon = true;
			stop();
			currentStage.setMessage(GameConfiguration.winningMessage);
		} else {
			if (currentBird.isStopping() 
					&& currentBird.getPosition().getPy() >= GameConfiguration.BOT-5) {
				if (indexBird >= listBirds.size() - 1) {
					gameWon = false;
					stop();
					currentStage.setMessage(GameConfiguration.losingMessage);
				} else {
					indexBird++;
					currentBird = listBirds.get(indexBird);
					currentBird.setPosition(new Point(100, 328));
					selecting = true;
					currentBird.setImgBuffer(currentBird.getImgPathStill());
					currentStage.setMessage(GameConfiguration.selectMessage);
				}
			}
		}
	}

	// fin de partie
	void stop() {
		currentBird.setBirdVelocity(new Point());

		gameOver = true;
	}

	// -------- Graphics -----------------

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	// dessine le contenu de l'écran dans un buffer puis copie le buffer à l'écran
	public void paint(Graphics g2) {
		if (buffer == null)
			buffer = createImage(800, 600);
		Graphics2D g = (Graphics2D) buffer.getGraphics();

		currentStage.paint(g);
		currentStage.getGravPoint().paint(g);

		if (selecting) {
			slingshot.drawRubber(g, currentBird.getPosition(), mousePos);
		}
		
		slingshot.drawBackSlingshot(g);
		currentBird.paint(g);
		slingshot.drawFrontSlingshot(g);

		for (int i = 0; i < listPigs.size(); i++) {
			currentPig = listPigs.get(i);
			currentPig.setImgBuffer(currentPig.getImgPath());
			currentPig.paint(g);
		}

		// affichage à l'écran sans scintillement
		g2.drawImage(buffer, 0, 0, null);
	}

	// évite les scintillements
	public void update(Graphics g) {
		paint(g);
	}

	// -------- EVENTS --------------------
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (gameOver) {
			if (gameWon) {
				indexStage++;
			}
			
			init();
		} else if (selecting) {

			currentBird.setBirdVelocity(new Point((currentBird.getPositionX() - mousePos.getPx()) / 20.0,
					(currentBird.getPositionY() - mousePos.getPy()) / 20.0));

			currentStage.setMessage(GameConfiguration.flyingMessage);
			currentBird.setImgBuffer(currentBird.getImgPathFlying());
			selecting = false;
		}
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		mousePos.setPx(e.getX());
		mousePos.setPy(e.getY());

		repaint();
	}

}