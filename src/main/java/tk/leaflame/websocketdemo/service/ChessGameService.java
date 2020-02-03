package tk.leaflame.websocketdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.leaflame.websocketdemo.mapper.ChessGameMapper;

/**
 * @author leaflame
 * @date 2020/2/1 17:24
 */
@Service
@Transactional
public class ChessGameService {

    @Autowired
    ChessGameMapper chessGameMapper;

    public int addChessGame(String uid) {
        return chessGameMapper.addChessGame(uid);
    }
}
