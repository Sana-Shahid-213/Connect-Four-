package sanatorium;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConnectFourGUIDriver extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		VBox hbox = new VBox(10);
		HBox tileBox = new HBox(5);
		HBox Connect4 = new HBox(30);
		Button[] tileBtns = new Button[7];	

		Board board = new Board(6,7);
		Button[][] slots = new Button[6][7];

		for (int i = 0; i < tileBtns.length; i++) {
			
			tileBtns[i] = new Button();
			tileBtns[i].setPrefSize(65, 60);
			tileBox.getChildren().add(tileBtns[i]);
		}


		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(60, 55);
				slots[i][j].setStyle("-fx-base: #0000FF;");
				slots[i][j].setDisable(true);
				Connect4.getChildren().addAll(slots[i][j]);
			}
		}
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
		Scene scene = new Scene(hbox, 500, 500);
		stage.setScene(scene);		
		

		stage.show();

		for(int k = 0; k <tileBtns.length; k++) {
			tileBtns[k].setOnAction(e -> {
				 //sana
				
			});
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
