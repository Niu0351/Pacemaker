package serialComm;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.util.ArrayList;
import java.util.List;

public class SerialListener implements SerialPortDataListener {

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
            return;
        try{
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
        byte[] newData = new byte[serialPortEvent.getSerialPort().bytesAvailable()];
        int numRead=serialPortEvent.getSerialPort().readBytes(newData, newData.length);
        //redirect input to Tacs server
        System.out.println("Received data of size: " + numRead);
        System.out.println("Received data hex string: " + encodeHexString(newData));
        System.out.println("\n");
    }

    public List<Integer> encodeHexString(byte[] byteArray) {
        List<Integer> list = new ArrayList<Integer>();
//        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
//            hexStringBuffer.append(byteToHex(byteArray[i]));
            list.add(byteToHex(byteArray[i]));
        }
//        return hexStringBuffer.toString();
        return list;
    }

    public int byteToHex(byte num) {
        char[] hexDigits = new char[2];
        String s = Byte.toString(num);
//        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
//        hexDigits[1] = Character.forDigit((num & 0xF), 16);
//        return new String(hexDigits);
        int i = (int)num;
        return i;
    }

}
