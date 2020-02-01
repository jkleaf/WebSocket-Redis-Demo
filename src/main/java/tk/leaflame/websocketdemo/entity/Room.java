package tk.leaflame.websocketdemo.entity;

import lombok.Data;

import java.sql.Timestamp;

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
    private Integer playersCount;
    private String chessBoardUid;
//    private boolean inGame;
}
