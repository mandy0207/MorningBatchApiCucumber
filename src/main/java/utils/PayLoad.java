package utils;

public class PayLoad {

	
	public static String deleteBookPayLoad(String id) {
		return "{\r\n"
				+ "\"ID\":\""+id+"\"\r\n"
				+ "}";
	}
}
