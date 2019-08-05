package log.check;

public class Log4J {
	
	private static Log4J instance = new Log4J();
	
	private Log4J(){};
	
	public static Log4J getInstance() {
		return instance;
	}
	
	public String info() {
		return "안녕하세요";
	}
	
	public String done() {
		return "실행되었습니다.";
	}
	
	public String error() {
		return "에러가 발생했습니다.";
	}
	
	public String empty() {
		return "데이터가 존재하지 않습니다.";
	}
	

}
