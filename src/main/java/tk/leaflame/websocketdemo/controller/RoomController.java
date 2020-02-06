package tk.leaflame.websocketdemo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.leaflame.websocketdemo.common.Result;
import tk.leaflame.websocketdemo.common.UserUtils;
import tk.leaflame.websocketdemo.service.RoomService;

/**
 * @author leaflame
 * @date 2020/2/1 2:59
 */
@RestController
@RequestMapping("/room")
@Api("房间接口")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/{uid}")
    public Result createRoom(@PathVariable String uid) {
        int i = roomService.addRoom(uid);
        if (i == 1) {
            return Result.ok("创建成功");
        } else {
            return Result.error("创建失败");
        }
    }

    @DeleteMapping("/{uid}")
    public Result deleteRoom(@PathVariable String uid) {
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
