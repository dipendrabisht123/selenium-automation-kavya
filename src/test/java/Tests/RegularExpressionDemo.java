package Tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class RegularExpressionDemo {

	@Test
	  public void regEx() {
		
		String sAlphaNumaric = "abcddddEEEfg12355@@@ijk";
		
		System.out.println(sAlphaNumaric.replaceAll("[abc]", "X"));
		System.out.println(sAlphaNumaric.replaceAll("[^ac]", "X"));
		
		
		System.out.println(sAlphaNumaric.replaceAll("[a-z0-9]", "X"));
		
		System.out.println(sAlphaNumaric.replaceAll("(?i)[a-z0-9]", "X"));
		
		System.out.println(sAlphaNumaric.replaceAll("[acf][dg]", "X"));
		
		String str = "Hi, my name is Dipendra";
		String[] arr = str.split(" ");
		
		for (String a : arr){
			System.out.println(a);
		}
		
		/*System.out.println(sAlphaNumaric.replaceAll("[^0-9]", "X"));
		
		System.out.println(sAlphaNumaric.replaceAll(".", "X"));
		System.out.println(sAlphaNumaric.replaceAll("\\w", "X"));
		System.out.println(sAlphaNumaric.replaceAll("\\W", "X"));
		
		System.out.println(sAlphaNumaric.replaceAll("\\d", "X"));
		
		System.out.println(sAlphaNumaric.replaceAll("abcd{2}", "X"));
		
		
		sAlphaNumaric = "abcddddEEEfg123abc55ijkabc";
		
		System.out.println(sAlphaNumaric.replaceAll("abc", "-"));
		System.out.println(sAlphaNumaric.replaceAll("^abc", "-"));
		System.out.println(sAlphaNumaric.replaceAll("abc$", "-"));
		System.out.println(sAlphaNumaric.replaceAll("[^abc]", "-"));
		
		
		Pattern pattern = Pattern.compile("[\\w]+");
		Matcher matcher = pattern.matcher(sAlphaNumaric);
				
		System.out.println(matcher.matches());*/
		
//		System.out.println(matcher.find());
		
		
	}
	
}
