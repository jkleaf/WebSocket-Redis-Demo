package tk.leaflame.websocketdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import tk.leaflame.websocketdemo.model.ChatMessage;
import tk.leaflame.websocketdemo.service.ChatService;
import tk.leaflame.websocketdemo.util.JsonUtil;

//todo 接收和发送消息
@Controller
public class ChatController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);
//
//    @Value("${redis.channel.msgToAll}")
//    private String msgToAll;
//
//    @Value("${redis.set.onlineUsers}")
//    private String onlineUsers;
//
//    @Value("${redis.channel.userStatus}")
//    private String userStatus;
//
//    @Autowired
//    private ChatService chatService;
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    //todo 目的地以/app开头的客户端发送的所有消息都将路由到使用@MessageMapping注释的消息处理方法 (/app/chat.sendMessage)
//    @MessageMapping("/chat.sendMessage")
////todo    @SendTo("/topic/public") 源码中未使用Redis,而是@SendTo来广播,用Redis可以支持集群转发
//    public void sendMessage(@Payload ChatMessage chatMessage) {
//        try {
//            redisTemplate.convertAndSend(msgToAll, JsonUtil.parseObjToJson(chatMessage));//广播发送全体消息
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//        }
//    }
//
//    @MessageMapping("/chat.addUser")
////    @SendTo("/topic/public")
//    public void addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//
//        LOGGER.info("User added in Chatroom:" + chatMessage.getSender());
//        try {
//            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());//todo 存入WebSocket Session
//            redisTemplate.opsForSet().add(onlineUsers, chatMessage.getSender());
//            redisTemplate.convertAndSend(userStatus, JsonUtil.parseObjToJson(chatMessage));//todo 广播用户加入事件
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//        }
//    }

}
