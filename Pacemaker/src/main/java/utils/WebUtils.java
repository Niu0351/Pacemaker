package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Map;

public class WebUtils {
    /**
     * User BeanUtils tool to inject parameters to object
     * req.getParameterMap(): use setXXX in class to set the parameter and inject to object
     * @param value
	 * @param bean
     * @return
     * @author Haoran Qi
     * @date
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

    public static BigDecimal findNumStr(String str){
        if(str == null ){
            return new BigDecimal(255);
        }
        char[] charArr = str.toCharArray();
        String num="";
        int temp;
        for(int i=0;i<charArr.length;i++){
            temp = charArr[i]-'0';
            if((temp>=0 && temp<=9) || charArr[i] == '.' || charArr[i] == '-'){
                num+=charArr[i];
            }
        }
        if(str.equals("OFF")){
            return new BigDecimal(0);
        }
        else if(str.equals("ON")){
            return new BigDecimal(1);
        }
        else if(str.equals("V-Low")){
            return new BigDecimal(1);
        }
        else if(str.equals("Low")){
            return new BigDecimal(2);
        }
        else if(str.equals("Med-Low")){
            return new BigDecimal(3);
        }
        else if(str.equals("Med")){
            return new BigDecimal(4);
        }
        else if(str.equals("Med-High")){
            return new BigDecimal(5);
        }
        else if(str.equals("High")){
            return new BigDecimal(6);
        }
        else if(str.equals("V-High")){
            return new BigDecimal(7);
        }
        return new BigDecimal(num);
    }

    public static byte[] convertToByteArray(float value) {
        byte[] bytes = new byte[4];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putFloat(value);
        return buffer.array();
    }

    public static String getBits(byte a){
        return ""
                + (byte) ((a >> 7) & 0x1) + (byte) ((a >> 6) & 0x1)
                + (byte) ((a >> 5) & 0x1) + (byte) ((a >> 4) & 0x1)
                + (byte) ((a >> 3) & 0x1) + (byte) ((a >> 2) & 0x1)
                + (byte) ((a >> 1) & 0x1) + (byte) ((a >> 0) & 0x1);
    }
}
