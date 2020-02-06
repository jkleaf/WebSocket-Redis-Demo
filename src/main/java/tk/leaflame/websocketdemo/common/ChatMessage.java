package tk.leaflame.websocketdemo.common;

/**
 * @author leaflame
 * @date 2019/11/6 18:31
 */
//todo
public class ChatMessage { //Room CHAT JSON

    private ChatMessageType type;
    private String content;
    private String sender;

    public ChatMessage() {
    }

    public ChatMessage(ChatMessageType type, String content, String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }

    public ChatMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public ChatMessageType getType() {
        return type;
    }

    public void setType(ChatMessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
