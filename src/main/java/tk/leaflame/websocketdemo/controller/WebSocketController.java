package tk.leaflame.websocketdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.model.ChatMessage;
import tk.leaflame.websocketdemo.server.WebSocketServer;

import java.io.IOException;
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

    @MessageMapping("/ws/friend/chat")
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

    @MessageMapping("/ws/game/chat")
    @SendTo("/topic/game/chat")
    public void handleGameChat(Principal principal, String uid, String msg) { //topic+id+...
//        messagingTemplate.convertAndSend("/topic/game/chat", new ChatMessage(msg, principal.getName()));
        messagingTemplate.convertAndSendToUser(uid, "/topic/game/chat", new ChatMessage(msg, principal.getName()));
    }

    @MessageMapping("/ws/game/chess")
    @SendTo("/topic/game/chess")
    public void handleGameChess(Principal principal, String msg) {
        messagingTemplate.convertAndSend("/topic/game/chess", new ChatMessage(msg, principal.getName()));
    }
}
