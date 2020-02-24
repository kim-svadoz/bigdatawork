package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest05 {
	public static void main(String[] args) {
		//String str = "tomato jaava tomato prog potato";
		//String patternStr ="(tom|pot)ato";
		
		//String str = "aaaaa aaabc iiiii iiibc aiabc ";
		//String patternStr = "(a|i){3}bc";
		
		String str = "adsf111 a1 b5 b555 aaa5 qa5";
		String patternStr = "([a-z][0-9])"; 
		
		equalsPattern(str, patternStr);
	}
	public static void equalsPattern(String str, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher m = pattern.matcher(str);
		while(m.find()) { // find가 boolean을 리턴하기 때문에 반복작업이 가능
			System.out.println(m.group());
			System.out.println(m.start()+":"+(m.end()-1));
		}
	}
}
