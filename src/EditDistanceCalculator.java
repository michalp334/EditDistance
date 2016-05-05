
public class EditDistanceCalculator {
	
	private static final int insertionCost = 1;
	private static final int deletionCost = 1;
	private static final int substitutionCostIfMatch = 0;
	private static final int substitutionCostIfNoMatch = 2;
	
	public static void printEditDistance (String baseString, String targetString) { //print only final value
		
		editDistanceTable  = calculateTable(baseString, targetString);
		
	}
	
	public static void printEditDistanceTable (String baseString, String targetString) { //print whole table
		
		editDistanceTable  = calculateTable(baseString, targetString);
			
		for(int[] row : editDistanceTable) {
		        FormattedTablePrint.printRow(row);
	    	}

	}
	
	private static int[][] calculateTable (String baseString, String targetString) {//transformation = insertion or deletion or substitution
	
		
		int baseStringLength = baseString.length();
		int targetStringLength = targetString.length();
		
		
		int [][] editDistanceTable = createBlankTable (baseStringLength, targetStringLength);
		
		String[] baseStringArray = baseString.split("");
		String[] targetStringArray = targetString.split("");
		
			/*start with 1 as 0th row and column is already filled by the createBlankTable 
			*/
			for (int i = 1; i<=baseStringLength; i++){  
				
					for (int j = 1; j<=targetStringLength; j++) {		
					
						calculateEditDistance (i,j);
					}	
			}
		int editDistanceFinalValue
		return editDistanceTable;
	}
	
	private static void calculateEditDistance(i, j) { //calculate i-th row and j-th column entry of editDistanceTable
		int insertion = editDistanceTable[i-1][j] + insertionCost;  
		int deletion = editDistanceTable[i][j-1] + deletionCost;
							
			//-1 as array indexes start with 0 and our counter starts with 1
			if (baseStringArray[i-1].equals(targetStringArray[j-1])) {
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
	
	
	
	private static int[][]  createBlankTable (int baseStringLength, int targetStringLength ) { //initializa edit distance table

		int [][] editDistanceTable;
		// +1, as the 0th row and column is for the initialization values from blank table
		// if the string has 9 letters, the table has to be of size 10
		editDistanceTable = new int[baseStringLength+1][targetStringLength+1]; 
		
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

