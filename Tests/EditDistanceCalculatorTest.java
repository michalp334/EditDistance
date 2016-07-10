import static org.junit.Assert.*;

import org.junit.Test;

import editDistanceCalculator.EditDistanceCalculator;
import editDistanceCalculator.EditDistanceTable;

public class EditDistanceCalculatorTest {
	
	EditDistanceCalculator tester = new EditDistanceCalculator();
	
	@Test
	public void testCalculateTable() throws Exception {

		EditDistanceTable testTable = EditDistanceCalculator.calculateTable("lollipop", "lollipop");
		
		assertEquals("final edit distance between identical strings should to be 0", 0, testTable.getFinalValue() );
		
		testTable = EditDistanceCalculator.calculateTable("execution", "intention");
		int[][] testTableArray = testTable.getFullTable();
		
		assertEquals("final edit distance between intention and execution should to be 8", 8, testTable.getFinalValue() ); 
		assertEquals("transformation cost between intent and execut should to be 8", 8, testTableArray[6][6] ); //test middle entries of table
		
		testTable = EditDistanceCalculator.calculateTable("mark", "a");
		
		assertEquals("final edit distance between mark and a should to be 3", 3, testTable.getFinalValue() );
	}
}




