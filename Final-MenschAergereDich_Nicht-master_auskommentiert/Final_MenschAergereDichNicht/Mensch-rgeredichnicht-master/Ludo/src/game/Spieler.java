package game;

import java.io.PrintStream;

/**
 * Diese Klasse stellt die Spieler dar.
 * Den Spielern werden Kegel in jeweiligen Farben zugeteilt.
 * @author Lukas, Kim, Isabelle, Jonas
 *
 */
public class Spieler {
	
  Kegel[] spieler;
  Kegel gelb;
  Kegel gruen;
  Kegel blau;
  Kegel schwarz;
  Kegel lila;
  Kegel rot;
  
  /**
   * Konstruktor der Klasse Spieler
   * Den Farben wird das jeweilige Image zugeteilt.
   */
  public Spieler() {
	  
    spieler = new Kegel[6];
    gelb = new Kegel("/pictures/Yellow.jpg");
    gruen = new Kegel("/pictures/Green.jpg");
    blau = new Kegel("/pictures/Blue.jpg");
    schwarz = new Kegel("/pictures/Black.jpg");
    lila = new Kegel("/pictures/Purple.jpg");
    rot = new Kegel("/pictures/Red.jpg");
    
    setColor();
  }
  



  /**
   * Methode, um den Spielern eine Farbe zuzuordnen.
   */
  public void setColor() {
	  
    spieler[0] = gelb;
    spieler[1] = gruen;
    spieler[2] = blau;
    spieler[3] = schwarz;
    spieler[4] = lila;
    spieler[5] = rot;
  }
  
  /**
   * Methode, um zu pruefen, ob es die Spielerzahl gibt
   * @param i Spielerzahl
   */
  public Kegel getSpieler1bis6(int i) {
	  
    if (i <= spieler.length) {
    	
      return spieler[(i - 1)];
    }
    
    System.out.println("Spieler " + (i - 1) + " existiert nicht.");
    
    return null;
  }
}
