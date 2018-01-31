package after.collision;

import after.items.Bird;
import after.pattern.ICollisionStrategy;
import after.utils.Point;

public class CollisionMove implements ICollisionStrategy {

	@Override
	public void executeCollisionAction(Bird bird) {
		bird.setPosition(new Point(
    			bird.getPositionX() + bird.getBirdVelocityX(), 
    			bird.getPositionY() + bird.getBirdVelocityY()
    		)
    	);
    	
		bird.applyGravityY(bird.getGravity());
	}
		
}
