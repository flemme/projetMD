package after.collision;

import after.conf.GameConfiguration;
import after.items.Bird;
import after.items.GravityPoint;
import after.pattern.ICollisionStrategy;
import after.utils.Point;

public class CollisionWall implements ICollisionStrategy {

	@Override
	public void executeCollisionAction(Bird bird) {
		bird.setBirdVelocityX(bird.getBirdVelocity().getPx() * GameConfiguration.SLOWDOWN);
	}

		
}
