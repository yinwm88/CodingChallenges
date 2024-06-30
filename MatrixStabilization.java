import java.util.Scanner;

public class MatrixStabilization{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        StringBuilder stabilizedMatrix = new StringBuilder();
        while(t>0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            scan.nextLine();

            int[][] ans = stabilizingMatrix(scan, n, m);

            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; i++)
                    stabilizedMatrix.append(ans[i][j]+ " ")   
                stabilizedMatrix.append("\n");
            }
            System.out.println(stabilizedMatrix.toString());
        }
        scan.close();
    }

    private int[][] stabilizingMatrix(Scanner scan, int row, int columns){
        int[][] matrixToStabilize = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; i++)
                matrixToStabilize[i][j] = scan.nextInt();
            scan.nextLine();
        }
        return applyStabilizationAlgorithm(matrixToStabilize);
    }

    private int[][] applyStabilizationAlgorithm(int[][] arr){
        
    }
}