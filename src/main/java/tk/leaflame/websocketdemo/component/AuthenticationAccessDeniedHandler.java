package tk.leaflame.websocketdemo.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tk.leaflame.websocketdemo.common.Result;
import tk.leaflame.websocketdemo.common.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author leaflame
 * @date 2019/11/16 8:37
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {//custom forbidden

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        resp.setStatus(ResultCode.FORBIDDEN.code());
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(Result.forbidden("权限不足!")));
        out.flush();
        out.close();
    }
}
