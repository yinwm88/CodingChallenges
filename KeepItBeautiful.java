import java.util.*;

public class KeepItBeautiful {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        while (t > 0) {
            t--;
            System.out.println(keepItBeautiful(scan));
        }
        scan.close();
    }

    private static String keepItBeautiful(Scanner scan) {
        StringBuilder result = new StringBuilder();
        int min=0, x=0;
        int q = scan.nextInt()-1;
        int firstQuery = scan.nextInt();
        result.append("1");  
        while(q>0){
            q--;
            //aux = i;
            x = scan.nextInt();
            result.append("1");
            if(x<firstQuery){
                min = x;
                break;
            }
        }
        while(q>0){
            q--;
            x = scan.nextInt();
            if(min<=x && x<=firstQuery){
                result.append("1");  
            }else{
                result.append("0");  
            }
        }
        return result.toString();
    }
}
