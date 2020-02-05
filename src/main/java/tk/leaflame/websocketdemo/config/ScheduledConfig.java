package tk.leaflame.websocketdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author leaflame
 * @date 2020/2/2 17:39
 */
@Configuration
public class ScheduledConfig {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 1000)
    public void SchedulingNotifications() {
//        simpMessagingTemplate.convertAndSend("/topic/...","...");
    }

    @Scheduled(fixedRate = 10000)
    public void SchedulingSendSysMsgToUser() {
//        simpMessagingTemplate.convertAndSendToUser("1","/queue/...");
    }

}
