package ex1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MoneyTest {
	private int input;
	private boolean expected;
	private Money money = null;
	
	public MoneyTest(int input, boolean excepted) {
		this.input = input;
		this.expected = excepted;
	}
	
	@Before
	public void setUp() {
		money = new Money();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][] {
			{0, true},
			{1000, false},
			{93, true},
			{94, false},
			{92, true},
			{88, true},
			{89, false}
		});
	}
	
	@Test
	public void test() {
		assertEquals(this.expected, money.hasMoney(this.input));
	}
}
