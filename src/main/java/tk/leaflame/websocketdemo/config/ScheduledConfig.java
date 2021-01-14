package tk.leaflame.websocketdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import tk.leaflame.websocketdemo.entity.Rank;
import tk.leaflame.websocketdemo.service.RankService;

import java.util.*;

/**
 * @author leaflame
 * @date 2020/2/2 17:39
 */
@Configuration
public class ScheduledConfig {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    RankService rankService;

    //TODO Redis

    private final Random random = new Random(47);

    @Scheduled(fixedRate = 1000)
    public void SchedulingNotifications() {
//        simpMessagingTemplate.convertAndSend("/topic/...","...");
    }

    @Scheduled(fixedRate = 10000)
    public void SchedulingSendSysMsgToUser() {
//        simpMessagingTemplate.convertAndSendToUser("1","/queue/...");
    }

    //todo Rank
    @Scheduled(fixedRate = 2000)
    public void SchedulingDisplayRank() {
//        List<Rank> ranks = new ArrayList<>(); //todo get ranking
//        simpMessagingTemplate.convertAndSend("/", ranks);
        List<Rank> rankList = rankService.getAllRanks();
//        Collections.shuffle(list, random);
        simpMessagingTemplate.convertAndSend("/topic/ranking", rankList);
    }

}
