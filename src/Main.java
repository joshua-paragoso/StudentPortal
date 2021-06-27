import java.util.*;
import java.sql.*;

public class Main {

	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/studentdb?autoReconnect=true&useSSL=false";
//	public static String url = "jdbc:mysql://localhost:3306/studentdb";
	public static String username = "root";
    public static String password = "1234";
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner input = new Scanner(System.in);
//		
//		Student student = new Student();
//		
//		System.out.println("Enter student name: ");
//		student.studentName = input.next();
//		
//		System.out.println("What grade are they in: ");
//		student.gradeLevel = input.nextInt();
//		
//		System.out.println("Enter GPA: ");
//		student.GPA = input.nextDouble();
		
		//testing connection from laptop
		
		
//		System.out.println(student.studentInfo());
		
		
		try {
				
			String sql = "select * from students";
			
			//get connection to database
			Connection con = DriverManager.getConnection(url, username, password);
			
			//create a statement
			Statement statement = con.createStatement();
			
			//execute SQL query
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("Here are the students in the class");
			//prints the result set
			while(rs.next()) {
				String name = rs.getString("Name");
				int grade = rs.getInt("Grade");
				double gpa = rs.getDouble("GPA");
//				System.out.println(rs.getString("Name"));
				System.out.println(name + " | " + grade + " | " + gpa);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
