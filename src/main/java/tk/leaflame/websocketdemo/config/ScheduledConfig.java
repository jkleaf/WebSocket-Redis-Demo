package tk.leaflame.websocketdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import tk.leaflame.websocketdemo.entity.Rank;

import java.util.*;

/**
 * @author leaflame
 * @date 2020/2/2 17:39
 */
@Configuration
public class ScheduledConfig {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

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
        List<Rank> list = new ArrayList<>();
        list.add(new Rank("opskvops",6545565));
        list.add(new Rank("dfuibhu",3456435));
        list.add(new Rank("njoigfhisf",453253));
        list.add(new Rank("qwdbiwdqu",23456));
        list.add(new Rank("pkbopgg",896545));
        list.add(new Rank("nvkvnv",935112));
        list.add(new Rank("pobjogf",7777895));
        list.add(new Rank("qibiueeu",66545112));
        Collections.shuffle(list, random);
        simpMessagingTemplate.convertAndSend("/topic/ranking", list);
    }

}
