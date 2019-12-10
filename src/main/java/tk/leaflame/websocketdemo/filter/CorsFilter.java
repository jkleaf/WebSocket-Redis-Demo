package tk.leaflame.websocketdemo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author leaflame
 * @date 2019/11/22 17:28
 */
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));//req.getHeader("Origin")
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS,PATCH");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,token,Content-Type,Authorization");//jwt header
//        response.setHeader("Access-Control-Expose-Headers","*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        if (req.getMethod().toLowerCase().equals("options")) {
            resp.setStatus(200);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
