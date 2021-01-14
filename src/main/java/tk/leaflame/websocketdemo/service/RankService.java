package tk.leaflame.websocketdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tk.leaflame.websocketdemo.entity.Rank;

import java.util.List;

/**
 * @author leaflame
 * @date 2021/1/14 15:34
 */
@Service
public class RankService {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Rank> getAllRanks() {
        List<Rank> rankList = mongoTemplate.findAll(Rank.class, "ranking");
        return rankList;
    }

    public Rank addRank(Rank rank) {
        return mongoTemplate.insert(rank, "ranking");
    }

}
