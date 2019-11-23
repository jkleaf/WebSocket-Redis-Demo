package tk.leaflame.websocketdemo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;
import tk.leaflame.websocketdemo.model.ChatMessage;
import tk.leaflame.websocketdemo.service.ChatService;
import tk.leaflame.websocketdemo.util.JsonUtil;

/**
 * Redis订阅频道处理类
 * @author yangzhendong01
 */
@Component
public class RedisListenerHandler /*extends MessageListenerAdapter*/ {

//    private static final Logger LOGGER = LoggerFactory.getLogger(RedisListenerHandler.class);
//
//    @Value("${redis.channel.msgToAll}")
//    private String msgToAll;
//
//    @Value("${redis.channel.userStatus}")
//    private String userStatus;
//
//    @Value("${server.port}")
//    private String serverPort;
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Autowired
//    private ChatService chatService;
//
//    /**
//     * todo 收到监听消息,监听Redis的广播(发布)和用户发送消息
//     * @param message
//     * @param bytes
//     */
//    @Override
//    public void onMessage(Message message, byte[] bytes) {
//        byte[] body = message.getBody();
//        byte[] channel = message.getChannel();
//        String rawMsg;
//        String topic;
//        try {
//            rawMsg = redisTemplate.getStringSerializer().deserialize(body);//从Redis中获取
//            topic = redisTemplate.getStringSerializer().deserialize(channel);
//            LOGGER.info("Received raw message from topic:" + topic + ", raw message content：" + rawMsg);
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//            return;
//        }
//
//
//        if (msgToAll.equals(topic)) {
//            LOGGER.info("Send message to all users:" + rawMsg);
//            ChatMessage chatMessage = JsonUtil.parseJsonToObj(rawMsg, ChatMessage.class);
//            if (chatMessage != null) {
//                chatService.sendMsg(chatMessage);//todo chatService使用SimpMessageSendingOperations发送消息
//            }
//        } else if (userStatus.equals(topic)) {
//            ChatMessage chatMessage = JsonUtil.parseJsonToObj(rawMsg, ChatMessage.class);
//            if (chatMessage != null) {
//                chatService.alertUserStatus(chatMessage);
//            }
//        }else {
//            LOGGER.warn("No further operation with this topic!");
//        }
//    }
}