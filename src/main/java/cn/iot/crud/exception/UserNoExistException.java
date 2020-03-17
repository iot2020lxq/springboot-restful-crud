package cn.iot.crud.exception;

public class UserNoExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNoExistException() {
		super("用户不存在");
	}
}
