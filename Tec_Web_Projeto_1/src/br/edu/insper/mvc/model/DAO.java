package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	private Connection connection = null;

	public DAO() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TecWebProjeto1?serverTimezone=UTC", "root", "!Nando13532542");
	 
	}
	
	public void adiciona(Tasks task) throws SQLException {
		String sql = "INSERT INTO Tasks (title,creator,tag) VALUES (?,?,?);";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setNString(1, task.getTitle());
		statement.setNString(2, task.getCreator());
		statement.setNString(3, task.getTag());
		
		statement.execute();
		statement.close();
	}
	
	public void edita(Tasks task) throws SQLException {
		String sql = "UPDATE Tasks SET title=?, creator=?, tag=? WHERE id=?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setNString(1, task.getTitle());
		statement.setNString(2, task.getCreator());
		statement.setNString(3, task.getTag());
		statement.setInt(4, task.getId());
		
		statement.execute();
		statement.close();
	}
	
	public void remove(Integer id) throws SQLException {
		String sql = "DELETE FROM Tasks WHERE id=?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, id);
		
		statement.execute();
		statement.close();
	}
	 
	public List<Tasks> getLista() throws SQLException{

		List<Tasks> tasks = new ArrayList<Tasks>();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Tasks;");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			Tasks task = new Tasks();

			task.setId(result.getInt("id"));

			task.setTitle(result.getNString("title"));

			task.setCreator(result.getNString("creator"));

			task.setTag(result.getNString("tag"));

			tasks.add(task);

		}

		result.close();

		statement.close();

		return tasks;

	}
	
	public void close() throws SQLException {

		connection.close();

	}
}
