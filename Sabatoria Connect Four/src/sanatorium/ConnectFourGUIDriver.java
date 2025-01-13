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

		HBox hbox = new HBox(10);
		Label title = new Label("Connect Four");
		title.setAlignment(Pos.CENTER);
		hbox.getChildren().add(title);
		Scene scene = new Scene(hbox, 500, 500);
		stage.setScene(scene);		

		stage.show();
		
		
		HBox row1 = new HBox(10);
		HBox row2 = new HBox(10);
		HBox row3 = new HBox(10);
		HBox row4 = new HBox(10);
		HBox row5 = new HBox(10);
		HBox row6 = new HBox(10);
		
		
		
		
		Button[] bRow1 = new Button[7];
		
		VBox bocks = new VBox(10);
		for (int i = 0; i < 7; i++) {
			bRow1[i] = new Button(String.valueOf(i + 1));
			bRow1[i].setStyle("-fx-background-color:white");
			//tiles[i] = new Tile(i + 1);
			row1.getChildren().add(bRow1[i]);
		}
		
		
		
		bocks.getChildren().addAll(row1);
		
		//bocks.getChildren().addAll(row1, row2, row3, row4, row5, row6);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
