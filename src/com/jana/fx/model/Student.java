package com.jana.fx.model;

import java.util.ArrayList;
import java.util.Date;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Student {
	
	private String name, address, telno;
	private Date dob;
	
	public Student(String name, String address, String telno, Date dob){
		
		this.name = name;
		this.address = address;
		this.telno = telno;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}
	
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public static ArrayList<TableColumn<Student, ?>> getColumn(TableView table){
		
		int i = 0;
		ArrayList<TableColumn<Student, ?>> columns = new ArrayList<TableColumn<Student,?>>();
		
		String[] columnNames = {"Name", "Address", "TelNo", "Dob"};
		String[] variableNames = {"name","address","telno","dob"};
		Integer[] columnWidths = { 33, 33, 33, 33};
		
		TableColumn<Student, String> columnOne = new TableColumn<Student, String>(columnNames[i++]);
		TableColumn<Student, String> columnTwo = new TableColumn<Student, String>(columnNames[i++]);
		TableColumn<Student, String> columnThree = new TableColumn<Student, String>(columnNames[i++]);
		TableColumn<Student, Date> columnFour = new TableColumn<Student, Date>(columnNames[i++]);

		
		i = 0;
		columnOne.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidths[i++]));
		columnTwo.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidths[i++]));
		columnThree.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidths[i++]));
		columnFour.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidths[i++]));

		
		i = 0;
		columnOne.setCellValueFactory(new PropertyValueFactory<Student, String>(variableNames[i++]));
		columnTwo.setCellValueFactory(new PropertyValueFactory<Student, String>(variableNames[i++]));
		columnThree.setCellValueFactory(new PropertyValueFactory<Student, String>(variableNames[i++]));
		columnFour.setCellValueFactory(new PropertyValueFactory<Student, Date>(variableNames[i++]));

		
		
		columns.add(columnOne);
		columns.add(columnTwo);
		columns.add(columnThree);
		columns.add(columnFour);

		return columns;
		
		
	}

}
