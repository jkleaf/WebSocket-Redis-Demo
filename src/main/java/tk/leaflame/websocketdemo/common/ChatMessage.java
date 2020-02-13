package tk.leaflame.websocketdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leaflame
 * @date 2019/11/6 18:31
 */
//todo
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage { //Room CHAT JSON

    private ChatMsgType type;
    private String content;
    private String sender;

    public ChatMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }
}
