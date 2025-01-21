package sanatorium;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConnectFourGUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		VBox hbox = new VBox(10);
		HBox tileBox = new HBox(5);
		HBox Connect4 = new HBox(30);
		Button[] tileBtns = new Button[7];

		Board board = new Board(6, 7);
		Circle[][] slots = new Circle[6][7];
		// current player

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

		// row of buttons to for player to press to drop tokens
		for (int i = 0; i < tileBtns.length; i++) {


			tileBtns[i] = new Button(String.valueOf(i + 1));

			
			tileBtns[i] = new Button(String.valueOf(i+1));

			tileBtns[i].setStyle("-fx-font: 20 arial; -fx-font-weight: bold; -fx-text-fill: white");
			tileBtns[i].setPrefSize(65, 60);

			tileBox.getChildren().add(tileBtns[i]);
		}
		
		//colour tiles to indicate current player
		board.switchPlayer(tileBtns);

		// colour tiles to indicate current player
		board.switchPlayer(tileBtns);

		// creating grid of circles to represent board
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Circle(70, 55, 30);

				slots[i][j].setFill(Color.MIDNIGHTBLUE);
				slots[i][j].setDisable(true);
				Connect4.getChildren().addAll(slots[i][j]);
			}
		}
		// gridpane, holding board circles??????
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
		hbox.setAlignment(Pos.CENTER);

		tileBox.setAlignment(Pos.CENTER);
		Connect4.setAlignment(Pos.CENTER);

		// hbox.getChildren().addAll(tileBox, gridPane, Connect4);

		// start of game - display menu,
		Utils.displayMenu(hbox, title, onePlayer, twoPlayers, tileBox, gridPane, credits);
		twoPlayers.setOnAction(e -> {
			Utils.startGame(title, onePlayer, twoPlayers, tileBox, gridPane, hbox, credits);
		});

		Background background = new Background(new BackgroundFill(Color.MEDIUMBLUE, null, null));
		hbox.setBackground(background);

		
		
		Scene scene = new Scene(hbox, 500, 500);
		
		
		stage.setScene(scene);		
		stage.show();
		
		
		//when top buttons are pressed, drop into user indicated column.
		//System.out.println("checkeroo state is " + board.getCurrentPlayer() );
		for(int k = 0; k < tileBtns.length; k++) {
			int column = k;
			
			tileBtns[k].setOnAction(e -> {
				
				//drop token, verify win if applicable
				board.drop(column, slots, board.getCurrentPlayer(), tileBtns);
				//TODO modify cell state too!!! also make currentPlayer enum maybe? research later

	});}
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}}

	



