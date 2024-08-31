    import java.util.Collections;
    import java.util.PriorityQueue;
    import java.util.Scanner;

    public class ChessForThree{

        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();

            for(int i=0; i<t; i++){
                int p1 = scan.nextInt();
                int p2 = scan.nextInt();
                int p3 = scan.nextInt();
                System.out.println(calculateDraws(p1,p2,p3));
            }
            scan.close();
        }

        private static int calculateDraws(int p1, int p2, int p3){
            if ((p1 + p2 + p3) % 2 != 0) return -1;

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
            maxHeap.add(p1);
            maxHeap.add(p2);
            maxHeap.add(p3);

            int draws = 0;

            while(maxHeap.size()>1){
                int max1 = maxHeap.poll();
                int max2 = maxHeap.poll();
                int max3 = maxHeap.poll();

                if(max3 == 0 &&  max2 == 0){
                    break;
                }else{
                    draws++;
                    maxHeap.add(--max1);
                    maxHeap.add(--max2);
                    maxHeap.add(max3);
                }
            }
            return draws;
        }
    }