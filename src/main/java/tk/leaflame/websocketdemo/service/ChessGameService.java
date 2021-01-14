package tk.leaflame.websocketdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.leaflame.websocketdemo.entity.ChessGame;
import tk.leaflame.websocketdemo.mapper.ChessGameMapper;

import java.sql.Timestamp;

/**
 * @author leaflame
 * @date 2020/2/1 17:24
 */
@Service
@Transactional
public class ChessGameService {

    @Autowired
    ChessGameMapper chessGameMapper;

    public int addChessGame(String uid, Long p1Id, Long p2Id, Integer winner, String chessRecord,Long award) {
        String chessInfo = handleChessGameInfo(chessRecord);
        Long id = null;
        Timestamp startTime = null;
        Timestamp endTime = null;
        ChessGame chessGame = new ChessGame(id, uid, p1Id, p2Id, startTime, endTime, winner, chessRecord,award);
        return chessGameMapper.addChessGame(chessGame);
    }

    //TODO handle chessInfo
    private String handleChessGameInfo(String chessRecord) {
        //...
        return null;
    }
}
