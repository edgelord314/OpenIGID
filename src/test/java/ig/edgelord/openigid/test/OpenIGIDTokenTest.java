package ig.edgelord.openigid.test;

import ig.edgelord.openigid.OpenIGIDToken;
import org.junit.Test;

public class OpenIGIDTokenTest {

    @Test
    public void test() {
        OpenIGIDToken token = OpenIGIDToken.generateToken();
        System.out.printf("%s [%d bytes]\n", token.getToken(), token.getToken().getBytes().length);
        for (byte b : token.getToken().getBytes()) {
            System.out.println(b);
        }
    }
}
