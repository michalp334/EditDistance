
public class FormattedTablePrint {

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    
   

    public static void main(String[] args) {
        /*int twoDm[][]= new int[10][];
        int i,j,k=1;

        for(i=0;i<10;i++) {
            for(j=0;j<10;j++) {
                twoDm[i][j]=k;
                k++;
            }
        }

        for(int[] row : twoDm) {
            printRow(row);
        }*/
    }
}