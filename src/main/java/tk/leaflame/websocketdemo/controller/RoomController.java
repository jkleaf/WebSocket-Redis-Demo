package tk.leaflame.websocketdemo.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import tk.leaflame.websocketdemo.common.Result;
import tk.leaflame.websocketdemo.common.RoomStatus;
import tk.leaflame.websocketdemo.common.UserUtils;
import tk.leaflame.websocketdemo.entity.Room;
import tk.leaflame.websocketdemo.service.RoomService;
import tk.leaflame.websocketdemo.util.RoomUtils;

/**
 * @author leaflame
 * @date 2020/2/1 2:59
 */
@RestController
@RequestMapping("/room")
@Api("房间接口")
public class RoomController {

    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    RoomService roomService;

    @PostMapping("/{uid}")
    public Result createRoom(@PathVariable String uid, @RequestParam(required = false, value = "roomStatus") String status
            /*@RequestParam(value = "owner") String owner*//*@RequestParam(required = false, value = "playersCount") Integer playersCount*/) {
        RoomStatus roomStatus = Enum.valueOf(RoomStatus.class, status);
        int i = roomService.addRoom(uid, roomStatus, UserUtils.getCurrentUserName());
        Room room = roomService.updateRoomStatus(RoomUtils.getRoomId(uid), roomStatus, UserUtils.getCurrentUserName(), 1);
        if (i == 1) {
            return Result.ok("创建成功");
        } else {
            return Result.error("创建失败");
        }
    }

    @GetMapping("/cur/count")
    public Result getCurrentRoomsCount() {
        int count = roomService.getCurrentRoomsCount();
        logger.info(count + "");
        return Result.ok("count", count);
    }

    @RequestMapping("/leave/{uid}")
    public Result leavingRoom(@PathVariable String uid) {
        logger.info(uid);
        roomService.leavingRoom(RoomUtils.getRoomId(uid));
        return Result.ok();
    }

    @DeleteMapping("/{uid}")
    public Result deleteRoom(@PathVariable String uid) {
        return null;
    }

    @GetMapping("/{id}") //TODO get from redis
    public Result getRoomById(@PathVariable String id) {
        Room room = roomService.getRoomById(id);
        logger.info(room.toString());
        return null;
    }

    @GetMapping("/{uid}")
    public Result getRoomByUid(@PathVariable String uid) {
        return null;
    }

    @PutMapping("/{uid}")
    public Result updateRoomByUid(@PathVariable String uid) {
        return null;
    }
}
