package tk.leaflame.websocketdemo.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author leaflame
 * @date 2020/2/1 17:23
 */
public interface ChessGameMapper {

    int addChessGame(@Param("uid") String uid);
}
