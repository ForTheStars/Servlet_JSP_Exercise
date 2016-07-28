package code14;
/*
 * 该类没有公开的实例变量，拥有默认是零参数构造器.满足 bean条件
 * 由于该类有个getMessage方法(返回值为String)，还有个setMessage(参数类型为String)。称为该类拥有一个名为message的String属性
 */
public class StringBean {
	private String message = "No message specified";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
