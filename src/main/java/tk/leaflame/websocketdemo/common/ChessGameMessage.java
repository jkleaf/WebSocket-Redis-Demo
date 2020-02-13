package tk.leaflame.websocketdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leaflame
 * @date 2020/2/7 12:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChessGameMessage {

    private ChessGameMsgType type;

    private String content;

    private String sender;

    public ChessGameMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }
}
