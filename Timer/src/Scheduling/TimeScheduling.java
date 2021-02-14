package Scheduling;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Operation1 extends TimerTask {
long hours;
    public Operation1 (long hours) {
        this.hours = hours;
    }
    public Operation1(){}
    public long calcAndGet() {
        hours = hours*1000*3600;
        return hours;
    }
    @Override
    public void run() {
        System.out.println("SomeTask -> 1"); //In diese Methode kommt das ganze Code rein
    }
}
class Operation2 extends TimerTask {
    long hours;
    long days;
    public Operation2 (long days, long hours) {
        this.hours = hours;
        this.days = days;
    }
    public Operation2(){}
    public long calcAndGet() {
        hours = hours*1000*3600;
        days = days * 3600 * 1000 * 24;
        return days+hours;
    }
    @Override
    public void run() {
        System.out.println("That is SomeTask -> 2");
    }
}

public class TimeScheduling {
    public static void main (String [] args) {
        Timer t = new Timer();
        TimerTask simpleTask1 = new Operation1();
        TimerTask simpleTask2 = new Operation2();
        Operation1 task2 = new Operation1(1); //Es gibt eine Möglichkeit die Anzahl von Stunden einzugeben
                                                    //also "Wie oft muss das Programm ausgeführt werden?"
        Operation2 task3 = new Operation2(1,5); //Einmal pro 1 Tag und 5 Stunden ausführen
                                                          //Man kann beliebige Kombinationen einstellen
        //Zum Testen:
        //mehrere Programme gleichzeitig ausführen:
        t.schedule(simpleTask1, 1000, 5000); //das Programm nach 1 Sekunde jede 5 Sekunden ausführen
        t.schedule(simpleTask2, new Date(), 2000); //ab jetzt jede 2 Sekunden ausführen

        //Für ViCon11:
        t.schedule(task2, new Date(), task2.calcAndGet()); //ab jetzt einmal pro Stunde ausführen
        t.schedule(task3, new Date(), task3.calcAndGet()); //ab jetzt einmal pro Tag und 5 Stunden ausf.

        //zum Stoppen die Methode Timer.cancel() verwenden.
    }
}
