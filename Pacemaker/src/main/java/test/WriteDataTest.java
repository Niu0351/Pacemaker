package test;

import com.fazecast.jSerialComm.SerialPort;
import org.junit.jupiter.api.Test;
import utils.WebUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

public class WriteDataTest {

    SerialPort tacsPort = null;


    @Test
    public void aa(){
//        byte[] a = new byte[]{0x16};
//        String aa = new String(""+a[0]);
//        System.out.println(WebUtils.getBits(a[0]).substring(0,7));
        ArrayList<String> ventricular = new ArrayList<>();
        ArrayList<String> atrium = new ArrayList<>();
        String temp1;
        String temp2;

        byte[] totalBytes = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        atrium.add(WebUtils.getBits(totalBytes[0]));
        ventricular.add(WebUtils.getBits(totalBytes[1]));
        temp1 = WebUtils.getBits(totalBytes[2]);
        temp2 = WebUtils.getBits(totalBytes[3]);
        atrium.add(temp1.substring(2, 8) + temp2.substring(0, 2));
        temp1 = WebUtils.getBits(totalBytes[4]);
        ventricular.add(temp2.substring(2, 8)+temp1.substring(0, 2));
        temp2 = WebUtils.getBits(totalBytes[5]);
        atrium.add(temp1.substring(4, 8)+temp2.substring(0, 4));
        temp1 = WebUtils.getBits(totalBytes[6]);
        ventricular.add(temp2.substring(4,8)+temp1.substring(0, 4));
        temp2 = WebUtils.getBits(totalBytes[7]);
        atrium.add(temp1.substring(6, 8)+temp2.substring(0, 6));
        temp1 = WebUtils.getBits(totalBytes[8]);
        ventricular.add(temp2.substring(6, 8)+temp1.substring(0, 6));
        atrium.add(WebUtils.getBits(totalBytes[9]));
        ventricular.add(WebUtils.getBits(totalBytes[10]));
        temp1 = WebUtils.getBits(totalBytes[11]);
        temp2 = WebUtils.getBits(totalBytes[12]);
        atrium.add(temp1.substring(2, 8) + temp2.substring(0, 2));
        temp1 = WebUtils.getBits(totalBytes[13]);
        ventricular.add(temp2.substring(2, 8)+temp1.substring(0, 2));
        temp2 = WebUtils.getBits(totalBytes[14]);
        atrium.add(temp1.substring(4, 8)+temp2.substring(0, 4));
        temp1 = WebUtils.getBits(totalBytes[15]);
        ventricular.add(temp2.substring(4,8)+temp1.substring(0, 4));
        temp2 = WebUtils.getBits(totalBytes[16]);
        atrium.add(temp1.substring(6, 8)+temp2.substring(0, 6));
        temp1 = WebUtils.getBits(totalBytes[17]);
        ventricular.add(temp2.substring(6, 8)+temp1.substring(0, 6));
//        for(String i:atrium){
//            System.out.println(i);
//        }
        System.out.println(atrium.get(0));
        System.out.println(Byte.parseByte(atrium.get(0)));
        System.out.println(Integer.parseInt("10011111",2));
        //System.out.println(b);
    }

    @Test
    public void writeData(){
        SerialPort[] commPorts = SerialPort.getCommPorts();
        for (SerialPort port: commPorts){
            System.out.println(port.getSystemPortName());
            if (tacsPort==null && port.getDescriptivePortName().contains("COM3")){
                tacsPort = port;
            }
        }
        System.out.println("current port:"+tacsPort.getSystemPortName());
        tacsPort.setComPortParameters(115200, 8, 1, SerialPort.NO_PARITY);
        tacsPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        tacsPort.openPort();
//        OutputStream outputStream = tacsPort.getOutputStream();
//        InputStream inputStream = tacsPort.getInputStream();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] sendData1 = new byte[]{0x55};
        //byte[] sendData = new byte[]{(byte)0,(byte)0};
//        byte a = (byte)137;
//        System.out.println(WebUtils.unsignedToBytes(a));
//        int a1 = WebUtils.unsignedToBytes(a);
        BigDecimal a = new BigDecimal(0x55);
        //BigDecimal b = new BigDecimal(2);
        byte[] sendData = new byte[]{a.byteValueExact()};
        byte[] receiveData = new byte[2];
        //byte[] sendData = new byte[]{(byte)0x16,(byte)0x55,(byte)255,(byte)255,(byte)255,sendData1[0],sendData1[1],sendData1[2],sendData1[3],(byte)2,(byte)255};
        tacsPort.writeBytes(sendData1, 1);
        for(byte bbyte:sendData1){
            System.out.println(bbyte);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tacsPort.readBytes(receiveData, 2);

        for(byte bbyte:receiveData){
            System.out.println(bbyte);
        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        tacsPort.closePort();
    }


    public void close(){

    }
}
