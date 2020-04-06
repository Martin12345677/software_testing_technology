

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class TestBubbleSort {
	
	@Test
	public void test() {
		assertArrayEquals(BubbleSort.BubbleSort(new int[] {2,3,5,2,1,3,0}), new int[] {0,1,2,2,3,3,5});
	}

}
