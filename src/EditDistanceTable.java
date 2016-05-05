
public class EditDistanceTable {
	
	private int[][] fullTable;
	private int finalValue;
	
	
	public void setFullTable(int[][] table) {
		this.fullTable = table;
		int maxRowIndex = table.length-1; //-1 because of 0-th index
		int maxColumnIndex = table[1].length-1; //-1 because of 0-th index	
		
		//auto-update finalValue as it's strictly connected with the whole table
		this.finalValue = table[maxRowIndex][maxColumnIndex]; 
	}
	
	
	public int[][] getFullTable() {
		return this.fullTable;
	}
	
	public int getFinalValue() {
		return this.finalValue;
	}
	
	//print whole table
		public void printTable() { 
			
			int[][] tempTable = this.fullTable;
				
			for(int[] row : tempTable) {
			        Methods.printRow(row);
		    	}

		}
	
}
