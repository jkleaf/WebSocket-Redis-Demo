package tk.leaflame.websocketdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.leaflame.websocketdemo.common.ResultCode;

//@SpringBootTest
class WebsocketDemoApplicationTests {

    @Test
    void contextLoads() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("666"));
//        System.out.println(encoder.encode("666"));
        System.out.println(ResultCode.UNAUTHORIZED.code());
    }

}
