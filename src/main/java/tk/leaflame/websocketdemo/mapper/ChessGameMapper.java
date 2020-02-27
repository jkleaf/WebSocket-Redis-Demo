package tk.leaflame.websocketdemo.mapper;

import org.apache.ibatis.annotations.Param;
import tk.leaflame.websocketdemo.entity.ChessGame;

import java.sql.Timestamp;

/**
 * @author leaflame
 * @date 2020/2/1 17:23
 */
public interface ChessGameMapper {

    int addChessGame(@Param("chessGame") ChessGame chessGame);
}
