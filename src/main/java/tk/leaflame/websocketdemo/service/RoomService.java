package tk.leaflame.websocketdemo.service;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.leaflame.websocketdemo.common.RoomStatus;
import tk.leaflame.websocketdemo.entity.ChessGame;
import tk.leaflame.websocketdemo.entity.Room;
import tk.leaflame.websocketdemo.mapper.RoomMapper;
import tk.leaflame.websocketdemo.util.JsonUtil;
import tk.leaflame.websocketdemo.util.RoomUtils;

import java.sql.Timestamp;
import java.util.*;

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
    SimpMessagingTemplate messagingTemplate;

//    @Autowired
//    RoomUtils roomUtils;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public int addRoom(String uid, RoomStatus status, String owner) {
//        Room room = addRoomStatus(RoomUtils.getRoomId(uid), status, owner); //TODO
//        logger.info(room.toString());
        return roomMapper.addRoom(uid);
    }

    //TODO #result.id
    @CachePut(value = "room", key = "'room_id_'+#id")
    public Room updateRoomStatus(String id, RoomStatus status, String owner, Integer playersMaxCount) {
        Room room = new Room();
        room.setStatus(status);
        room.setPlayersMaxCount(playersMaxCount);
        room.setOwner(owner);
        return room;
    }

    public void broadCastRoomsInfo() {
        messagingTemplate.convertAndSend("/topic/hall/rooms", JsonUtil.parseObjToJson(getCurRooms()));
    }

    public Integer getCurrentRoomsCount() {
        return Objects.requireNonNull(redisTemplate.keys("room::room_id_*")).size();
    }

    public List<Room> getCurRooms() {
        List<Room> rooms = new ArrayList<>();
        Objects.requireNonNull(redisTemplate.keys("room::room_id_*")).forEach(
                key -> Optional.ofNullable(redisTemplate.opsForValue().get(key)).ifPresent(v -> {
                    rooms.add(JsonUtil.parseJsonToObj(v, Room.class));
                    logger.info(v);
                })
        );
        return rooms;
    }

    public Room getRoomById(String id) {
        return JsonUtil.parseJsonToObj(redisTemplate.opsForValue().get("room::room_id_" + id), Room.class);
    }

    @CacheEvict(value = "room", key = "'room_id_'+#id", beforeInvocation = false)
    public void leavingRoom(String id) {
        //todo do some removing
    }

}
