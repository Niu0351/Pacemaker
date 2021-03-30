package plot;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.jfree.data.xy.XYSeries;
import org.junit.jupiter.api.Test;
import utils.WebUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class SerialListener implements SerialPortDataListener {
    private XYSeries series1;
    private XYSeries series2;
    static int x = 0;
    static int y = 0;
    static SerialPort tacsPort;
    final static Integer OFFSET = 1000;

    public SerialListener(XYSeries series1, XYSeries series2, SerialPort tacsPort) {
        this.series1 = series1;
        this.series2 = series2;
        this.tacsPort = tacsPort;
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }


    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        System.out.println("in serialEvent");
        if (serialPortEvent.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
            return;
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(serialPortEvent.getSerialPort().getSystemPortName());

//        ArrayList<String> ventricular = new ArrayList<>();
//        ArrayList<String> atrium = new ArrayList<>();
        byte[] ventricularBytes = new byte[8];
        byte[] atriumBytes = new byte[8];
        ArrayList<String> end = new ArrayList<>();
        byte[] totalBytes = new byte[18];
        System.out.println(tacsPort.bytesAvailable() == 18);
        if (tacsPort.bytesAvailable() == 18) {
            tacsPort.readBytes(totalBytes, 18);
            System.out.println("totalBytes:" + totalBytes.length);

            for (int i = 0; i < 18; i++) {
                if (i < 8) {
//                    atrium.add(WebUtils.getBits(totalBytes[i]));
                    atriumBytes[i] = totalBytes[i];
                } else if (i < 16) {
                    //ventricular.add(WebUtils.getBits(totalBytes[i]));
                    ventricularBytes[i - 8] = totalBytes[i];
                } else {
                    end.add(WebUtils.getBits(totalBytes[i]));
                }
            }
//            ArrayList<Integer> atriumInteger = new ArrayList<>();
//            ArrayList<Integer> ventricularInteger = new ArrayList<>();
//            for(int i = 0; i < 8;i++){
//                atriumInteger.add(Integer.parseInt(atrium.get(i),2));
//                ventricularInteger.add(Integer.parseInt(ventricular.get(i),2));
//            }
            double atriumDouble = ByteBuffer.wrap(atriumBytes).getDouble();
            double ventricularDouble = ByteBuffer.wrap(ventricularBytes).getDouble();
//            for (int i = 0; i < 8; i++) {
//                System.out.println("atrium Data:" + atriumInteger.get(i));
//                System.out.println("ventricular Data:"+ventricularInteger.get(i));
//                series1.add(x, atriumInteger.get(i));
//                series2.add(y, ventricularInteger.get(i));
//                x+=OFFSET;
//                y+=OFFSET;
//            }
            System.out.println("atrium Data:" + atriumDouble);
            System.out.println("ventricular Data:" + ventricularDouble);
            series1.add(x, atriumDouble);
            series2.add(y, ventricularDouble);
            x += OFFSET;
            y += OFFSET;
            System.out.println("end data:" + end.get(0) + "" + end.get(1));
        }
    }

}
