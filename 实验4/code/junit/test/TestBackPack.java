

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
//import java.util.Arrays;
//import java.util.Collection;import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class TestBackPack {
	
//	private int m, n;
//	private int [] w, p;
//	private int [][] expected;
	
//	
//	public TestBackPack(int m, int n, int[] w, int[] p, int[][] expected) {
//		this.m = m;
//		this.n = n;
//		this.w = w;
//		this.p = p;
//		this.expected = expected;
//	}
	
	@Test
	public void test() {
		assertArrayEquals(new int[][] {{0, 0}, {0, 10}}, BackPack.BackPack_Solution(1,1,new int[] {1}, new int[] {10}));
//		assertArrayEquals(new Object[] {0},new Object[] {0});
	}
	
//	@Parameters
//	public static Collection<Object[]> getData(){
//			
//		return Arrays.asList(new Object[][]{
//			{1,1,new int[] {1}, new int[] {10}, new int[][] {{0, 0}, {0, 10}}},
//			{1,1,new int[] {2}, new int[] {10}, new int[][] {{0, 0}, {0, 0}}}
//		});
//	}

}
