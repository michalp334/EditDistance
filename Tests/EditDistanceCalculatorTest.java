import static org.junit.Assert.*;

import org.junit.Test;

public class EditDistanceCalculatorTest {
	
	EditDistanceCalculator tester = new EditDistanceCalculator();
	
	@Test
	public void testCalculateTable() throws Exception {

		EditDistanceTable table = EditDistanceCalculator.calculateTable("lollipop", "lollipop");
		int[][] testTable = table.getFullTable();
		
		assertEquals("final edit distance between identical strings should to be 0", 0, testTable.getFinalValue() );
		
		table = EditDistanceCalculator.calculateTable("execution", "intention");
		testTable = table.getFullTable();
		
		assertEquals("final edit distance between intention and execution should to be 8", 8, testTable.getFinalValue() ); 
		assertEquals("transformation cost between intent and execut should to be 8", 8, testTable[6][6] ); //test middle entries of table
		
		table = EditDistanceCalculator.calculateTable("mark", "a");
		testTable = table.getFullTable();
		
		assertEquals("final edit distance between mark and a should to be 3", 3, testTable.getFinalValue() );
	}
}




