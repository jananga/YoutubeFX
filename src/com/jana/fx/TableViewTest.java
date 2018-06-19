package com.jana.fx;

import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.jana.fx.model.Student;

public class TableViewTest extends Application {

	TableView<Student> table;
	
	
	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void init(){
		table = new TableView<Student>();
		
		table.getColumns().addAll(Student.getColumn(table));
		table.setItems(getStudentDummy());
		table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getClickCount() > 0){
					if(table.getSelectionModel().getSelectedIndex() >= 0){
						System.out.println("Name is : "+table.getSelectionModel().getSelectedItem().getName());
						System.out.println("Address is : "+table.getSelectionModel().getSelectedItem().getAddress());
						System.out.println("Telno is : "+table.getSelectionModel().getSelectedItem().getTelno());
						System.out.println("DOB is : "+table.getSelectionModel().getSelectedItem().getDob().toString());

					}
				}
			}
		});
		
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();

		root.getChildren().addAll(table);

		Scene scene = new Scene(root, 500, 500);

		stage.setScene(scene);

		stage.show();

	}

	public static ObservableList<Student> getStudentDummy() {

		ObservableList<Student> ol = FXCollections.observableArrayList();

		ol.add(new Student("jananga", "Station Road Kandana", "0774424059", new Date()));
		ol.add(new Student("jananga", "Station Road Kandana", "0774424059", new Date()));

		ol.add(new Student("jananga", "Station Road Kandana", "0774424059", new Date()));

		return ol;
	}

}
