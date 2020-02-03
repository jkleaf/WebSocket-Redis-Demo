package tk.leaflame.websocketdemo.mapper.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import tk.leaflame.websocketdemo.entity.Room;
import tk.leaflame.websocketdemo.mapper.RoomMapper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

/**
 * @author leaflame
 * @date 2020/2/1 16:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoomMapper {

    @Autowired
    RoomMapper roomMapper;

    @Test
    public void testAddRoom() {
        String roomUid = DigestUtils.md5DigestAsHex((LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) + "").getBytes()) + "$22";
        System.out.println(roomUid);
        System.out.println(roomMapper.addRoom(roomUid));
    }

    @Test
    public void testUpdateRoom() {

    }

    @Test
    public void testGetRoomByUid() {

    }

    @Test
    public void testGetAllRooms() {
        List<Room> rooms = roomMapper.getAllRooms();
        Optional.ofNullable(rooms).ifPresent(System.out::println);
    }

}
