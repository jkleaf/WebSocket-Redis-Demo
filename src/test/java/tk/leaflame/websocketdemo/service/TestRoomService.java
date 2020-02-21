package tk.leaflame.websocketdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leaflame
 * @date 2020/2/17 15:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoomService {

    @Autowired
    RoomService roomService;

    @Test
    public void testDelRoom() {
        roomService.leavingRoom(33 + "");
    }
}
