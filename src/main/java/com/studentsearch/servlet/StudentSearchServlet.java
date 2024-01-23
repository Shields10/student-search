package com.studentsearch.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentsearch.dao.DBConnectionManager;
import com.studentsearch.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSearchServlet
 */
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");
        List<Student> searchResults = getStudentResultsFromDatabase(searchQuery);

        request.setAttribute("searchResults", searchResults);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
    }

    private List<Student> getStudentResultsFromDatabase(String searchQuery) {
        List<Student> searchResults = new ArrayList<>();
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM student WHERE name LIKE ? OR student_id LIKE ? OR phone_number LIKE ?")) {
            String likeQuery = "%" + searchQuery + "%";
            preparedStatement.setString(1, likeQuery);
            preparedStatement.setString(2, likeQuery);
            preparedStatement.setString(3, likeQuery);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setName(resultSet.getString("name"));
                    student.setStudentId(resultSet.getString("student_id"));
                    student.setPhoneNumber(resultSet.getString("phone_number"));
                    student.setCurrentClass(resultSet.getInt("current_class"));
                    searchResults.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResults;
    }

}
