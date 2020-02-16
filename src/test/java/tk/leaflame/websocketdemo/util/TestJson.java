package tk.leaflame.websocketdemo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tk.leaflame.websocketdemo.entity.Room;
import tk.leaflame.websocketdemo.service.RoomService;

import java.util.List;

/**
 * @author leaflame
 * @date 2020/2/17 0:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJson {

    Logger logger = LoggerFactory.getLogger(TestJson.class);

    @Autowired
    RoomService roomService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testRoomJson() {
        List<Room> curRooms = roomService.getCurRooms();
        curRooms.forEach(System.out::println);
    }

    @Test
    public void testRoomJson2() {
        System.out.println(redisTemplate.opsForValue().get("room::room_id_$7"));
    }
}
