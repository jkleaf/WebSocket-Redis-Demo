package tk.leaflame.websocketdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
@MapperScan("tk.leaflame.websocketdemo.mapper")
@EnableCaching
@EnableScheduling
public class WebsocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketDemoApplication.class, args);
    }

}
