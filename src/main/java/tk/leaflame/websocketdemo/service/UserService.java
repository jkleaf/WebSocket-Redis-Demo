package tk.leaflame.websocketdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.leaflame.websocketdemo.entity.User;
import tk.leaflame.websocketdemo.mapper.UserMapper;

import java.util.Optional;

/**
 * @author leaflame
 * @date 2019/11/14 20:45
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.loadUserByUserName(username);
        Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("用户名不正确!"));
        return user;
    }

    //todo
    public int regUser(User user) {
        if (userMapper.loadUserByUserName(user.getUsername()) != null) {
            return -1;
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userMapper.regUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(Long userId) {
        return userMapper.deleteUser(userId);
    }

    //todo
}
