import java.util.Scanner;

public class PaintingTheRibbon{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            scan.nextLine();
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            System.out.println(paintingTheRibbon(n, m, k));
            t--;
        }
        scan.close();
    }

    private static String paintingTheRibbon(int n, int m, int k){
        if(n == 1 || m == 1 || k >= n || (n==m)&&((k+1) == m) || (k==(n-1))){
            return "NO";
        }else{
            if((k >= (n/m)) && ((n%m)==0 && m==2))return "NO";
            int fmin = n/m;
            int fmax = fmin;
            if((n%m)!=0){   
                fmax = fmin + 1;
            }
            int nMaxf = n%m;
            int nMinf = n - (nMaxf*fmax);
            int min = nMinf + ((nMaxf*fmax)-fmax);
            if(k>=min)return "NO";
            return "YES";
        }
    }

}