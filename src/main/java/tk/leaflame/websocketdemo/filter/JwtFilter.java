package tk.leaflame.websocketdemo.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import tk.leaflame.websocketdemo.common.ResultCode;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author leaflame
 * @date 2019/10/23 8:47
 */
public class JwtFilter extends GenericFilterBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);

//    @Value("${tk.leaflame.jwt.key}")
//    private String signingKey;

    @Override//下一步过滤
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String jwt = req.getHeader("authorization");
        if (jwt != null) {
            Jws<Claims> jws = Jwts.parser().setSigningKey("destiny")
                    .parseClaimsJws(jwt.replace("Bearer", ""));
            Claims claims = jws.getBody();
            String username = claims.getSubject();
            if (username == null) {
                ((HttpServletResponse) servletResponse).setStatus(ResultCode.UNAUTHORIZED.code());
            } else {
                List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(token);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
