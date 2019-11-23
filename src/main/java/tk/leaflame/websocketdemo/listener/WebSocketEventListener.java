package tk.leaflame.websocketdemo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import tk.leaflame.websocketdemo.model.ChatMessage;
import tk.leaflame.websocketdemo.util.JsonUtil;

import java.net.Inet4Address;
import java.net.InetAddress;

//todo WebSocket事件监听
@Component
public class WebSocketEventListener {

//    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
//
//    @Value("${server.port}")
//    private String serverPort;
//
//    @Value("${redis.set.onlineUsers}")
//    private String onlineUsers;
//
//    @Value("${redis.channel.userStatus}")
//    private String userStatus;
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
////    @Autowired
////    private SimpMessageSendingOperations messagingTemplate;
//
//    //Connected
//    @EventListener //todo 已在ChatController中广播了加入(Connect)事件,无需此event
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {//todo SessionConnectedEvent
//        InetAddress localHost;
//        try {
//            localHost = Inet4Address.getLocalHost();
//            LOGGER.info("Received a new web socket connection from:" + localHost.getHostAddress() + ":" + serverPort);
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//        }
//
//    }
//
//    //DisConnected
//    @EventListener //todo 从websocket会话中提取用户名，并向所有连接的客户端广播用户离开(DisConnect)事件
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {//SessionDisconnectEvent
//
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//
//        if(username != null) {
//            LOGGER.info("User Disconnected : " + username);
//            ChatMessage chatMessage = new ChatMessage();
//            chatMessage.setType(ChatMessage.MessageType.LEAVE);
//            chatMessage.setSender(username);
//            try {
//                redisTemplate.opsForSet().remove(onlineUsers, username);
//                redisTemplate.convertAndSend(userStatus, JsonUtil.parseObjToJson(chatMessage));//广播,下同
////                messagingTemplate.convertAndSend("/topic/public",chatMessage);//现改用Redis
//            } catch (Exception e) {
//                LOGGER.error(e.getMessage(), e);
//            }
//
//        }
//    }
}
