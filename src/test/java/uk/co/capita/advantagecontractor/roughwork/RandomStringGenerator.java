package uk.co.capita.advantagecontractor.roughwork;

import java.nio.charset.Charset;
import java.util.Random;
public class RandomStringGenerator {

    private static final String ALPHA_NUM ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    
    public static String getAlphaNumeric() {
        StringBuffer sb = new StringBuffer(5);
        for (int i=0; i<5; i++) {
            int ndx = (int)(Math.random()*ALPHA_NUM.length());
            sb.append(ALPHA_NUM.charAt(ndx));
        }
        return sb.toString();
        }
}
