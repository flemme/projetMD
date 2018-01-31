package after.pattern;

import after.conf.GameConfiguration;
import after.items.AbstractItem;
import after.items.Bird;
import after.items.GravityPoint;
import after.items.Pig;
import after.items.Sling;
import after.utils.Point;

public class ItemFactory {
	
	public AbstractItem getItem(String itemType) {
		if (itemType.equalsIgnoreCase("BIRD")) {
			Bird bird = new Bird();
			
			bird.setBirdVelocity(new Point());
			
			bird.setImgPathFast("src/resources/fast_bird.png");
			bird.setImgPathFlying("src/resources/flying_red_bird.png");
			bird.setImgPathStill("src/resources/bird.png");
			
			bird.setWidth(50);
			bird.setHeight(50);
			
			return bird;
		}
		
		if (itemType.equalsIgnoreCase("PIG")) {
			Pig pig = new Pig();
			
			pig.setImgPath("src/resources/pig.png");
			
			pig.setHeight(50);
			pig.setWidth(50);
			
			return pig;
		}
		
		if (itemType.equalsIgnoreCase("SLING")) {
			Sling sling = new Sling();
			
			sling.setBackImgPath("src/resources/sling_back.png");
			sling.setFrontImgPath("src/resources/sling_front.png");
			
			sling.setPosition(new Point(100, GameConfiguration.BOT));
			sling.setHeight(203);
			
			return sling;
		}
		
		if (itemType.equalsIgnoreCase("GRAVPOINT")) {
			GravityPoint gravPoint = new GravityPoint();
			
			gravPoint.setImgBuffer("src/resources/gp.png");
			gravPoint.setGravity(0.8);
			
			gravPoint.setHeight(50);
			gravPoint.setWidth(50);
			
			return gravPoint;
			
		}
		
		return null;
	}
	
}
