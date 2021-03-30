package service;

import com.fazecast.jSerialComm.SerialPort;
import pojo.Mode;

public interface ModeService {
    int saveMode(Mode mode);
    void transmitModeParameter(Mode mode, SerialPort port);
    void getPlot(SerialPort tacsPort);
    SerialPort openPort();
    void closePort(SerialPort port);
    SerialPort getPort();
    void getEcho(SerialPort tacsPort);
    void stopReceivingData(SerialPort serialPort);
}
