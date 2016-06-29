
public class EditDistanceTable {
	
	private int[][] fullTable;
	
	public void setFullTable(int[][] table) {
		this.fullTable = table;
	}
	
	
	public int[][] getFullTable() {
		return this.fullTable;
	}
	
	public int getFinalValue() {
		int maxRowIndex = this.fullTable.length-1; //-1 because of 0-th index
		int maxColumnIndex = this.fullTable[1].length-1; //-1 because of 0-th index	
		return this.fullTable[maxRowIndex][maxColumnIndex];
	}
	
	//print whole table
		public void printTable() { 
			
			int[][] tempTable = this.fullTable;
				
			for(int[] row : tempTable) {
			        Methods.printRow(row);
		    	}

		}
	
}
