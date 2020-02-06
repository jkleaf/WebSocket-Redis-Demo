package tk.leaflame.websocketdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import tk.leaflame.websocketdemo.common.ChatMessage;
import tk.leaflame.websocketdemo.common.ChatMessageType;
import tk.leaflame.websocketdemo.common.UserUtils;

import java.security.Principal;

@Controller
@MessageMapping("/ws")
public class WebSocketController {

    private Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    SimpMessagingTemplate messagingTemplate; //use spring-messaging
//    @Autowired
//    WebSocketServer server;
//
//    @PostMapping("/entry/room")
//    public String entry(String username) throws IOException {
//        server.sendInfo(username + "进入了聊天室!");
//        return username;
//    }

    @MessageMapping("/friend/chat")
//    @SendTo("/queue/friend/chat")
//    @SendToUser("/queue/friend/chat")
    public void handleChatMsg(Principal principal, String msg) {
//        String destUser = msg.substring(msg.lastIndexOf(";") + 1);
//        String msgContent = msg.substring(0, msg.lastIndexOf(";")); //queue+id
//        messagingTemplate.convertAndSendToUser(destUser, "/queue/friend/chat", new ChatMessage(msgContent, principal.getName()));
        logger.info("Principal Name: " + principal.getName());
//        return principal.getName();
//        return "fuck you";
        messagingTemplate.convertAndSend("/queue/friend/chat", principal.getName());
    }

    @MessageMapping("/sys")
    @SendTo("/topic/home")
    public String handleSysMsg() {
        logger.info("系统消息");
        return "系统消息";
    }

    @MessageMapping("/{uid}/game/chat") //TODO
//    @SendTo("/topic/{uid}/game/chat")
    public void handleGameChat(@DestinationVariable String uid, /*String msg*/@Payload ChatMessage chatMessage) { // /topic+id+...
//        messagingTemplate.convertAndSend("/topic/game/chat", new ChatMessage(msg, principal.getName()));
//        logger.info("principal-name: " + principal.getName());
//        logger.info("username: "+UserUtils.getCurrentUserName());
        logger.info("uid: " + uid);
//        logger.info("msg: " + msg);
        logger.info("Chat-Message => " + chatMessage.getSender() + ":" + chatMessage.getContent() + " " + chatMessage.getType());
//        messagingTemplate.convertAndSend("/topic/"+uid+"/game/chat",
//                new ChatMessage(ChatMessageType.CHAT, msg, UserUtils.getCurrentUserName())); //token (stomp header)
        messagingTemplate.convertAndSend("/topic/" + uid + "/game/chat",
                new ChatMessage(ChatMessageType.CHAT, chatMessage.getContent(), chatMessage.getSender())); //no token (get username from msg)
    }

    @MessageMapping("/game/chess")
    @SendTo("/topic/game/chess")
    public void handleGameChess(Principal principal, String msg) {
        messagingTemplate.convertAndSend("/topic/game/chess", new ChatMessage(msg, principal.getName()));
    }
}
