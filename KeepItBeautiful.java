import java.util.Scanner;

public class KeepItBeautiful {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t > 0) {
            System.out.println(keepItBeautiful(scan));
            t--;
        }
        scan.close();
    }

    private static String keepItBeautiful(Scanner scan) {
        StringBuilder result = new StringBuilder();
        int q = scan.nextInt();
        int[] arr = new int[q];
        
        for (int i = 0; i < q; i++) {
            arr[i] = scan.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int first = arr[0];
        boolean flag = true;

        for (int i = 0; i < q; i++) {
            int x = arr[i];
            if (flag) {
                if (x >= max) {
                    max = x;
                    result.append("1");
                } else if (x <= first) {
                    min = x;
                    result.append("1");
                    flag = false;
                } else {
                    result.append("0");
                }
            } else {
                if (x >= min && x <= first) {
                    min = x;
                    result.append("1");
                } else {
                    result.append("0");
                }
            }
        }
        return result.toString();
    }
}
