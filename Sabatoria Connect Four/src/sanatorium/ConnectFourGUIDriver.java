package sanatorium;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
