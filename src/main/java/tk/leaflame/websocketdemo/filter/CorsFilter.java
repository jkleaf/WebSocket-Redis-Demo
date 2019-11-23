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

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest reqs = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));//reqs.getHeader("Origin")
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS,PATCH");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,token,Content-Type,Authorization");//jwt header
//        response.setHeader("Access-Control-Expose-Headers","*");
        response.setHeader("Access-Control-Max-Age", "3600");
        if (reqs.getMethod().toLowerCase().equals("options")) {
            response.setStatus(200);
        } else {
            chain.doFilter(req, res);
        }
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
