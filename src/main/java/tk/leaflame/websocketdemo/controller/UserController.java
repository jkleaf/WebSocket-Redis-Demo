package tk.leaflame.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.leaflame.websocketdemo.common.Result;
import tk.leaflame.websocketdemo.entity.User;
import tk.leaflame.websocketdemo.service.UserService;

/**
 * @author leaflame
 * @date 2019/11/15 0:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //todo @RequestBody User
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public Result regUser(Long userId,/*@RequestParam("username") */String username, /*@RequestParam("password") */String password) {
        int i = userService.regUser(userId, username, password);
        if (i == 1) {
            return Result.ok("注册成功!");
        } else if (i == -1) {
            return Result.error("用户名重复,注册失败!");
        }
        return Result.error("注册失败!");
    }

    //todo
    @PutMapping
    public Result updateUser(@RequestBody User user) {
        return userService.updateUser(user) == 1 ? Result.ok("更新成功!") : Result.error("更新失败!");
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public Result deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId) == 1 ? Result.ok("删除成功!") : Result.error("删除失败!");
    }

    //todo

}
