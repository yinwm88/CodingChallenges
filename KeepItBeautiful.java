import java.util.*;

public class KeepItBeautiful {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t > 0) {
            t--;
            int q = scan.nextInt();
            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = scan.nextInt();
            }
            System.out.println(processQueries(q, queries));
        }
        scan.close();
    }

    private static String processQueries(int q, int[] queries) {
        StringBuilder result = new StringBuilder();
        int min = 0, firstQuery;
        firstQuery = queries[0];
        int aux = 0;
        for(int i = 1 ; i<queries.length; i++){
            result.append("1");
            aux = i;
            if(queries[i]<firstQuery){
                min = queries[i];
                break;
            }
        }
        
        while(aux < queries.length){
            if(min<=queries[aux] && queries[aux]<=firstQuery){
                result.append("1");  
            }else{
                result.append("0");  
            }
            aux++;
        }
        return result.toString();
    }

    
}
