package tk.leaflame.websocketdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leaflame
 * @date 2020/2/11 20:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameCommonMessage<T> {

    private GameCommonMsgType type;

    private T content;
}
