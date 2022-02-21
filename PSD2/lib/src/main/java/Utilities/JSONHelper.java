package Utilities;

public class JSONHelper {
	public static String createStringAttribute(String attr, String value) {
		return "\"" + attr + "\": \"" + value + "\"\n";
	}
}
