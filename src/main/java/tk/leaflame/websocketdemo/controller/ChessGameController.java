package tk.leaflame.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.leaflame.websocketdemo.common.Result;
import tk.leaflame.websocketdemo.entity.ChessGame;
import tk.leaflame.websocketdemo.service.ChessGameService;
import tk.leaflame.websocketdemo.service.UserService;
import tk.leaflame.websocketdemo.util.JsonUtil;

/**
 * @author leaflame
 * @date 2020/2/1 17:21
 */
@RestController
@RequestMapping("/chess/game")
public class ChessGameController {

    @Autowired
    ChessGameService chessGameService;

    @Autowired
    UserService userService;

    @PostMapping("/{uid}")
    public Result addChessGame(@PathVariable String uid, /*@RequestBody*/ String chessGameJson) {
//        ChessGame chessGame= JsonUtil.parseJsonToObj(chessGameJson, ChessGame.class);
        String player1 = "";
        String player2 = "";
        Integer winner = Integer.valueOf("");
        String chessRecord = "";
        Long p1Id = userService.getIdByUserName(player1);
        Long p2Id = userService.getIdByUserName(player2);
        int i = chessGameService.addChessGame(uid, p1Id, p2Id, winner, chessRecord);
        if (i == 1) {
            return Result.ok("ok");
        } else {
            return Result.error("error");
        }
    }
}
