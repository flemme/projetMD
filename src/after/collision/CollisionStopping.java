package after.collision;

import after.items.Bird;
import after.pattern.ICollisionStrategy;
import after.utils.Point;

public class CollisionStopping implements ICollisionStrategy {

	@Override
	public void executeCollisionAction(Bird bird) {
		bird.setStopping(true);
    	bird.setBirdVelocity(new Point());
	}

}
