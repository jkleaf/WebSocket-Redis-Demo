package tk.leaflame.websocketdemo.util;

import org.springframework.stereotype.Component;
import tk.leaflame.websocketdemo.entity.Room;

/**
 * @author leaflame
 * @date 2020/2/15 17:19
 */
//@Component
public final class RoomUtils {

    private Room room;

    public static String getRoomId(String uid) {
        return uid.substring(uid.lastIndexOf("$") + 1);
    }
}
