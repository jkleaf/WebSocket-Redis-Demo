package tk.leaflame.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.model.ChatMessage;
import tk.leaflame.websocketdemo.server.WebSocketServer;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/ws")
public class WebSocketController {

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
//    @SendToUser
    public void handleChatMsg(Principal principal, String msg) {
        String destUser = msg.substring(msg.lastIndexOf(";") + 1);
        String msgContent = msg.substring(0, msg.lastIndexOf(";"));
        messagingTemplate.convertAndSendToUser(destUser, "/queue/game/chat", new ChatMessage(msgContent, principal.getName()));
    }

    @MessageMapping("/sys")
    @SendTo("/topic/home")
    public String handleSysMsg() {
        return "系统消息";
    }

    @MessageMapping("/game/chat")
    @SendTo("/topic/game/chat")
    public void handleGameChat(Principal principal, String msg) {
        messagingTemplate.convertAndSend("/topic/game/chat", new ChatMessage(msg, principal.getName()));
    }
}
