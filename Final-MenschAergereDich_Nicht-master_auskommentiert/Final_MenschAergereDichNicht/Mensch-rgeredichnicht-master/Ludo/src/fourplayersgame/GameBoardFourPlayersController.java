package fourplayersgame;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.SplitPane;

import java.util.ArrayList;
import java.util.HashMap;

import game.RollTheDice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.TouchEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * Dieser Controller ist fuer das Steuern und initialisieren des  grafischen Spielfeldes für bis zu 4 Spieler zustaendig.
 * Dieser synergiert mit dem GameBoardFourPlayers.fxml
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class GameBoardFourPlayersController {
	
	/*
	 * FXML-Komponenten, die auf dem Spielfeld sichtbar sein werden
	 */
	@FXML
	public SplitPane splitPane;
	public GridPane gridPaneLeft;
	public GridPane gridPaneRigth;
	
	/*
	 * Startfelder der verschiedenen Farben
	 */
	public Circle crcBeginYellow1;
	public Circle crcBeginYellow2;
	public Circle crcBeginYellow3;
	public Circle crcBeginYellow4;
	public Circle crcBeginBlack3;
	public Circle crcBeginBlack1;
	public Circle crcBeginBlack4;
	public Circle crcBeginBlack2;
	public Circle crcBeginRed4;
	public Circle crcBeginRed3;
	public Circle crcBeginRed1;
	public Circle crcBeginRed2;
	public Circle crcBeginGreen1;
	public Circle crcBeginGreen2;
	public Circle crcBeginGreen3;
	public Circle crcBeginGreen4;
	
	/*
	 * Zielfelder der verschiedenen Farben
	 */
	public Circle crcAimBlack1;
	public Circle crcAimBlack2;
	public Circle crcAimBlack3;
	public Circle crcAimBlack4;
	public Circle crcAimYellow1;
	public Circle crcAimYellow2;
	public Circle crcAimYellow3;
	public Circle crcAimYellow4;
	public Circle crcAimGreen1;
	public Circle crcAimGreen2;
	public Circle crcAimGreen3;
	public Circle crcAimGreen4;
	public Circle crcAimRed1;
	public Circle crcAimRed2;
	public Circle crcAimRed3;
	public Circle crcAimRed4;
	
	/*
	 * Lauffelder des Spielfeldes
	 */
	public Circle crcField31;
	public Circle crcField30;
	public Circle crcField29;
	public Circle crcField32;
	public Circle crcField28;
	public Circle crcField33;
	public Circle crcField27;
	public Circle crcField34;
	public Circle crcField26;
	public Circle crcField35;
	public Circle crcField25;
	public Circle crcField36;
	public Circle crcField37;
	public Circle crcField38;
	public Circle crcField39;
	public Circle crcField40;
	public Circle crcField1;
	public Circle crcField2;
	public Circle crcField3;
	public Circle crcField4;
	public Circle crcField5;
	public Circle crcField15;
	public Circle crcField6;
	public Circle crcField14;
	public Circle crcField7;
	public Circle crcField13;
	public Circle crcField8;
	public Circle crcField12;
	public Circle crcField9;
	public Circle crcField10;
	public Circle crcField11;
	public Circle crcField24;
	public Circle crcField23;
	public Circle crcField22;
	public Circle crcField21;
	public Circle crcField20;
	public Circle crcField16;
	public Circle crcField17;
	public Circle crcField18;
	public Circle crcField19;
	
	/*
	 * Button zum Wuerfeln und zum Beenden des Spiels
	 */
	public Button btnRollTheDice;
	public Button btnExitGame;
	
	/*
	 * Wuerfelbild, welches die gewuerfelte Augenzahl anzeigt
	 */
	public ImageView imgDice;
	
	/*
	 * Textfelder fuer Spielernamen
	 */
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	
	/*
	 * Zaehlt mit, wie oft der Wuerfel-Button betaetigt wurde.
	 */
	public int round = 0;
	
	/*
	 * Diese ArrayLists enthalten die Felder, der Kategorien Lauffeldern, Hausfeldern/Beginnfeldern und Zielfeldern.
	 * Der HashMap wird die ID der Circles sowie ein interner Name als Wert uebergeben.
	 */
	public ArrayList<Circle> fieldsGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsGui = new ArrayList<Circle>();
	public HashMap<String, String> tokenID = new HashMap<String, String>();
	
	/**
	 * Methode, die das Spielfeld für bis zu 4 Spieler initialisiert.
	 * 
	 * @param playerName Enthaelt die Namen der Spieler
	 * @param color Enthaelt die Farben der jeweiligen Spieler
	 * @param rival Enthaelt, ob es sich um einen Computer oder einen Mensch handelt
	 * @param numberOfPlayers Enthaelt die Anzahl der Spieler
	 */
	public void initialize(ArrayList<String> playerName, ArrayList<String> color, ArrayList<String> rival, int numberOfPlayers) {
		
		ObservableList<Node> l_circleList = gridPaneLeft.getChildren();
		for (Node l_node : l_circleList) {
			Circle l_circle = (Circle) l_node;
			if (l_circle.getId().startsWith("crcField")) {
				fieldsGui.add(l_circle);
			} else if (l_circle.getId().startsWith("crcAim")) {
				aimFieldsGui.add(l_circle);
			} else {
				beginFieldsGui.add(l_circle);
			}
		}
		
		/*
		 * Zur Ueberpruefung (Testzwecke)
		 */
		System.out.println(fieldsGui);
		System.out.println(playerName);
		System.out.println(color);
		System.out.println(rival);
		System.out.println(numberOfPlayers);
		
		/*
		 * Anzeigen der Spielernamen und ihrer jeweiligen Farbe auf dem Spielfeld
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + color.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + color.get(1));
		if(numberOfPlayers == 4) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
		}		
		
		/*
		 * Pruefen, ob Farbe Gruen ausgewaehlt wurde.
		 * Die Basis wird für Gruen definiert.
		 */
		if(color.contains("Gruen")) {
			
			crcBeginGreen1.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen2.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen3.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcField11.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			
			populateGreen();
			
			tokenID.put("crcBeginGreen1", "green1");
			tokenID.put("crcBeginGreen2", "green2");
			tokenID.put("crcBeginGreen3", "green3");
			tokenID.put("crcField11", "green4");
		}
		
		/*
		 * Pruefen, ob Farbe Gelb ausgewaehlt wurde.
		 * Die Basis wird für Gelb definiert.
		 */
		if(color.contains("Gelb")) {
			
			crcBeginYellow1.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow2.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow3.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcField1.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			
			populateYellow();
			
			tokenID.put("crcBeginYellow1", "yellow1");
			tokenID.put("crcBeginYellow2", "yellow2");
			tokenID.put("crcBeginYellow3", "yellow3");
			tokenID.put("crcField1", "yellow4");
		}
		
		/*
		 * Pruefen, ob Farbe Schwarz ausgewaehlt wurde.
		 * Die Basis wird für Schwarz definiert.
		 */
		if(color.contains("Schwarz")) {
			
			crcBeginBlack1.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK)); 
			crcBeginBlack2.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack3.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcField31.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			
			populateBlack();
			
			tokenID.put("crcBeginBlack1", "black1");
			tokenID.put("crcBeginBlack2", "black2");
			tokenID.put("crcBeginBlack3", "black3");
			tokenID.put("crcField31", "black4");
		}
		
		/*
		 * Pruefen, ob Farbe Rot ausgewaehlt wurde.
		 * Die Basis wird für Rot definiert.
		 */
		if(color.contains("Rot")) {
			
			crcBeginRed1.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));   
			crcBeginRed2.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed3.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED)); 
			crcField21.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			
			populateRed();
			
			tokenID.put("crcBeginRed1", "red1");
			tokenID.put("crcBeginRed2", "red2");
			tokenID.put("crcBeginRed3", "red3");
			tokenID.put("crcField21", "red4");
		}
	}
	
	/**
	 * Methode, um die roten Spielfiguren in die rote Basis zu setzen.
	 */
	public void populateRed() {
		Image im4 = new Image("/pictures/Red.jpg", false);
		crcBeginRed1.setFill(new ImagePattern(im4));
		crcBeginRed2.setFill(new ImagePattern(im4));
		crcBeginRed3.setFill(new ImagePattern(im4));
		
		/*
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten.
		 */
		crcField21.setFill(new ImagePattern(im4));
	}
	
	/**
	 * Methode, um die schwarzen Spielfiguren in die schwarze Basis zu setzen.
	 */
	public void populateBlack() {
		Image im3 = new Image("/pictures/Black.jpg", false);
		crcBeginBlack1.setFill(new ImagePattern(im3));
		crcBeginBlack2.setFill(new ImagePattern(im3));
		crcBeginBlack3.setFill(new ImagePattern(im3));
		
		/*
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten.
		 */
		crcField31.setFill(new ImagePattern(im3));
	}
	
	/**
	 * Methode, um die gelben Spielfiguren in die gelbe Basis zu setzen.
	 */
	public void populateYellow() {
		Image im2 = new Image("/pictures/Yellow.jpg", false);
		crcBeginYellow1.setFill(new ImagePattern(im2));
		crcBeginYellow2.setFill(new ImagePattern(im2));
		crcBeginYellow3.setFill(new ImagePattern(im2));
		
		/*
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten.
		 */
		crcField1.setFill(new ImagePattern(im2));
	}
	
	/**
	 * Methode, um die gruenen Spielfiguren in die gruene Basis zu setzen.
	 */
	public void populateGreen() {
		Image im1 = new Image("/pictures/Green.jpg", false);
		crcBeginGreen1.setFill(new ImagePattern(im1));
		crcBeginGreen2.setFill(new ImagePattern(im1));
		crcBeginGreen3.setFill(new ImagePattern(im1));
		
		/*
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten.
		 */
		crcField11.setFill(new ImagePattern(im1));
	}
	
	/**
	 * Event Listener, um die Figuren mit einem Mausklick zu aendern.
	 * @param event Parameter des jeweiligen Events
	 */
	@FXML
	public void circleOnActionM(MouseEvent event) {
		
		/*
		 * Startfelder
		 */
	}
	
	/**
	 * Event Listener, um zu pruefen, ob das Feld gefüllt ist.
	 * @param event Parameter des jeweiligen Events
	 */
	@FXML
	public void circleOnActionT(TouchEvent event) {
		
	}
	
	/**
	 * Event Listener fuer den Button "Wuerfeln"
	 * Dieser Button ruft die Methode rollTheDice auf.
	 * @param event Parameter des jeweiligen Events
	 */
	@FXML
	public void buttonRollTheDiceOnAction(ActionEvent event) {
		
		RollTheDice rtd = new RollTheDice();
		int value = rtd.rollTheDice();

		/*
		 * Bilder der sechs Wuerfel
		 */
		Image dice1 = new Image("/pictures/Dice1.png", false);
		Image dice2 = new Image("/pictures/Dice2.png", false);
		Image dice3 = new Image("/pictures/Dice3.png", false);
		Image dice4 = new Image("/pictures/Dice4.png", false);
		Image dice5 = new Image("/pictures/Dice5.png", false);
		Image dice6 = new Image("/pictures/Dice6.png", false);
		
		/*
		 * Aendern des Wuerfelbildes zu der gewuerfelten Zahl
		 */
		switch (value) {
		case 1:
			imgDice.setImage(dice1);
			break;
		case 2:
			imgDice.setImage(dice2);
			break;
		case 3:
			imgDice.setImage(dice3);
			break;
		case 4:
			imgDice.setImage(dice4);
			break;
		case 5:
			imgDice.setImage(dice5);
			break;
		case 6:
			imgDice.setImage(dice6);
			break;
		default: imgDice.setImage(dice1);
			break;
		}
		
		/*
		 * Nach jedem mal Wuerfeln, die Anzahl der gewuerfelten Runden um 1 erhoehen.
		 */
		round++;
		
		/*
		 * Man darf nur einmal Wuerfeln und muss danach ziehen
		 */
		if (event.getSource()==btnRollTheDice) {
			
				btnRollTheDice.setDisable(true);
				if (/*spieler hat gezogen*/ 
						//circleOnActionM(event);
						true) {
					
					btnRollTheDice.setDisable(false);
			}
		}
	}
	
	/**
	 * Event Listener fuer den "Beenden"-Button.
	 * Dieser beendet das Programm vollstaendig.
	 * @param event Parameter des jeweiligen Events
	 */
	@FXML
	public void buttonExitGameOnAction(ActionEvent event) {

		System.exit(0);
	}
}

