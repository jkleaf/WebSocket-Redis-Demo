package tk.leaflame.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.common.Result;
import tk.leaflame.websocketdemo.service.ChessGameService;

/**
 * @author leaflame
 * @date 2020/2/1 17:21
 */
@RestController
@RequestMapping("/chess/game")
public class ChessGameController {

    @Autowired
    ChessGameService chessGameService;

    @PostMapping("/{uid}")
    public Result addChessGame(@PathVariable String uid) {
        int i = chessGameService.addChessGame(uid);
        if (i == 1) {
            return Result.ok("ok");
        } else {
            return Result.error("error");
        }
    }
}
