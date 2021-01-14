package tk.leaflame.websocketdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import tk.leaflame.websocketdemo.entity.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author leaflame
 * @date 2021/1/14 15:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRankService {

    private static List<Rank> list = new ArrayList<>();

    static {
        list.add(new Rank("opskvops", 6545565));
        list.add(new Rank("dfuibhu", 3456435));
        list.add(new Rank("njoigfhisf", 453253));
        list.add(new Rank("qwdbiwdqu", 23456));
        list.add(new Rank("pkbopgg", 896545));
        list.add(new Rank("nvkvnv", 935112));
        list.add(new Rank("pobjogf", 7777895));
        list.add(new Rank("qibiueeu", 66545112));
        list.add(new Rank("wuyeb", 35423));
        list.add(new Rank("obpf", 86446));
        list.add(new Rank("nbnfib", 867652));
        list.add(new Rank("nbnfib", 27878)); //duplicate
    }

    @Autowired
    RankService rankService;

    @Test
    public void testAddRanks() {
//        list.forEach(rank -> rankService.addOrUpdateRank(rank));
        rankService.addOrUpdateRank(new Rank("DEMO1",53454));
    }

    @Test
    public void testUpdateRanks() {
        Rank rank = new Rank("nbnfib", 5846);
//        Rank rank = new Rank("DEMO1", 34533);
        rankService.addOrUpdateRank(rank);
    }

    @Test
    public void testGetAllRanks(){
        List<Rank> rankList = rankService.getAllRanks();
        rankList.forEach(System.out::println);
    }

}
