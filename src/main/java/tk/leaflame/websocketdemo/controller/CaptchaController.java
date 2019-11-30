package tk.leaflame.websocketdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.leaflame.websocketdemo.common.Result;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author leaflame
 * @date 2019/11/30 9:50
 */
@RestController
public class CaptchaController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping("/login/captcha")
    public Result captcha() throws IOException, FontFormatException {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        specCaptcha.setFont(Captcha.FONT_1);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(key, verCode, 30, TimeUnit.MINUTES);
        Map<String, String> captcha = new HashMap<>();
        captcha.put("verKey", key);
        captcha.put("image", specCaptcha.toBase64());//base64->image
        return Result.ok("captcha", new ObjectMapper().writeValueAsString(captcha));
    }

    @PostMapping("/login/captcha")
    public Result checkLoginCaptcha(String verCode, String verKey) {
        String redisVerCode = redisTemplate.opsForValue().get(verKey);
        if(redisVerCode==null||!redisVerCode.equals(verCode.trim().toLowerCase())){
            return Result.ok("验证码错误!");
        }
        return Result.ok("验证码正确");
    }
}
