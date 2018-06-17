package com.jana.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstFX extends Application{
	
	
	Label lb_text;
	Button btn_one;
	
	public static void main(String[] args) {
		
		
		
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {

		lb_text = new Label("Here I am..");
		btn_one = new Button("Click Me");
		
	
		
		btn_one.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				lb_text.setText("You Clicked me");
				
			}
		});
		
		
		VBox root = new VBox();
		
		root.getChildren().addAll(lb_text, btn_one);
		Scene scene = new Scene(root,500, 500);
		
		stage.setScene(scene);
		stage.show();
		
	}

}
