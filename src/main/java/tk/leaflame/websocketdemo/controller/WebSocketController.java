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
import tk.leaflame.websocketdemo.common.*;

import java.security.Principal;

import static tk.leaflame.websocketdemo.common.ChessGameMessageType.*;

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
                new ChatMessage(chatMessage.getType(), chatMessage.getContent(), chatMessage.getSender())); //no token (get username from msg)
    }

    @MessageMapping("/{uid}/game/chess")
//    @SendTo("/topic/{uid}/game/chess")
    public void handleGameChess(@DestinationVariable String uid, @Payload ChessGameMessage chessMessage) {
        logger.info("uid: " + uid);
        logger.info("Chess Message => " + chessMessage.getSender() + ":" + chessMessage.getContent() + " " + chessMessage.getType());
        messagingTemplate.convertAndSend("/topic/" + uid + "/game/chess",
                new ChessGameMessage(chessMessage.getType(), chessMessage.getContent(), chessMessage.getSender()));
//        final Coordinate coordinate = new Coordinate(1, 2);
    }

}
