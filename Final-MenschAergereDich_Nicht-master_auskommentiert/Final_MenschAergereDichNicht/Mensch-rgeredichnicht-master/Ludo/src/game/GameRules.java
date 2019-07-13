package game;

/**
 * Diese Klasse enthaelt die Spielregeln
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class GameRules {
	
	/*
	 * Startfelder der jeweiligen Farben
	 */
	int[][] startboxBlau = new int[4][4];
	int[][] startboxRot = new int[4][4];
	int[][] startboxGrün = new int[4][4];
	int[][] startboxGelb = new int[4][4];
	int[][] startboxSchwarz = new int[4][4];
	int[][] startboxLila = new int[4][4];
	
	/*
	 * Zielfelder der jeweiligen Farben
	 */
	int[][] zielBlau = new int[4][4];
	int[][] zielRot = new int[4][4];
	int[][] zielGrün = new int[4][4];
	int[][] zielGelb = new int[4][4];
	int[][] zielSchwarz = new int[4][4];
	int[][] zielLila = new int[4][4];
	
	/*
	 * Array des jeweiligen Spielfeldes
	 */
	int[][] spielfeldVier = new int[40][40];
	int[][] spielfeldSechs = new int[46][46];
	
	/**
	 * Methode, um zu ziehen.
	 */
	public void goForward() {
		
		RollTheDice rtd = new RollTheDice();
		
		rtd.rollTheDice();
		
		/*
		 * value von rollTheDice + Stelle, an der ein Token steht = valider Zug
		 */
		
	}
	
	/**
	 * Methode, um die Gueltigkeit eines Zuges zu ueberpruefen.
	 */
	public void validMove() {
		
		/*
		 * Pruefen, ob Token in in Grenzen des Arrays ist
		 * Wenn ja, stelle + rollTheDice
		 * Wenn nein, schauen ob restliche Felder + ZielArray reichen => ziehen
		 * => belegt = !validmove und aussetzen oder anderer Token ziehen
		 */
	}

}
