package tk.leaflame.websocketdemo.service;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    public void addOrUpdateRank(Rank rank) {
        Query query = new Query(Criteria.where("username").is(rank.getUsername()));
        Rank rankFind = mongoTemplate.findOne(query, Rank.class, "ranking");
        if (rankFind != null) {
            Update update = new Update();
            update.set("score", rank.getScore() + rankFind.getScore());
            mongoTemplate.upsert(query, update, Rank.class, "ranking");
            return;
        }
        // if not exists then insert
        mongoTemplate.insert(rank, "ranking");
    }

//    public void addAndUpdateScore(Rank rank) { //TODO Entity User
//        Query query = new Query(Criteria.where("").is(rank.getUsername())); // TODO id
//        Update update = new Update();
//        update.push("ranks", rank);
//        mongoTemplate.upsert(query, update, Rank.class, "ranking");
//    }

}
