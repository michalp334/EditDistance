import static org.junit.Assert.*;

import org.junit.Test;

public class EditDistanceCalculatorTest {
	
	@Test
	public void testCalculateTable() throws Exception {

		int[][] testTable = EditDistanceCalculator.calculateTable("execution", "execution");
		
		assertEquals("final edit distance between execution and execution has to be 0", 0, testTable[9][9] );
		
		testTable = EditDistanceCalculator.calculateTable("intention", "execution");
		
		assertEquals("final edit distance between intention and execution has to be 8", 8, testTable[9][9] ); 
		assertEquals("transformation cost between intent and execut has to be 8", 8, testTable[6][6] ); 
	}
}




