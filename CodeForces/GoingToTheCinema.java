import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GoingToTheCinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t > 0) {
            t--;
            int n = scan.nextInt();
            List<Integer> people = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                people.add(scan.nextInt());
            }
            System.out.println(chooseSetPeople(people, n));
        }
        scan.close();
    }

    private static int chooseSetPeople(List<Integer> people, int n) {
        Collections.sort(people);

        int go = countZeros(people);

        int[] pG = convertListToArray(people);

        int sets = 0;

        //significa que si hay ceros, y entonces ese cuenta como un conjunto
        if(go!=0) sets = 1 ;
        
        int realPeople = go; //lleva la cuenta de las personas ue si van
        int ghost = 0; //lleva la cuenta de los cupos que faltan por llenar
        int i = 0;

        while (i < (n-go)) {
            System.out.println("entro while 1");
            if (pG[i] < realPeople) {
                realPeople++;
                i++;
            } else {
                ghost = pG[i] - realPeople;
                realPeople++;
                i++;
            }
            
            while (ghost != 0 ) {
                if (go > n) return sets;
                if ((i<n) || (i-1>=0) && (pG[i - 1] == pG[i])) {
                    ghost--;
                    realPeople++;
                    i++;
                    sets++;
                } else {
                    ghost--;
                    if (i < n) ghost += pG[i] - realPeople;
                    realPeople++;
                    if (ghost != 0)go++;
                    i++;
                }
            }
        }
        return sets;
    }

    private static int countZeros(List<Integer> list) {
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)!=0)return ans;
            ans++;
        }
        return ans;
    }

    private static int[] convertListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)!=0) arr[i] = list.get(i);
        }
        return arr;
    }
}
