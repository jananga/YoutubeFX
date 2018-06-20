package com.jana.fx;

import java.util.Date;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import com.jana.fx.model.Student;

public class ComboBoxTest extends Application {

	ComboBox<Student> cmbStudent;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();

		root.getChildren().addAll(cmbStudent);
		Scene scene = new Scene(root, 500, 500);

		stage.setScene(scene);

		stage.show();

	}

	@Override
	public void init() {

		cmbStudent = new ComboBox<Student>();

		cmbStudent.setItems(getStudentDummy());

		cmbStudent.getSelectionModel().select(0);

		cmbStudent.valueProperty().addListener(new ChangeListener<Student>() {

			@Override
			public void changed(ObservableValue<? extends Student> observable, Student bm, Student nm) {

				if (bm != null) {
					System.out.print("Before Me : " + bm + " -> ");
				}
				System.out.println("Now Me : " + nm);

			}
		});

		cmbStudent.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {

			@Override
			public ListCell<Student> call(ListView<Student> param) {
				ListCell<Student> cell = new ListCell<Student>() {

					@Override
					public void updateItem(Student student, boolean empty) {
						super.updateItem(student, empty);
						if (student != null) {
							setText(student.toString());

							if (student.getName().equals("jananga2")) {
								setTextFill(Color.BLUE);
							}

						}

						else {
							 setText(null);
						}
					}

				};
				return cell;
			}
		});
	}

	public static ObservableList<Student> getStudentDummy() {

		ObservableList<Student> ol = FXCollections.observableArrayList();

		ol.add(new Student("jananga1", "Station Road Kandana", "0774424059", new Date(), "Test Field One"));
		ol.add(new Student("jananga2", "Station Road Kandana", "0774424059", new Date(), "Test Field Two"));

		ol.add(new Student("jananga3", "Station Road Kandana", "0774424059", new Date(), "Test Field Three"));
		ol.add(new Student("jananga4", "Station Road Kandana", "0774424059", new Date(), "Test Field Three"));
		ol.add(new Student("jananga5", "Station Road Kandana", "0774424059", new Date(), "Test Field Three"));

		return ol;
	}

}
