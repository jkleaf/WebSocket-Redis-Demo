package tk.leaflame.websocketdemo.entity;

import lombok.Data;

/**
 * @author leaflame
 * @date 2019/12/10 0:08
 */
@Data
public class Room {

    private Long id;
    private Integer playersCount;
    private boolean inGame;
}
