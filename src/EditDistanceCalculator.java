
public class EditDistanceCalculator {
	
	private static final int insertionCost = 1;
	private static final int deletionCost = 1;
	private static final int substitutionCostIfMatch = 0;
	private static final int substitutionCostIfNoMatch = 2;
	
	
	//
	public static int calculateFinalEditDistance (String baseString, String targetString) {
		
		EditDistanceTable table = calculateTable(baseString, targetString);
		int finalValue = table.getFinalValue();
		return finalValue;
	}
	
	public static EditDistanceTable calculateTable (String baseString, String targetString) {
	
		int baseStringLength = baseString.length();
		int targetStringLength = targetString.length();
		
		EditDistanceTable table = initializeTable (baseStringLength, targetStringLength);
		
		String[] baseStringArray = baseString.split("");
		String[] targetStringArray = targetString.split("");
		
		/*start with 1 as 0th row and column is already filled by the createBlankTable 
		*/
		for (int i = 1; i<=baseStringLength; i++){  
			
			for (int j = 1; j<=targetStringLength; j++) {		
			
				calculateEditDistance (table, baseStringArray, targetStringArray, i,j);
				}	
			}
		return table;
	}
	
	//calculate i-th row and j-th column entry of editDistanceTable
	private static void calculateEditDistance(EditDistanceTable table, String[] baseStringArray, String[] targetStringArray, int i,int j) { 
		
		int[][] tempTable = table.getFullTable();
		int insertion = tempTable[i-1][j] + insertionCost;  
		int deletion = tempTable[i][j-1] + deletionCost;
		
		int costOfSubstitution;
		//to calculate cost of substitution, check whether the i-th character of both strings match					
		if (baseStringArray[i-1].equals(targetStringArray[j-1])) { //-1 as array indexes start with 0 and our counter starts with 1
		costOfSubstitution = substitutionCostIfMatch;
		}
				
		else {
		costOfSubstitution = substitutionCostIfNoMatch;
		}
			
		int substitution = tempTable[i-1][j-1] + costOfSubstitution;
						
		tempTable[i][j] = Methods.min(insertion, deletion, substitution);
		
		table.setFullTable(tempTable);
	}
	
	
	
	//create edit distance table with initalization values in 0-th row and column
	private static EditDistanceTable  initializeTable (int baseStringLength, int targetStringLength ) { 

		EditDistanceTable table = new EditDistanceTable();
		
		int[][] tempTable = new int[baseStringLength+1][targetStringLength+1]; //+1 because of 0-th row and column
		
		for (int i = 0; i<=baseStringLength; i++) {
			tempTable[i][0] = i;
		}
		
		for (int i = 0; i<=targetStringLength; i++) {
			tempTable[0][i] = i;
		}
		table.setFullTable (tempTable);
		return table;
		
	}


	public static void main(String[] args) {
			
			
		
			EditDistanceTable table = calculateTable("execution", "intention");
			table.printTable();
			
		}


}

