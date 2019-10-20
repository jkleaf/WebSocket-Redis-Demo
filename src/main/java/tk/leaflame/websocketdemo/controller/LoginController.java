package tk.leaflame.websocketdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.common.Result;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login(String username,String password) {
        if (username.equals("root") && password.equals("123")) {
            return Result.ok();
        }
        return Result.unauthorized();
    }
}
