import static org.junit.Assert.*;

import org.junit.Test;


public class EditDistanceTableTest {
	
	//test setFullTable method - whether auto update works
	@Test
	public void finalValueOfTableShouldAutoUpdate() {
		
		//table to be updated by tested method
		EditDistanceTable testTable = new EditDistanceTable();
		//table which .fullTable field is to be used as parameter of the tested method
		EditDistanceTable parameterTable = EditDistanceCalculator.calculateTable("markup", "intention"); //method calculate table tested elswhere 
		int[][] testParameter = parameterTable.getFullTable();
		
		//call tested method 
		testTable.setFullTable(testParameter);
		
		
		assertEquals("finalValue field of testTable has to be the same as proper entry in FullTable", testParameter[6][9] , testTable.getFinalValue() );
	}

}
