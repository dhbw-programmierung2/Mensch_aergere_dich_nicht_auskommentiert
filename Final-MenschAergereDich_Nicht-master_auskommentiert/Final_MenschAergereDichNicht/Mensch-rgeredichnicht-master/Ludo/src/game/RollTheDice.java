package game;

import java.util.Random;

import javafx.scene.image.Image;

/**
 * Diese Klasse ist fuer das Wuerfeln verantwortlich
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class RollTheDice {

	/*
	 * Variable enthaelt die gewuerfelte Zahl
	 */
	public int cubeNumber;
	
	/**
	 * Methode, um eine Zahl zwischen 1 und 6 zu wuerfeln.
	 * @return Augenzahl als Rückgabewert
	 */
	public int rollTheDice() {
		Random random = new Random();
		int cubeNumber = random.nextInt(6)+1;
		
		return cubeNumber;
	}
}
