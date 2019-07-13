package sixplayersgame;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.SplitPane;

import java.util.ArrayList;

import game.RollTheDice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

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
 * Dieser Controller ist fuer das Steuern und initialisieren des  grafischen Spielfeldes für bis zu 6 Spieler zustaendig.
 * Dieser synergiert mit dem GameBoardSixPlayers.fxml
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class GameBoardSixPlayersController {
	
	/*
	 * FXML Komponenten, die spaeter auf dem Feld zu sehen sind 
	 */
	@FXML
	public SplitPane splitPane;
	public GridPane gridPaneLeft;
	public GridPane gridPaneRigth;
	
	/*
	 * Startfelder der jeweiligen Farbe
	 */
	public Circle crcBeginYellow1;
	public Circle crcBeginYellow2;
	public Circle crcBeginYellow3;
	public Circle crcBeginYellow4;
	public Circle crcBeginBlack1;
	public Circle crcBeginBlack2;
	public Circle crcBeginBlack3;
	public Circle crcBeginBlack4;
	public Circle crcBeginRed1;
	public Circle crcBeginRed2;
	public Circle crcBeginRed3;
	public Circle crcBeginRed4;
	public Circle crcBeginBlue1;
	public Circle crcBeginBlue2;
	public Circle crcBeginBlue3;
	public Circle crcBeginBlue4;
	public Circle crcBeginGreen1;
	public Circle crcBeginGreen2;
	public Circle crcBeginGreen3;
	public Circle crcBeginGreen4;
	public Circle crcBeginPurple1;
	public Circle crcBeginPurple2;
	public Circle crcBeginPurple3;
	public Circle crcBeginPurple4;
	
	/*
	 * Zielfelder der jeweiligen Farbe
	 */
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
	public Circle crcAimBlack1;
	public Circle crcAimBlack2;
	public Circle crcAimBlack3;
	public Circle crcAimBlack4;
	public Circle crcAimPurple1;
	public Circle crcAimPurple2;
	public Circle crcAimPurple3;
	public Circle crcAimBlue1;
	public Circle crcAimBlue2;
	public Circle crcAimBlue3;
	public Circle crcAimBlue4;
		
	/*
	 * Lauffelder des Bretts
	 */
	public Circle crcField48;
	public Circle crcField45;
	public Circle crcField2;
	public Circle crcField46;
	public Circle crcField28;
	public Circle crcField47;
	public Circle crcField29;
	public Circle crcField43;
	public Circle crcField3;
	public Circle crcField44;
	public Circle crcField20;
	public Circle crcField1;
	public Circle crcField21;
	public Circle crcField22;
	public Circle crcField30;
	public Circle crcField27;
	public Circle crcField35;
	public Circle crcField26;
	public Circle crcField33;
	public Circle crcField24;
	public Circle crcField32;
	public Circle crcField23;
	public Circle crcField31;
	public Circle crcField42;
	public Circle crcField41;
	public Circle crcField38;
	public Circle crcField25;
	public Circle crcField40;
	public Circle crcField36;
	public Circle crcField37;
	public Circle crcField34;
	public Circle crcField39;
	public Circle crcField4;
	public Circle crcField5;
	public Circle crcField6;
	public Circle crcField7;
	public Circle crcField8;
	public Circle crcField9;
	public Circle crcField10;
	public Circle crcField11;
	public Circle crcField12;
	public Circle crcField13;
	public Circle crcField14;
	public Circle crcField15;
	public Circle crcField16;
	public Circle crcField17;
	public Circle crcField18;
	public Circle crcField19;
	
	/*
	 * Button zum Wuerfeln, zum Beenden des Spiels
	 */
	public Button btnRollTheDice;
	public Button btnExitGame;
	
	/*
	 * ImageView, welche das Wuerfelbild zeigt
	 */
	public ImageView imgDice;
	public Label lblPlayer;
	
	/*
	 * Namen der Spieler eins bis sechs
	 */
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	public TextField txtPlayer5;
	public TextField txtPlayer6;
	
	/*
	 * Zaehlt wie oft der Button Wuerfeln geklickt wurde.
	 */
	public int round = 0;
	
	/*
	 * Diese ArrayLists halten die Felder, diese werden entweder in drei Kategorien eingeteilt den Lauffelder, Hausfeldern/Beginfeldern und Zielfeldern.
	 */
	public ArrayList<Circle> fieldsGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsGui = new ArrayList<Circle>();
	
	/**
	 * Methode, die das Spielbrett für bis zu 6 Spieler initialisiert
	 * @param playerName Name der Spieler
	 * @param color Farbe der jeweiligen Spieler
	 * @param rival Eigenschaft der Spieler
	 * @param numberOfPlayers Anzahl der Spieler
	 */
	public void initialize(ArrayList<String> playerName, ArrayList<String> color, ArrayList<String> rival, int numberOfPlayers) {
		
		ObservableList<Node> l_circleList = gridPaneLeft.getChildren();
		for (Node l_node : l_circleList) {
			
			Circle l_circle = (Circle) l_node;
			
			if (l_circle.getId().startsWith("crcField")) {
				fieldsGui.add(l_circle);
			} 
			
			else if (l_circle.getId().startsWith("crcAim")) {
				aimFieldsGui.add(l_circle);
			} 
			
			else {
				beginFieldsGui.add(l_circle);
			}
		}
		
		/*
		 * Anzeigen der Spielernamen mit ihrer jeweiligen Farbe
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + color.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + color.get(1));
		txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
		
		if(numberOfPlayers == 5) {
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
		}
		
		else if(numberOfPlayers == 6) {
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
			txtPlayer6.setText(playerName.get(5) + " - " + color.get(5));
		}
		/*
		 * Pruefen, ob die Farbe Gruen ausgewaehlt wurde.
		 * Definiert Basis fuer Gruen
		 */
		if(color.contains("Gruen")) {
			
			crcBeginGreen1.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen2.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen3.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcField33.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			
			populateGreen();
		}
		
		/*
		 * Pruefen, ob die Farbe Gelb ausgewaehlt wurde
		 * Definiert die Basis fuer Gelb
		 */
		if(color.contains("Gelb")) {
			
			crcBeginYellow1.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow2.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow3.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcField1.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			
			populateYellow();
		}
		
		/*
		 * Pruefen, ob die Farbe Schwarz ausgewaehlt wurde
		 * Definiert die Basis fuer schwarz
		 */
		if(color.contains("Schwarz")) {
			
			crcBeginBlack1.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));   
			crcBeginBlack2.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK)); 
			crcBeginBlack3.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcField9.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			
			populateBlack();
		}
		
		/*
		 * Pruefen, ob die Farbe Rot ausgewaehlt wurde.
		 * Definiert die Basis fuer Rot
		 */
		if(color.contains("Rot")) {
			
			crcBeginRed1.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed2.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed3.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcField25.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			
			populateRed();
		}
		
		/*
		 * Pruefen, ob die Farbe Blau ausgewaehlt wurde.
		 * Definiert die Basis fuer Blau
		 */
		if(color.contains("Blau")) {
			
			crcBeginBlue1.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			crcBeginBlue2.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			crcBeginBlue3.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));	    
			crcField17.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			
			populateBlue();     
		}
		
		/*
		 * Pruefen, ob die Farbe Lila ausgewaehlt wurde.
		 * Definiert die Basis fuer Lila.
		 */
		if(color.contains("Lila")) {
			
			crcBeginPurple1.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE)); 
			crcBeginPurple2.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE));
			crcBeginPurple3.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE)); 
			crcField41.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE));
			
			populatePurple();
		}
	}	

	
	/**
	 * Methode, um die lila Spielfiguren in die lila Basis zu setzen.
	 */
	public void populatePurple() {
		Image im6 = new Image("/pictures/Purple.jpg", false);
		crcBeginPurple1.setFill(new ImagePattern(im6));
		crcBeginPurple2.setFill(new ImagePattern(im6));
		crcBeginPurple3.setFill(new ImagePattern(im6));
		
		/*
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten
		 */
		crcField41.setFill(new ImagePattern(im6));
	}
	
	/**
	 * Methode, um die blauen Spielfiguren in die blaue Basis zu setzen.
	 */
	public void populateBlue() {
		Image im5 = new Image("/pictures/Blue.jpg", false);
		crcBeginBlue1.setFill(new ImagePattern(im5));
		crcBeginBlue2.setFill(new ImagePattern(im5));
		crcBeginBlue3.setFill(new ImagePattern(im5));
		
		/*
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten
		 */
		crcField17.setFill(new ImagePattern(im5));
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
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten
		 */
		crcField25.setFill(new ImagePattern(im4));	
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
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten
		 */
		crcField9.setFill(new ImagePattern(im3));
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
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten
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
		 * Zu Beginn mit einer Spielfigur auf dem Feld starten
		 */
		crcField33.setFill(new ImagePattern(im1));
	}
	
	/**
	 * Event Listener, um die Figuren mit einem Mausklick zu aendern.
	 * @param event Parameter des jeweiligen Events
	 */
	@FXML
	public void circleOnActionM(MouseEvent event) {
		
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
		 * Aendern des Wuerfel bildes zu der gewuerfelten Zahl
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
		 * Nach jedem mal wuerfeln werden die rounds hochgezaehlt
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
