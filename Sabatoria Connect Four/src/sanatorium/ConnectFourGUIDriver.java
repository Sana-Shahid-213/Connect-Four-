package sanatorium;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConnectFourGUIDriver extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		VBox hbox = new VBox(10);
		//Label title = new Label("Connect Four");
	//	title.setAlignment(Pos.CENTER);
		//hbox.getChildren().add(title);
		HBox tileBox = new HBox(5);
		Button[] tileBtns = new Button[7];	

		for (int i = 0; i < tileBtns.length; i++) {
			
			tileBtns[i] = new Button();
			tileBtns[i].setPrefSize(65, 60);
			tileBox.getChildren().add(tileBtns[i]);
		}

		tileBox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(tileBox);
		Scene scene = new Scene(hbox, 500, 500);
		stage.setScene(scene);		
		

		stage.show();
		
		
		Button[] bRow1 = new Button[7];
		
		VBox bocks = new VBox(10);
		for (int i = 0; i < 7; i++) {
			bRow1[i] = new Button(String.valueOf(i + 1));
			bRow1[i].setStyle("-fx-background-color:white");
			//tiles[i] = new Tile(i + 1);
			//row1.getChildren().add(bRow1[i]);
		}
		
		
		
		//bocks.getChildren().addAll(row1);
		
		//bocks.getChildren().addAll(row1, row2, row3, row4, row5, row6);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
