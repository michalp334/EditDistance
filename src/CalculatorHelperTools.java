//collection of useful universal methods
public class CalculatorHelperTools {

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    public static int min(int a, int b, int c) {
	    return Math.min(Math.min(a, b), c);
	}

   
}
