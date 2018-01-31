package after.collision;

import after.items.Bird;
import after.items.GravityPoint;
import after.pattern.ICollisionStrategy;

public class CollisionGravPoint implements ICollisionStrategy {

	private GravityPoint gravPoint;

	public CollisionGravPoint(GravityPoint gravPoint) {
		this.gravPoint = gravPoint;
	}


	@Override
	public void executeCollisionAction(Bird bird) {
		gravPoint.applyGravity(bird);
	}
	
}
