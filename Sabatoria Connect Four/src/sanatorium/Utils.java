package sanatorium;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Utils {

	public static void displayMenu(VBox hbox, Label title, Button onePlayer, Button twoPlayers, HBox tileBox,
			GridPane connectFour, Label credits) {
		hbox.getChildren().removeAll(tileBox, connectFour);
		hbox.getChildren().addAll(title, onePlayer, twoPlayers, credits);
	}

	public static void startGame(Label lbl, Button onePlayer, Button twoPlayers, HBox tileBox, GridPane connectFour,
			VBox hbox, Label credits) {
		hbox.getChildren().removeAll(lbl, onePlayer, twoPlayers, credits);
		hbox.getChildren().addAll(tileBox, connectFour);
	}

	public static void gameOver(Label lbl, Button onePlayer, Button twoPlayers, HBox tileBox, GridPane connectFour,
			VBox hbox, Label credits) {
		hbox.getChildren().addAll(tileBox, connectFour);
	}
}
