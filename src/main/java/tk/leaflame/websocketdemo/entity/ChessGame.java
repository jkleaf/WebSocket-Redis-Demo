package tk.leaflame.websocketdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author leaflame
 * @date 2020/2/1 11:25
 * Game Record
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChessGame {

    private Long id;
    private String uid;
    private Long p1id;
    private Long p2id;
    private Timestamp start_time;
    private Timestamp end_time;
    private Integer winner;
    private String chessInfo;
    private Long award;

}
