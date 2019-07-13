package game;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * Diese Klasse definiert die logische Erstellung des Spielfeldes für bis zu 4 Spieler.
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class FourPlayerField {

  public int[] feld = new int[40];
  public HashMap<Integer, Image> hm = new HashMap();
  
  /**
   * Konstruktor des logischen Spielfeldes für bis zu 4 Spieler
   */
  public FourPlayerField() {
	
    feld = fillArray(feld);
    initializeMap();
    
  }
  
  /**
   * Methode, um die HashMap zu initialisieren.
   */
  public void initializeMap() {
	  
    for (int i = 0; i < feld.length; i++) {
    	
    	hm.put(Integer.valueOf(i), null);
    	
    }
  }
  /**
   * Methode, um Array zu befuellen
   * @param x Übergabewert als Array
   * @return Rückgabewert als gefuellter Array
   */
  private int[] fillArray(int[] x) {
	  
    for (int i = 0; i < x.length; i++) {
    	
      x[i] = i;
      
    }
    
    return x;
  }
}
