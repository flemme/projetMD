package after.conf;

import after.utils.Point;

public class GameConfiguration {

	// ---- GAME SCREEN PARAMETERS ----
	public static int TOP = 0;
	public static int BOT = 500;
	public static int LEFT = 0;
	public static int RIGHT = 800;
	
	// ---- COMPONENTS POSITION ----
	public static Point messagePos = new Point(300, 100);
	public static Point scorePos = new Point(20, 20);
	
	// ---- PHYSICS PARAMETERS -----
	public static double SPEED_MIN = 0.2;
	public static double SLOWDOWN  = -0.65;
	
	// ---- MESSAGES ----
	public static String selectMessage = "#balanceTonPiaf";
	public static String flyingMessage = "i WaNnA gEt HiGhHhHhH sOo0oO hIgHhHhH LULZ";
	public static String winningMessage = "BEH BRAVO CHAMPION! ! #balanceTonPorc";
	public static String losingMessage = "geeeeeeeet dunked ON! !";
}
