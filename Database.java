import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Database 
{
	public Database() 
	{
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
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
			//close connection
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
		catch(Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
		}
		
		
	}

	
	public List<String[]> searchDatabase( String search)
	{
		
		String sql = "SELECT * FROM solutionstable WHERE name like ? "  ;
		List<String[]> results = new ArrayList<String[]>();
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Solutions", "root", "");
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, search+"%");
			
			ResultSet rs = preparedStatement.executeQuery();
			
			//String[] tempResult = new String[3];
			while(rs.next())
			{
				String[] tempResult = new String[3];
				tempResult[0] = rs.getString("name");
				tempResult[1] = rs.getString("description");
				tempResult[2] = rs.getString("solution");
			
				results.add(tempResult);
				
				
				
			}
			
			//close connection
			try 
			{
				preparedStatement.close();
				if (con != null )
					con.close();
			}
			catch(SQLException e) 
			{
				System.err.println("Exception: " + e.getMessage());
			}	
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return results;
		
	}
	
	public void addData( String name, String description, String solution)
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Solutions", "root", "");
			
			String sql = "INSERT INTO SolutionsTable(name,description,solution) "
					+ "VALUES (?,?,?)" ;
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, description);
			preparedStmt.setString(3, solution);
			preparedStmt.execute();
			
			//close connection
			try 
			{
				preparedStmt.close();
				if (con != null )
					con.close();
			}
			catch(SQLException e) 
			{
				System.err.println("Exception: " + e.getMessage());
			}	
			
		}
		
		catch(Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
		}
		
		
	}
	
	public static void main(String args[])
	{
		Database d = new Database();
		
		////d.addData( "error1", "program crashes when yeet", "dont yeet");
		//d.addData( "bug1", "program crashes when goop", "dont goop");
		
		System.out.println(d.searchDatabase("error").get(0)[1]);
		
	
	}

}
