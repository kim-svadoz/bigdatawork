package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest03 {
	public static void main(String[] args) {
		//String str = "jaava programmaingm";
		//String str ="-@-ja1- -111aCva--@@-@@@@- 한글 --@@@@-- progra44568EmgFmiJng";
		String str = "a 4 m 7 v 9  amJAVA _java aaaxl  programming and spring , hadoop";
		//String patternStr = ".*";		// 모든 것
		//String patternStr = "-@+-";	// -- 사이에 @이 1개 있거낭 여러개 있거나
		//String patternStr = "-@?-";	// -- 사이에 @이 없거나 1개 있거나
		//String patternStr = "[^ ]";	// 공백이 아닌 문지
		//String patternStr = ".{5}";	// 다섯 글짜식 끊어서 출력
		//String patternStr = "[amv]{1,3}"; // a,m,v가 1회,2회,3회인 문자, a, m, v, aa, am, av, mv,....
		//String patternStr = "[a-z]{3,}"; // a-z까지 3글자 이상의 문자
		//String patternStr = "\\W"; // 대문자, 소문자, 숫자 뺀 모두
		//String patternStr = "\\w"; // 대문자, 소문자, 숫자 모두
		//String patternStr = "\\d"; // 숫자만
		String patternStr = "\\D"; 	// 숫자를 뺀 나머지
		
		equalsPattern(str, patternStr);
	}
	public static void equalsPattern(String str, String patternStr) {
		//1. 패턴을 인식
		Pattern pattern = Pattern.compile(patternStr);
		//2. 패턴 적용하며 문자열을 관리
		Matcher m = pattern.matcher(str);
		/*System.out.println(m.find());
		System.out.println(m.start());
		System.out.println(m.end());
		System.out.println(m.group());*/
		
		while(m.find()) { // find가 boolean을 리턴하기 때문에 반복작업이 가능
			System.out.println(m.group());
			System.out.println(m.start()+":"+(m.end()-1));
		}
	}
}
