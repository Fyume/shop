package junit.test;

import java.util.Calendar;

import org.junit.Test;

public class TimeTest {
	@Test
	public void time(){
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日"+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
	}
}
