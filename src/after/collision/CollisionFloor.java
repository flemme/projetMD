package after.collision;

import after.conf.GameConfiguration;
import after.items.Bird;
import after.pattern.ICollisionStrategy;

public class CollisionFloor implements ICollisionStrategy {

	@Override
	public void executeCollisionAction(Bird bird) {
		bird.setBirdVelocityY(bird.getBirdVelocityY() * GameConfiguration.SLOWDOWN);
	}

}
