package com.jana.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaFileTest extends Application {

	MediaPlayer mediaplayer;

	Button btnStart, btnStop, btnPause;

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {

		Media media = new Media("file:///C:/Users/Public/Music/Sample%20Music/Kalimba.mp3");

		media = new Media("file:///C:/Users/rpa34/Videos/Dawn.of.the.Planet.of.the.Apes.2014.720p.BluRay.x264.YIFY.mp4");

		mediaplayer = new MediaPlayer(media);

		// mediaplayer.setAutoPlay(true);

		btnStart = new Button("Start");
		btnPause = new Button("Pause");
		btnStop = new Button("Stop");

		btnStart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				mediaplayer.play();
			}
		});

		btnPause.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mediaplayer.pause();
			}
		});

		btnStop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mediaplayer.stop();
			}
		});

		mediaplayer.setVolume(0.1);

		MediaView mediaView = new MediaView(mediaplayer);

		VBox root = new VBox();
		root.getChildren().addAll(btnStart, btnPause, btnStop, mediaView);
		Scene scene = new Scene(root, 500, 500);

		stage.setScene(scene);
		stage.show();

		/**/
	}

}
