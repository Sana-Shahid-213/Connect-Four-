package sanatorium;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Purpose: Contains game control utility methods for Connect Four
 * @author Sana & Victoria
 * @date 20 Jan 2025
 */
public class Utils {
	
	/**
	 * Purpose: to display the starting menu upon launching the game
	 * @param vbox - VBox holding menu elements
	 * @param title - Label "Connect Four"
	 * @param onePlayer - Button for one player gameplay
	 * @param twoPlayers - Button for two player gameplay
	 * @param tileBox - HBox storing buttons for user to select column to drop tokens
	 * @param connectFour - GridPane storing Circle objects representing the board
	 * @param credits - Label with credits info
	 */
	public static void displayMenu(VBox vbox, Label title, Button onePlayer, Button twoPlayers, HBox tileBox,
			GridPane connectFour, Label credits) {
		vbox.getChildren().removeAll(tileBox, connectFour);
		vbox.getChildren().addAll(title, onePlayer, twoPlayers, credits);
	}
	/**
	 * Purpose - to remove start menu elements and add in the Connect Four board/buttons upon game start
	 * @param lbl - Label "Connect Four"
	 * @param onePlayer - Button for one player gameplay
	 * @param twoPlayers - Button for two player gameplay
	 * @param tileBox - HBox storing buttons for user to select column to drop tokens
	 * @param connectFour - GridPane storing Circle objects representing the board
	 * @param hbox - VBox holding game elements
	 * @param credits - Label with credits info
	 * @param gameOptions - HBox holding reset and quit buttons
	 */
	public static void startGame(Label lbl, Button onePlayer, Button twoPlayers, HBox tileBox, GridPane connectFour,
			VBox hbox, Label credits, HBox gameOptions) {
		hbox.getChildren().removeAll(lbl, onePlayer, twoPlayers, credits);
		hbox.getChildren().addAll(tileBox, connectFour, gameOptions);
	}
}
