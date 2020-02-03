package tk.leaflame.websocketdemo.mapper;

import org.springframework.data.repository.query.Param;
import tk.leaflame.websocketdemo.entity.Room;

import java.util.List;

/**
 * @author leaflame
 * @date 2020/2/1 15:55
 */
public interface RoomMapper {

    int addRoom(@Param("uid") String uid);

    int updateRoom();

    int deleteRoom();

    Room getRoomByUid(@Param("uid") String uid);

    int getRoomsCountByDate();

    int getAllRoomsCount();

    List<Room> getRoomsByDate();

    List<Room> getAllRooms();

}
