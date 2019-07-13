package game;

import launcher.LauncherController;


/**
 * Diese Klasse ist zustaendig zu regeln, welcher Spieler mit dem Spiel anfangen darf. 
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class Beginning {
	
	/**
	 * Methode, um den startenden Spieler zu ermitteln.
	 * Jeder Spieler hat einen Zug und derjenige mit der hoechsten Zahl darf beginnen.
	 * @param durchlauf Anzahl, wie oft in dieser Runden gewuerfelt werden darf.
	 * @param max Hoechste gewuerfelte Zahl 
	 */
	public static void ersterZug() {
		
		int durchlauf = LauncherController.numberOfPlayers;
		
		/*
		 * Array in denen die Werte jedes Würfelzugs gespeichert werden
		 */
		int[] test = new int[6];
		
		/*
		 * Anzahl der Durchläufe würfeln
		 */
		for (int i = 0; i <= durchlauf; i++) {
			
			RollTheDice rtd = new RollTheDice();
			int x = rtd.rollTheDice();		
			
			test[i] = x;
			
		}
        
		/*
		 * Hoechste gewuerfelte Zahl ermitteln
		 */
        int max = test[0]; 
       
        for (int i = 1; i < test.length; i++) 
            if (test[i] > max) 
                max = test[i]; 
              
        /*
         * Ueberpruefen an welcher Position die hoechste Zahl war.
         * Diese wird dem Spieler zugewiesen.
         */
        if (test[0] == max) {
			/*
			 * Spieler 1 fängt an
			 */
		}
        
        else if (test[1] == max) {
			/*
			 * Spieler 2 fängt an
			 */
		}
        
        else if (test[2] == max) {
			/*
			 * Spieler 3 fängt an
			 */
		}
        
        else if (test[3] == max) {
        	/*
        	 * Spieler 4 fängt an
        	 */
        }
        
        else if (test[4] == max) {
        	/*
        	 * Spieler 5 fängt an
        	 */
        }
        
        else if (test[5] == max) {
        	/*
        	 * Spieler 6 fängt an
        	 */
        
		}
	}
}
		
			
		
	

