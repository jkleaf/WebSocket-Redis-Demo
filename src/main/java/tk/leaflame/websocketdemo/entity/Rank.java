package tk.leaflame.websocketdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leaflame
 * @date 2020/2/9 12:37
 */
@Data
@AllArgsConstructor
public class Rank {

//    private int rank;
    private String username;
    private long score;
}
