package com.studentsearch.model;

//Student.java
import java.io.Serializable;

public class Student implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String name;
private String studentId;
private String phoneNumber;
private int currentClass;
private String result;

 public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public int getCurrentClass() {
	return currentClass;
}
public void setCurrentClass(int currentClass) {
	this.currentClass = currentClass;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}

}