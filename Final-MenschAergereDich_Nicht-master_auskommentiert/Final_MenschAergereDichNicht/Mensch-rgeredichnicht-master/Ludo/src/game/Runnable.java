package game;

import java.io.PrintStream;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Diese Klasse dient dem Laufen auf dem Spielfeld.
 * @author Lukas, Kim, Isabelle, Jonas
 *
 */
public class Runnable extends Application {

  RollTheDice rtd = new RollTheDice();
  Spieler spieler = new Spieler();
  
  /**
   * Konstruktor der Klasse Runnable
   */
  public Runnable() {
	  
  }
  
  public static void main(String[] args) {
	
	/*
	 * Instanzieren eines neuen Runnable-Objektes
	 */
    Runnable r = new Runnable();
    
    /*
     * Augenzahl als Zahl speichern
     * Position des Kegels in der Konsole ausgeben
     */
    int zahl = r.rtd.rollTheDice();
    System.out.println(r.getKegelPositionSpieler(1, 1));
    
    /*
     * Anhand der Wuerfelzahl laufen.
     * Wuerfelzahl und neue Position des Kegels in der Konsole ausgeben.
     */
    r.move2(1, 1, zahl);
    System.out.println("Die Wuerfelzahl war " + zahl + "Die neue Position ist " + r.getKegelPositionSpieler(1, 1));
    
    /*
     * Neue Zahl wuerfeln und speichern
     * Anhand der Wuerfelzahl laufen
     * Wuerfelzahl und neue Position des Kegels in der Konsole ausgeben.
     */
    zahl = r.rtd.rollTheDice();
    r.move2(1, 1, zahl);
    System.out.println("Die Wuerfelzahl war " + zahl + "Die neue Position ist " + r.getKegelPositionSpieler(1, 1));
  }

  /**
   * Methode, um Position des Kegels zu erlangen.
   * @param spieler Spieler, der dran ist.
   * @param kegel Jeweiliger Kegel des Spielers
   * @return Position des Kegels
   */
  public int getKegelPositionSpieler(int spieler, int kegel) { 
	
	return this.spieler.getSpieler1bis6(spieler).getPosition(kegel); 
  }
  
  /**
   * Methode, um die neue Position des Kegels zu bestimmen
   * @param spieler Spieler, der dran ist.
   * @param kegel Jeweiliger Kegel des Spielers
   * @param wuerfelzahl Gewuerfelte Augenzahl
   */
  public void move2(int spieler, int kegel, int wuerfelzahl) {
	  
    int neueposition = getKegelPositionSpieler(spieler, kegel) + wuerfelzahl;
    
    this.spieler.getSpieler1bis6(spieler).setPosition(kegel, neueposition);
  }
  
  /**
   * Methode zum Starten
   */
  public void start(Stage arg0)
  
    throws Exception {}
}
