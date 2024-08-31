import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;


public class EveryoneLovesToSleep{
    private static class Pair implements Comparable<Pair>{
        private int hour;
        private int min;

        public Pair(int hour, int min){
            this.hour = hour;
            this.min = min;
        }

        public int getHour(){
            return hour;
        }

        public int getMin(){
            return min;
        }

        public void setHour(int newH){
            hour = newH;
        }

        public void setMin(int newM){
            min = newM;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.hour != other.hour) {
                return this.hour - other.hour;
            }
            return this.min - other.min;
        }

        public boolean equals(Pair other) {
            return (this.hour == other.hour) && (this.min == other.min) ;
        }

        @Override
        public String toString(){
            return hour + " " + min;
        }
        
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i<t; i++){
            int alarms = scan.nextInt();
            int h = scan.nextInt();
            int min = scan.nextInt();
            Pair timeToSleep = new Pair(h, min);
            System.out.println(vladWillSleep(scan, alarms, timeToSleep));
        }
        scan.close();
    }

    private static String vladWillSleep(Scanner scan, int alarms , Pair timeToSleep){
        PriorityQueue<Pair> mh = new PriorityQueue<>(); 
        for(int i = 0; i<alarms; i++){
            int hourAlarm = scan.nextInt();
            int minAlarm = scan.nextInt();
            Pair nextAlarm = new Pair(hourAlarm, minAlarm);
            mh.add(getDifferenceBetween(nextAlarm, timeToSleep));
        }
        return (mh.poll()).toString();
    }

    private static Pair getDifferenceBetween(Pair alarm, Pair timeToSleep){
        if(alarm.equals(timeToSleep))return new Pair(0,0);

        if(sameDay(timeToSleep, alarm)){
            return minusPairs(alarm, timeToSleep);
        }   
        else{
            return (plusPairs(finishDay(timeToSleep),alarm)); 
        } 
    }

    private static boolean sameDay(Pair timeToSleep, Pair alarm){
        return timeToSleep.compareTo(alarm)<0;
    }

    private static Pair finishDay(Pair t){
        int minRemaining = 60 - t.getMin();
        int hoursRemaining = 23 - t.getHour();
        return new Pair(hoursRemaining, minRemaining);  
    }

    private static Pair plusPairs(Pair pair1, Pair pair2){
        int min  = pair1.getMin() + pair2.getMin();
        int h = pair1.getHour() + pair2.getHour(); 
        if (min >= 60) {
            h += 1;
            min -= 60;
        }
        return new Pair(h, min);
    }

    private static Pair minusPairs(Pair bigPair, Pair smallPair){
        int timeH = bigPair.getHour() - smallPair.getHour();
        int timeM = bigPair.getMin() - smallPair.getMin();
        if(timeM<0){
            timeH--;
            timeM += 60;
        }
        return  new Pair(timeH, timeM);
    }


}