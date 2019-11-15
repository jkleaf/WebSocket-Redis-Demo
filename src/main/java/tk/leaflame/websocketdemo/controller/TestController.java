package tk.leaflame.websocketdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.common.Result;

/**
 * @author leaflame
 * @date 2019/10/22 23:47
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Result test() {
        return Result.ok("testing...", null);
    }

    @GetMapping("/admin")
    public Result admin() {
        return Result.ok("admin", null);
    }
}
