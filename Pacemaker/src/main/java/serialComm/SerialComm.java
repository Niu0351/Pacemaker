package serialComm;

import com.fazecast.jSerialComm.SerialPort;

public class SerialComm {

    private static SerialPort tacsPort = null;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        commWithPort("COM3");
        try{
            Thread.sleep(5000);

        }catch(Exception e){
            e.printStackTrace();
        }
        if (tacsPort == null){
            System.out.println("No connection.");
        }else{
            tacsPort.removeDataListener();
            tacsPort.closePort();
        }

    }

    public static void commWithPort(String portname){
        SerialPort[] commports = SerialPort.getCommPorts();
        for (SerialPort port: commports){
            System.out.println(port.getSystemPortName());
            if (tacsPort==null && port.getDescriptivePortName().contains(portname)){
                tacsPort = port;
            }
        }
        if(tacsPort != null){
            tacsPort.setComPortParameters(115200, 8, 1, SerialPort.NO_PARITY);
            tacsPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            tacsPort.openPort();
            for (int j = 0; j < 10; ++j) {
                byte[] sendData = new byte[]{(byte) 0xc0};
                tacsPort.writeBytes(sendData, 1);
            }
            tacsPort.addDataListener(new SerialListener());


        }
    }

}
