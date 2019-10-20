package tk.leaflame.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.server.WebSocketServer;

import java.io.IOException;

@RestController
public class WebSocketController {

    @Autowired
    WebSocketServer server;

    @PostMapping("/entry/room")
    public String entry(String username) throws IOException {
        server.sendInfo(username + "进入了聊天室!");
        return username;
    }
}
