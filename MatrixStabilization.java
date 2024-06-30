import java.util.Scanner;

public class MatrixStabilization {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        while (t > 0) {
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            scan.nextLine();

            int[][] ans = stabilizingMatrix(scan, n, m);

            StringBuilder stabilizedMatrix = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    stabilizedMatrix.append(ans[i][j] + " ");
                stabilizedMatrix.append("\n");
            }
            System.out.print(stabilizedMatrix.toString());
        }
        scan.close();
    }

    private static int[][] stabilizingMatrix(Scanner scan, int n, int m) {
        int[][] matrixToStabilize = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                matrixToStabilize[i][j] = scan.nextInt();
            scan.nextLine();
        }
        return applyStabilizationAlgorithm(matrixToStabilize, n, m);
    }

    private static int[][] applyStabilizationAlgorithm(int[][] arr, int n, int m) {
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (isTheBigOne(arr, n, m, j, i)) {
                    arr[i][j] = getNextBigOne(arr, n, m, j, i);
                }
            }
        }
        return arr;
    }

    private static boolean hasUpstairsNeighbor(int i) {
        return i - 1 >= 0;
    }

    private static boolean hasDownstairsNeighbor(int i, int n) {
        return i + 1 < n;
    }

    private static boolean hasLeftSideNeighbor(int j) {
        return j - 1 >= 0;
    }

    private static boolean hasRightSideNeighbor(int j, int m) {
        return j + 1 < m;
    }

    private static int getUpstairsNeighbor(int[][] arr, int i, int j) {
        return arr[i - 1][j];
    }

    private static int getDownstairsNeighbor(int[][] arr, int i, int j) {
        return arr[i + 1][j];
    }

    private static int getLeftSideNeighbor(int[][] arr, int i, int j) {
        return arr[i][j - 1];
    }

    private static int getRightSideNeighbor(int[][] arr, int i, int j) {
        return arr[i][j + 1];
    }

    private static boolean isTheBigOne(int[][] arr, int n, int m, int j, int i) {
        boolean theBigOne = true;

        if (hasRightSideNeighbor(j, m))
            theBigOne &= getRightSideNeighbor(arr, i, j) < arr[i][j];

        if (hasLeftSideNeighbor(j))
            theBigOne &= getLeftSideNeighbor(arr, i, j) < arr[i][j];

        if (hasUpstairsNeighbor(i))
            theBigOne &= getUpstairsNeighbor(arr, i, j) < arr[i][j];

        if (hasDownstairsNeighbor(i, n))
            theBigOne &= getDownstairsNeighbor(arr, i, j) < arr[i][j];

        return theBigOne;
    }

    private static int getNextBigOne(int[][] arr, int n, int m, int j, int i) {
        int max = Integer.MIN_VALUE;

        if (hasRightSideNeighbor(j, m)) {
            int guy = getRightSideNeighbor(arr, i, j);
            if (guy > max)
                max = guy;
        }

        if (hasLeftSideNeighbor(j)) {
            int guy = getLeftSideNeighbor(arr, i, j);
            if (guy > max)
                max = guy;
        }

        if (hasUpstairsNeighbor(i)) {
            int guy = getUpstairsNeighbor(arr, i, j);
            if (guy > max)
                max = guy;
        }

        if (hasDownstairsNeighbor(i, n)) {
            int guy = getDownstairsNeighbor(arr, i, j);
            if (guy > max)
                max = guy;
        }

        return max;
    }
}
