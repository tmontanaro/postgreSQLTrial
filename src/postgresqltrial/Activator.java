package postgresqltrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.postgresql.*;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World to do!!");
		//Class.forName("org.postgresql.Driver");
		Connection conn = null;
		  Statement stmt = null;
		  try {
			 //Class.forName("org.postgresql.Driver");
			  String url = "jdbc:postgresql://localhost:5432/db";
			  Properties props = new Properties();
			  props.setProperty("user","usernameABC");
			  props.setProperty("password","passwordBCD");
			  //props.setProperty("ssl","true");
			  conn = DriverManager.getConnection(url, props);

			  //Connection conn = DriverManager.getConnection(url);
			  
			 conn.setAutoCommit(false);
			 System.out.println("Opened database successfully");

			 stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery( "SELECT * FROM table1;" );
			 while ( rs.next() ) {
				//TODO
			 }
			 rs.close();
			 stmt.close();
			 conn.close();
		  } catch ( Exception e ) {
			 System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		  }
		  System.out.println("Operation done successfully");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
