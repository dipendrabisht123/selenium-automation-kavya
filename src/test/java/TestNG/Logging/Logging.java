package TestNG.Logging;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Logging {
  
	@Test
  public void f() {
		
		Logger logger = LogManager.getLogger(Logging.class.getName());
		
		logger.log(Level.FATAL, "Logging Fatal message");
		logger.log(Level.ERROR, "Logging Fatal message");
		logger.log(Level.WARN, "Logging Fatal message");
		
		logger.log(Level.INFO, "Logging INFO message");
		logger.log(Level.DEBUG, "Logging DEBUG message");
  }
}
