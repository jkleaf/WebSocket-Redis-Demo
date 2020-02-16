package tk.leaflame.websocketdemo.entity;

import lombok.Data;
import lombok.ToString;
import tk.leaflame.websocketdemo.common.RoomStatus;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author leaflame
 * @date 2019/12/10 0:08
 * Room Record
 */
@Data
public class Room {

    private Long id;
    private String uid;
    private Timestamp create_time;
    private Timestamp close_time;
    private Integer playersMaxCount;
    private List<ChessGame> chessGames;

    private RoomStatus status;
    private String owner;
}
