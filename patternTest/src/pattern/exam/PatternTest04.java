package pattern.exam;
import java.util.regex.Pattern;

public class PatternTest04 {
	public static void main(String[] args) {
		System.out.println(Pattern.matches("[0-9]+", "1234java"));  //f
		System.out.println(Pattern.matches("[0-9]+", "java"));		//f
		System.out.println(Pattern.matches("[0-9]+", "1234"));		//t
		System.out.println(Pattern.matches("[0-9]+", "1"));			//t
		System.out.println(Pattern.matches("[0-9]+", " "));			//f
		
		System.out.println(Pattern.matches("[0-9]?", "1234java"));  //f
		System.out.println(Pattern.matches("[0-9]?", "java"));		//f
		System.out.println(Pattern.matches("[0-9]?", "1234"));		//f
		System.out.println(Pattern.matches("[0-9]?", "1"));			//t
		System.out.println(Pattern.matches("[0-9]?", " "));			//f
	}
}
