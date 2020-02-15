package tk.leaflame.websocketdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import tk.leaflame.websocketdemo.common.ChatMessage;
import tk.leaflame.websocketdemo.common.ChessGameMessage;
import tk.leaflame.websocketdemo.common.GameCommonMessage;
import tk.leaflame.websocketdemo.common.GameCommonMsgType;

import java.util.Map;

/**
 * @author leaflame
 * @date 2020/2/11 19:19
 */
@Controller
@MessageMapping("/ws")
public class RoomWsController {

    private Logger logger = LoggerFactory.getLogger(RoomWsController.class);

    @Autowired
    SimpMessagingTemplate messagingTemplate;

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
//                new ChatMessage(ChatMsgType.CHAT, msg, UserUtils.getCurrentUserName())); //token (stomp header)
        messagingTemplate.convertAndSend("/topic/" + uid + "/game/chat", chatMessage); //no token (get username from msg)
    }

    @MessageMapping("/{uid}/game/chess")
//    @SendTo("/topic/{uid}/game/chess")
    public void handleGameChess(@DestinationVariable String uid, @Payload ChessGameMessage chessMessage) {
        logger.info("uid: " + uid);
        logger.info("Chess Message => " + chessMessage.getSender() + ":" + chessMessage.getContent() + " " + chessMessage.getType());
        messagingTemplate.convertAndSend("/topic/" + uid + "/game/chess", chessMessage);
//        final Coordinate coordinate = new Coordinate(1, 2);
    }

    @MessageMapping("/{uid}/game/choice") //confirm,cancel(choice,ready)
    public void broadCastPlayersChoice(@DestinationVariable String uid, @Payload GameCommonMessage choice) {
        messagingTemplate.convertAndSend("/topic/" + uid + "/game/choice", choice);
    }

    @MessageMapping("/{uid}/game/common/notification") //settings,start,finish,,kick...
    public void broadCastGameCommonMessage(@DestinationVariable String uid, @Payload GameCommonMessage notification) {
        messagingTemplate.convertAndSend("/topic/" + uid + "/game/common/notification", notification);
    }
}
