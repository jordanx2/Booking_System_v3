/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.storage ;

import java.io.* ;
import java.sql.* ;
import java.util.* ;

class Connectivity
{
  /**
   * getConnection() takes the name of a property file and returns
   * a connection.  A null return indicates failure to make a connection.
   * Any exceptions raised are printed, for ease of tracing.
   *
   * We assume the property file contains:
   *
   *   jdbc.driver: the name of the driver to be used
   *   jdbc.url:    the URL of the database to connect to
   */
  
  static Connection getConnection(String propFile)
  {
    Properties props = new Properties() ;
    InputStream pfile = null ;
    Connection con = null ;
    // Driver driver;

    // Load in the property file
    
    try {
      pfile = new FileInputStream(propFile) ;
      System.out.println("Successfully opened properties file\n");
      props.load(pfile) ;
      pfile.close() ;
    }
    catch (IOException e) {
      e.printStackTrace() ;
      return con ;
    }
    finally {
      if (pfile != null) {
	try {
	  pfile.close() ;
	}
	catch (IOException ignored) {}
      }
    }

    // Load the Driver class
    
   String driverName = props.getProperty("jdbc.driver") ;
    
    try {
    	// not necessary
    	Class.forName(driverName );     
    }
    catch (Exception e) {
      System.out.println("Not found " + driverName);
      e.printStackTrace() ;
      return con ;
    }
       
    // Try to make a connection
    
    String dbURL = props.getProperty("jdbc.url") ;
    try{
    //  DriverManager.registerDriver(driver); //not necessary
      con = DriverManager.getConnection(dbURL, "root", "") ;
    }
    catch (SQLException e) {
      e.printStackTrace() ;
    }
    return con ;
  }

}
