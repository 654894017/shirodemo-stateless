package changs;

import changs.utils.Base64;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by yincs on 2017/4/8.
 */
public class AppTest {
    @Test
    public void test1() throws Exception {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println("uuid = " + uuid);
        }
    }

    @Test
    public void test2() throws Exception {
        byte[] bytes = "abcd%%%a21321321321fd!@@#@!a".getBytes();
        System.out.println("bytes = " + bytes.length);
        byte[] encode = Base64.getEncoder().encode(bytes);
        System.out.println("encode = " + encode.length);
        String result = new String(encode);
        System.out.println("result = " + result);
    }
}
