import java.sql.*;
public class Database 
{
	public Connection con;
	public Connection connect() 
	{
		
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			if(!con.isClosed())
				System.out.println("Succesfully connected to MySQL server...");
			Statement stmt = con.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS Solutions ";
			stmt.executeUpdate(sql);
			if (con != null )
				con.close();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Solutions", "root", "");
			if(!con.isClosed())
			System.out.println("Succesfully connected to MySQL server solutions database...");
			stmt = con.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS SolutionsTable("
					+ "name VARCHAR(100) NOT NULL PRIMARY KEY,"
					+ "description VARCHAR(1000),"
					+ "solution VARCHAR(1000) NOT NULL)";
			stmt.executeUpdate(sql);
				
		}
		catch(Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
		}
		
		
		return con;
	}

	public void close(Connection con)
	{
		try 
		{
			if (con != null )
				con.close();
		}
		catch(SQLException e) 
		{
			System.err.println("Exception: " + e.getMessage());
		}	
		
	}
	public void searchDatabase(Connection con, String search)
	{
		try 
		{
			
			String sql = "SELECT name, filepath FROM filesystem";
			
		}
		catch(Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
		}
	}
	
	public void addData(Connection con, String name, String description, String solution)
	{
		try 
		{
			
			String sql = "INSERT INTO SolutionsTable(name,description,solution) "
					+ "VALUES (?,?,?)" ;
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, description);
			preparedStmt.setString(3, solution);
			preparedStmt.execute();
			
		}
		catch(Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
		}
		
	}
	
	public static void main(String args[])
	{
		Database d = new Database();
		d.con= d.connect();
		d.close(d.con);
	}

}
