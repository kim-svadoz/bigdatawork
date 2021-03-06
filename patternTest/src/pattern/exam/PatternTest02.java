package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest02 {
	public static void main(String[] args) {
		//String str = "jaava programmaingm";
		String str ="ja1111aCva--@@-@@@@- 한글 --@@@@-- progra44568EmgFmiJng";
		//String patternStr = "a|m|g";		// 1. |는 or을 의미 => a이거나 m이거나 g인 문자
		//String patternStr = "[amg]";		// 2. 1번과 동일
		//String patternStr = "[amg][ma]";	// 3. 두 글자에 대해서 2번의 조건이 적용 
											//	=> 첫글자가 a,m,g거나 두번째 글자가 m,a인 문자
		//String patternStr = "[c-j]";		// 4. 알파벳 c-j사이에 해당하는 문자
		//String patternStr = "[C-J]";		// 5. 대문자
		//String patternStr = "[C-Jc-j]";	// 6. 대문자 C,J 소문자c에서 j까지 문자
		//String patternStr = "[4-8]";		// 7. 숫자 4-8사이에 해당하는 문자
		//String patternStr = "[^4-8]";		// 8. ^가 []안에 있으면 부정의 의미. => 숫자 4,5,6,7,8이 아닌 문자
		
		//ex1) c~j사이의 영문자가 아닌 것
		//String patternStr = "[^c-j]";
		//ex2) 영문자와 숫자만 추출
		//String patternStr ="[A-Za-z0-9]"; 
		//ex3) 영문자와 숫자를 뺀 나머지 문자만 추출
		//String patternStr = "[^A-Za-z0-9]";
		//ex4) 한글만 추출
		String patternStr = "[가-힣]";
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
