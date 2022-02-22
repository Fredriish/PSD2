package Utilities;

public class JSONHelper {
	public static String createStringAttribute(String attr, String value, boolean useComma) {
		String line = "\"" + attr + "\": \"" + value + "\"";
		if(useComma)
			line+=",";
		line += "\n";
		return line;
	}
	
}
