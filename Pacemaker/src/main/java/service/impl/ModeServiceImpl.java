package service.impl;

import com.fazecast.jSerialComm.SerialPort;
import dao.ModeDao;
import dao.impl.ModeDaoImpl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.jupiter.api.Test;
import plot.MyActionListener;
import plot.MyThread;
import pojo.Mode;
import service.ModeService;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ModeServiceImpl implements ModeService {

    ModeDao modeDao = new ModeDaoImpl();
    static SerialPort tacsPort;

    public SerialPort getPort(){
        return tacsPort;
    }

    @Override
    public int saveMode(Mode mode) {
       return modeDao.saveMode(mode);
    }

    public SerialPort openPort(){

        SerialPort[] commPorts = SerialPort.getCommPorts();
        for (SerialPort port: commPorts){
            System.out.println(port.getSystemPortName());
            if (tacsPort==null && port.getDescriptivePortName().contains("COM3")){
                tacsPort = port;
            }
        }
        tacsPort.setComPortParameters(115200, 8, 1, SerialPort.NO_PARITY);
        tacsPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        System.out.println("Port has been selected");
        return tacsPort;
    }

    public void closePort(SerialPort port){
        port.closePort();
        System.out.println("Port has been closed");
    }

    @Override
    public void transmitModeParameter(Mode mode,SerialPort tacsPort) {
        tacsPort.openPort();
        System.out.println("transmitModeParameter open port"+tacsPort.getSystemPortName());
        ArrayList<Byte> sendData = new ArrayList<>();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendData.add((byte)0x16);
        sendData.add((byte)0x55);
        if(mode.getMode() .equals("AOO")){
            sendData.add((byte)1);
        }
        else if(mode.getMode() .equals("AAI")){
            sendData.add((byte)2);
        }
        else if(mode.getMode().equals("VOO")){
            sendData.add((byte)3);
        }
        else if(mode.getMode().equals("VVI")){
            sendData.add((byte)4);
        }
        else if(mode.getMode().equals("DOO")){
            sendData.add((byte)5);
        }
        else if(mode.getMode().equals("AOOR")){
            sendData.add((byte)6);
        }
        else if(mode.getMode().equals("AAIR")){
            sendData.add((byte)7);
        }
        else if(mode.getMode().equals("VOOR")){
            sendData.add((byte)8);
        }
        else if(mode.getMode().equals("VVIR")){
            sendData.add((byte)9);
        }

        sendData.add(mode.getLRL().byteValueExact());
        sendData.add(mode.getURL().byteValueExact());
        sendData.add(mode.getAA().multiply(new BigDecimal(10)).byteValue());
        sendData.add(mode.getVA().multiply(new BigDecimal(10)).byteValue());
        sendData.add(mode.getAPW().multiply(new BigDecimal(10)).byteValue());
        sendData.add(mode.getVPW().multiply(new BigDecimal(10)).byteValue());
        sendData.add(mode.getVRP().multiply(new BigDecimal(0.1)).byteValue());
        sendData.add(mode.getARP().multiply(new BigDecimal(0.1)).byteValue());
        sendData.add(mode.getMSR().byteValue());
        sendData.add(mode.getFAD().multiply(new BigDecimal(0.1)).byteValue());
        sendData.add(mode.getAS().multiply(new BigDecimal(100)).byteValue());
        sendData.add(mode.getVS().multiply(new BigDecimal(10)).byteValue());
        sendData.add(mode.getPVARP().multiply(new BigDecimal(0.1)).byteValue());
        sendData.add(mode.getAT().byteValue());
        sendData.add(mode.getRT().byteValue());
        sendData.add(mode.getRF().byteValue());
        sendData.add(mode.getRecT().byteValue());
        System.out.println();
        byte[]a;
        for(byte i:sendData){
            a = new byte[]{i};
            tacsPort.writeBytes(a,1);
            System.out.println(i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tacsPort.closePort();
        System.out.println("transmitModeParameter close port"+tacsPort.getSystemPortName());
    }


    public void getEcho(SerialPort tacsPort){
        tacsPort.openPort();
        System.out.println("getEcho Open port:"+tacsPort.getSystemPortName());
        byte[] writeBytes = new byte[]{0x16,0x49,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
        byte[] receiveBytes = new byte[18];
        tacsPort.writeBytes(writeBytes, 20);
        for(byte i: writeBytes){
            System.out.println("sending data:"+i);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ee) {
            ee.printStackTrace();
        }
        tacsPort.readBytes(receiveBytes, 18);
        for(byte i:receiveBytes){
            System.out.println("Echoed mode parameters:"+i);
        }
        tacsPort.closePort();
        System.out.println("getEcho close port:"+tacsPort.getSystemPortName());
    }

    public void stopReceivingData(SerialPort serialPort){
        tacsPort.closePort();
        System.out.println("stopReceivingData close port 1st:"+tacsPort.getSystemPortName());
        tacsPort.openPort();
        System.out.println("stopReceivingData open port:"+tacsPort.getSystemPortName());
        byte[] writeBytes = new byte[]{0x16,0x62,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
        tacsPort.writeBytes(writeBytes,10);
        for(byte i: writeBytes){
            System.out.println("sending data:"+i);
        }
        System.out.println("stop receiving data");
        tacsPort.closePort();
        System.out.println("stopReceivingData close port 2nd:"+tacsPort.getSystemPortName());
    }

    public void getPlot(SerialPort tacsPort){
        //create and configure the window
        JFrame window = new JFrame();
        window.setTitle("Pacemaker Graph GUI");
        window.setSize(1200, 800);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        //
        JComboBox<String> portList = new JComboBox<String>();
        JButton connectButton = new JButton("Connect");
        JPanel topPanel = new JPanel();
        topPanel.add(portList);
        topPanel.add(connectButton);
        mainPanel.add(topPanel);


        SerialPort[] portNames = SerialPort.getCommPorts();
        for (int i = 0; i < portNames.length; i++) {
            portList.addItem(portNames[i].getSystemPortName());
        }

        //create the line graph
        XYSeries series1 = new XYSeries("Pacemaker readings");
        XYSeriesCollection dataset1 = new XYSeriesCollection(series1);
        JFreeChart chart1 = ChartFactory.createXYLineChart("Atrium readings", "Time(ms)", "Voltage(mV)", dataset1, PlotOrientation.VERTICAL, false, false, false);
        //window.add(new ChartPanel(chart1), BorderLayout.BEFORE_LINE_BEGINS);
        mainPanel.add(new ChartPanel(chart1));

        //create the line graph
        XYSeries series2 = new XYSeries("Pacemaker readings");
        XYSeriesCollection dataset2 = new XYSeriesCollection(series2);
        JFreeChart chart2 = ChartFactory.createXYLineChart("Ventricular readings", "Time(ms)", "Voltage(mV)", dataset2, PlotOrientation.VERTICAL, false, false, false);
        //window.add(new ChartPanel(chart2), BorderLayout.SOUTH);
        mainPanel.add(new ChartPanel(chart2));

        window.add(mainPanel);

        //
        connectButton.addActionListener(new MyActionListener(connectButton, portList, series1,series2, tacsPort));
        window.setVisible(true);
    }

}
