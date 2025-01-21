package sanatorium;

import javafx.application.Application;
import javafx.application.Platform;

import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class ConnectFourGUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		VBox vbox = new VBox(10);
		HBox tileBox = new HBox(5);
		HBox hbox = new HBox(30);
		Button[] tileBtns = new Button[7];
		Board board = new Board(6, 7);
		Circle[][] slots = new Circle[6][7];

		// title screen
		Label title = new Label("CONNECT 4");
		title.setStyle("-fx-font: 50 arial");
		title.setTextFill(Color.WHITE);

		// 1 player button
		Button onePlayer = new Button(" 1 PLAYER ");
		onePlayer.setStyle("-fx-font: 30 arial");
		onePlayer.setAlignment(Pos.CENTER);

		// 2 players button
		Button twoPlayers = new Button("2 PLAYERS");
		twoPlayers.setStyle("-fx-font: 30 arial");
		twoPlayers.setAlignment(Pos.CENTER);

		// Credits
		Label credits = new Label("A SABATORIA PRODUCTION");
		credits.setStyle("-fx-font: 25 arial");
		credits.setTextFill(Color.WHITE);
		credits.setAlignment(Pos.CENTER);
		
		//Restart game
		HBox gameOptions = new HBox(10);
		Button restart = new Button("RESET BOARD");
		Button quit = new Button("QUIT");
		restart.setStyle("-fx-font: 25 arial");
		quit.setStyle("-fx-font: 25 arial");
		gameOptions.getChildren().addAll(restart, quit);
		gameOptions.setAlignment(Pos.CENTER);

		//when restart button is pressed, restart
				restart.setOnAction(e -> {
					board.clearBoard(tileBtns, slots, board);
				});
				
				//when quit button is pressed, quit
				quit.setOnAction(e -> {
					Platform.exit();
				});
				
		// row of buttons to for player to press to drop tokens
		for (int i = 0; i < tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i+1));
			tileBtns[i].setStyle("-fx-font: 20 arial; -fx-font-weight: bold; -fx-text-fill: white");
			tileBtns[i].setPrefSize(65, 60);

			tileBox.getChildren().add(tileBtns[i]);
		}
		
		//colour tiles to indicate current player
		board.switchPlayer(tileBtns);


		// creating grid of circles to represent board
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Circle(70, 55, 30);

				slots[i][j].setFill(Color.MIDNIGHTBLUE);
				slots[i][j].setDisable(true);
				hbox.getChildren().addAll(slots[i][j]);
			}
		}
		//A 7 by 6 Grid to acting as the Connect 4 Board holding the slots
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				gridPane.add(slots[i][j], j, i);
			}
		}

		// bonus content
		vbox.setAlignment(Pos.TOP_CENTER);
		tileBox.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);

		// start of game - display menu, start game when appropriate button is pressed
		Utils.displayMenu(vbox, title, onePlayer, twoPlayers, tileBox, gridPane, credits);

		twoPlayers.setOnAction(e -> {
			Utils.startGame(title, onePlayer, twoPlayers, tileBox, gridPane, vbox, credits, gameOptions);
		});
		
		//blue background
		Background background = new Background(new BackgroundFill(Color.MEDIUMBLUE, null, null));
		vbox.setBackground(background);
		Scene scene = new Scene(vbox, 500, 550);	
		stage.setScene(scene);		
		stage.show();
		
		//when top buttons are pressed, drop into user indicated column.
		for(int k = 0; k < tileBtns.length; k++) {
			int column = k;
			tileBtns[k].setOnAction(e -> {
			//drop token, verify win if applicable
			board.drop(column, slots, board.getCurrentPlayer(), tileBtns);
			board.display();
	});}
		
		
	}
	public static void main(String[] args) {
		launch(args);

	}}

