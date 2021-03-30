package plot;

import com.fazecast.jSerialComm.SerialPort;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private JButton connectButton;
    private JComboBox<String> portList;
    private XYSeries series1;
    private XYSeries series2;
    static private SerialPort tacsPort;

    public MyActionListener(JButton connectButton, JComboBox<String> portList, XYSeries series1, XYSeries series2, SerialPort tacsPort) {
        this.connectButton = connectButton;
        this.portList = portList;
        this.series1 = series1;
        this.series2 = series2;
        this.tacsPort = tacsPort;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(SerialPort.getCommPort(portList.getSelectedItem().toString()).getSystemPortName().equals(tacsPort.getSystemPortName())){
            if (connectButton.getText().equals(("Connect"))) {
                //tacsPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0,0);
                System.out.println("getPlot Open port:" + tacsPort.getSystemPortName());
                if (tacsPort.openPort()) {
                    connectButton.setText("Disconnect");
                    portList.setEnabled(false);
                }
                Thread thread1 = new MyThread(tacsPort,series1,series2);
                byte[] writeBytes = new byte[]{0x16, 0x47, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
                tacsPort.writeBytes(writeBytes, 20);
                for (byte i : writeBytes) {
                    System.out.println("sendData:" + i);
                }

                thread1.start();
                //thread2.start();

            } else {
                tacsPort.closePort();
                System.out.println("disconnect from port"+tacsPort.getSystemPortName());
                portList.setEnabled(true);
                connectButton.setText("Connect");
            }
        }

    }
}
