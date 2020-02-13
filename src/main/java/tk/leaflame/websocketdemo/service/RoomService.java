package tk.leaflame.websocketdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.leaflame.websocketdemo.common.RoomStatus;
import tk.leaflame.websocketdemo.entity.Room;
import tk.leaflame.websocketdemo.mapper.RoomMapper;

import java.util.Objects;
import java.util.Set;

/**
 * @author leaflame
 * @date 2020/2/1 15:55
 */
@Service
@Transactional
public class RoomService {

    private Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public int addRoom(String uid, RoomStatus status) {
        Room room = addRoomStatus(uid, status); //TODO
        logger.info(room.toString());
        return roomMapper.addRoom(uid);
    }

    @CachePut(value = "room", key = "'room_uid_'+#uid")
    public Room addRoomStatus(String uid, RoomStatus status) {
        Room room = new Room();
        room.setStatus(status);
        room.setPlayersMaxCount(1);
        return room;
    }

    //TODO #result.uid
    @CachePut(value = "room", key = "'room_uid_'+#uid")
    public Room updateRoomStatus(String uid, RoomStatus status, Integer playersMaxCount) {
        Room room = new Room();
        room.setStatus(status);
        room.setPlayersMaxCount(playersMaxCount);
        return room;
    }

    public Integer getCurrentRoomsCount() {
        return Objects.requireNonNull(redisTemplate.keys("room_uid_*")).size();
    }

    @CacheEvict(value = "room", key = "'room_uid_'+#uid", beforeInvocation = false)
    public void leavingRoom(String uid) {
        //todo do some removing
    }

}
