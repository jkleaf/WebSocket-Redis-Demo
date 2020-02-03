package tk.leaflame.websocketdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.leaflame.websocketdemo.mapper.RoomMapper;

/**
 * @author leaflame
 * @date 2020/2/1 15:55
 */
@Service
@Transactional
public class RoomService {

    @Autowired
    RoomMapper roomMapper;

    public int addRoom(String uid){
        return roomMapper.addRoom(uid);
    }

}
