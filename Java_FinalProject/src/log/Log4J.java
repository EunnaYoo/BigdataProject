package log;

import org.apache.log4j.Logger;

public class Log4J {

	private final Logger logger = Logger.getLogger(Log4J.class);
	
	private static Log4J instance = new Log4J();
	private Log4J(){};
	
	public static Log4J getInstance() {
		return instance;
	}

	public void info() {
		logger.info("실행");
	}

	public void error() {
		logger.error("에러");
	}
}
