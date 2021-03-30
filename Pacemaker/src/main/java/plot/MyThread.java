package plot;

import com.fazecast.jSerialComm.SerialPort;
import org.jfree.data.xy.XYSeries;

import java.util.Scanner;

public class MyThread extends Thread{

    static private SerialPort tacsPort;
    private XYSeries series1;
    private XYSeries series2;

    public MyThread(SerialPort tacsPort,XYSeries series1,XYSeries series2){
        this.tacsPort = tacsPort;
        this.series1 = series1;
        this.series2 = series2;
    }

    @Override
    public void run(){
        System.out.println("Go to thread start!");
        //Scanner scanner = new Scanner(tacsPort.getInputStream());
        tacsPort.addDataListener(new SerialListener(series1,series2,tacsPort));
        System.out.println(Thread.currentThread().getName());

    }

}
