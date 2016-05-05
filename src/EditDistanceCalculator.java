
public class EditDistanceCalculator {
	
	private static final int insertionCost = 1;
	private static final int deletionCost = 1;
	private static final int substitutionCostIfMatch = 0;
	private static final int substitutionCostIfNoMatch = 2;
	
	//print whole table
	public static void printEditDistanceTable (String baseString, String targetString) { 
		
		editDistanceTable  = calculateTable(baseString, targetString);
			
		for(int[] row : editDistanceTable) {
		        FormattedTablePrint.printRow(row);
	    	}

	}
	
	//calculate whole table
	private static int[][] calculateTable (String baseString, String targetString) {
	
		int baseStringLength = baseString.length();
		int targetStringLength = targetString.length();
		
		int [][] editDistanceTable = initializeTable (baseStringLength, targetStringLength);
		
		String[] baseStringArray = baseString.split("");
		String[] targetStringArray = targetString.split("");
		
		/*start with 1 as 0th row and column is already filled by the createBlankTable 
		*/
		for (int i = 1; i<=baseStringLength; i++){  
			
			for (int j = 1; j<=targetStringLength; j++) {		
			
				calculateEditDistance (i,j);
				}	
			}
		return editDistanceTable;
	}
	
	//calculate i-th row and j-th column entry of editDistanceTable
	private static void calculateEditDistance(i, j) { 
		int insertion = editDistanceTable[i-1][j] + insertionCost;  
		int deletion = editDistanceTable[i][j-1] + deletionCost;
			
		//to calculate cost of substitution, check whether the i-th character of both strings match					
		if (baseStringArray[i-1].equals(targetStringArray[j-1])) { //-1 as array indexes start with 0 and our counter starts with 1
		costOfSubstitution = substitutionCostIfMatch;
		}
				
		else {
		costOfSubstitution = substitutionCostIfNoMatch;
		}
			
		int substitution = editDistanceTable[i-1][j-1] + costOfSubstitution;
						
		editDistanceTable[i][j] = min(insertion, deletion, substitution);
	}
	
	
	private static int min(int a, int b, int c) {
	    return Math.min(Math.min(a, b), c);
	}
	
	
	//create edit distance table with initalization values in 0-th row and column
	private static int[][]  initializeTable (int baseStringLength, int targetStringLength ) { 

		int [][] editDistanceTable;
		editDistanceTable = new int[baseStringLength+1][targetStringLength+1]; //+1 because of 0-th row and column
		
		for (int i = 0; i<=baseStringLength; i++) {
			editDistanceTable[i][0] = i;
		}
		
		for (int i = 0; i<=targetStringLength; i++) {
			editDistanceTable[0][i] = i;
		}
	
		return editDistanceTable;
		
	}


	public static void main(String[] args) {
			
			
			int[][] editDistanceTable = EditDistanceCalculator.calculateTable ("execution", "intention");
			
		
			
		}


}

