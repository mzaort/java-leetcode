package LearnTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegTest {

	@Test
	public void testMatch() {
		System.out.println("12*1*01".matches("0\\d+\\*"));
		Pattern pattern = Pattern.compile("0\\d+");
		Matcher matcher = pattern.matcher("12*1*01*2");
		System.out.println(matcher.find());
	}

	@Test
	public void testFloat() {
		float x = 1f;
		float y = 2f;
		float z = x + y;
		System.out.println(z);
		System.out.println(10.8 % 2);
	}

}
