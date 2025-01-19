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

public class ConnectFourGUIDriver extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		VBox hbox = new VBox(10);
		HBox tileBox = new HBox(5);
		HBox Connect4 = new HBox(30);
		Button[] tileBtns = new Button[7];	

		Board board = new Board(6,7);
		//Button[][] slots = new Button[6][7];
		Circle[][] slots = new Circle[6][7];
		//current player
		
		
		

		
		//row of buttons to for player to press
		for (int i = 0; i < tileBtns.length; i++) {
			
			tileBtns[i] = new Button(String.valueOf(i+1));
			tileBtns[i].setPrefSize(65, 60);
			tileBox.getChildren().add(tileBtns[i]);
		}


		//board... slots?
		/*for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(60, 55);
				slots[i][j].setStyle("-fx-base: blue");
				slots[i][j].setDisable(true);
				Connect4.getChildren().addAll(slots[i][j]);
			}
		}*/
		
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Circle(70, 55, 30);
				//slots[i][j].setPrefSize(60, 55);
				//slots[i][j].setStrokeWidth(3);
				slots[i][j].setFill(Color.MIDNIGHTBLUE);
				slots[i][j].setDisable(true);
				Connect4.getChildren().addAll(slots[i][j]);
			}
		}
		//gridpane, holding buttons?
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				gridPane.add(slots[i][j], j, i);
			}
		}
		
		tileBox.setAlignment(Pos.CENTER);
		Connect4.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(tileBox,gridPane);
		
		Background background = new Background(new BackgroundFill(Color.MEDIUMBLUE, null, null));
		
		hbox.setBackground(background);
		Scene scene = new Scene(hbox, 500, 500);
		//pane.setStyle("-fx-background: blue");
		stage.setScene(scene);		
		

		stage.show();
		//when top buttons are pressed, drop into user indicated column.
		
		//System.out.println("checkeroo state is " + board.getCurrentPlayer() );
		for(int k = 0; k < tileBtns.length; k++) {
			int column = k;
			
			tileBtns[k].setOnAction(e -> {
				
				//drop token, verify win if applicable
				board.drop(column, slots, board.getCurrentPlayer());
				//TODO modify cell state too!!! also make currentPlayer enum?

				
			});
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
