package after.pattern;

import after.background.Stage;
import after.items.*;
import after.utils.Point;

public class StageBuilder {

	private ItemFactory iFactory;

	public StageBuilder() {
		iFactory = new ItemFactory();
	}
	
	public Stage createStage(String stageName, int score) {
		
		Stage stage;
		
		if (stageName.equalsIgnoreCase("FIRST")) {
			stage = createFirstLevel();
			stage.setScore(score);
			return stage;
		}
		else if (stageName.equalsIgnoreCase("SECOND")) {
			stage = createSecondLevel();
			stage.setScore(score);
			return stage;
		}
		
		
		return null;
	}

	public Stage createFirstLevel() {
		Stage first = new Stage();

		// Setting values
		first.setBackgroundImgPath("src/resources/background.jpg");
		first.setGravity(0.2);

		GravityPoint gravPoint = (GravityPoint) iFactory.getItem("GRAVPOINT");
		gravPoint.setPosition(new Point(500, 200));

		Sling sling = (Sling) iFactory.getItem("SLING");

		Bird bird = (Bird) iFactory.getItem("BIRD");

		bird.setPosition(new Point(100, 328));
		bird.setBirdVelocity(new Point());
		first.addBird(bird);

		bird.setPosition(new Point(100, 328));
		bird.setBirdVelocity(new Point());
		first.addBird(bird);

		bird.setPosition(new Point(100, 328));
		bird.setBirdVelocity(new Point());
		first.addBird(bird);

		Pig pig1 = (Pig) iFactory.getItem("PIG");
		Pig pig2 = (Pig) iFactory.getItem("PIG");
		Pig pig3 = (Pig) iFactory.getItem("PIG");

		pig1.setPosition(new Point(300, 480));
		first.addPig(pig1);

		pig2.setPosition(new Point(400, 480));
		first.addPig(pig2);

		pig3.setPosition(new Point(500, 480));
		first.addPig(pig3);

		// Setting items
		first.setGravPoint(gravPoint);
		first.setSling(sling);

		return first;
	}

	public Stage createSecondLevel() {
		Stage second = new Stage();

		second.setBackgroundImgPath("src/resources/green_background.jpg");
		second.setGravity(0.1);

		GravityPoint gravPoint = (GravityPoint) iFactory.getItem("GRAVPOINT");
		gravPoint.setPosition(new Point(300, 250));
		second.setGravPoint(gravPoint);
		
		Sling sling = (Sling) iFactory.getItem("SLING");
		second.setSling(sling);

		Bird bird = (Bird) iFactory.getItem("BIRD");

		bird.setPosition(new Point(100, 328));
		bird.setBirdVelocity(new Point());
		second.addBird(bird);

		bird.setPosition(new Point(100, 328));
		bird.setBirdVelocity(new Point());
		second.addBird(bird);
		
		bird.setPosition(new Point(100, 328));
		bird.setBirdVelocity(new Point());
		second.addBird(bird);


		Pig pig1 = (Pig) iFactory.getItem("PIG");
		Pig pig2 = (Pig) iFactory.getItem("PIG");
		Pig pig3 = (Pig) iFactory.getItem("PIG");
		Pig pig4 = (Pig) iFactory.getItem("PIG");
		Pig pig5 = (Pig) iFactory.getItem("PIG");
		Pig pig6 = (Pig) iFactory.getItem("PIG");

		pig1.setPosition(new Point(300, 480));
		second.addPig(pig1);

		pig2.setPosition(new Point(400, 480));
		second.addPig(pig2);

		pig3.setPosition(new Point(500, 480));
		second.addPig(pig3);

		pig4.setPosition(new Point(300, 480 - pig3.getHeight()));
		second.addPig(pig4);

		pig5.setPosition(new Point(400, 480 - pig3.getHeight()));
		second.addPig(pig5);

		pig6.setPosition(new Point(500, 480 - pig3.getHeight()));
		second.addPig(pig6);

		return second;
	}

	/**
	 * @return the iFactory
	 */
	public ItemFactory getiFactory() {
		return iFactory;
	}

	/**
	 * @param iFactory
	 *            the iFactory to set
	 */
	public void setiFactory(ItemFactory iFactory) {
		this.iFactory = iFactory;
	}

}
