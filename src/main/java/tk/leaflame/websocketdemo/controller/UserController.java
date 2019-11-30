package tk.leaflame.websocketdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    UserService userService;

    //todo @RequestBody User
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ApiOperation("注册用户")
    public Result regUser(@RequestBody User user) {
        int i = userService.regUser(user);
        if (i == 1) {
            return Result.ok("注册成功!");
        } else if (i == -1) {
            return Result.created("用户名重复,注册失败!");
        }
        return Result.error("注册失败!");
    }

    //todo
    @PutMapping
    @ApiOperation("更新用户")
    public Result updateUser(@RequestBody User user) {
        return userService.updateUser(user) == 1 ? Result.ok("更新成功!") : Result.error("更新失败!");
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", notes = "根据用户userId删除用户")
    public Result deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId) == 1 ? Result.ok("删除成功!") : Result.error("删除失败!");
    }

    //todo

}
