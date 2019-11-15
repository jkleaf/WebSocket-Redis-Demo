package tk.leaflame.websocketdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
@MapperScan("tk.leaflame.websocketdemo.mapper")
@EnableCaching
public class WebsocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketDemoApplication.class, args);
    }

}
