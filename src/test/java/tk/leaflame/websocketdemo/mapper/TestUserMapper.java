package tk.leaflame.websocketdemo.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.leaflame.websocketdemo.entity.User;
import tk.leaflame.websocketdemo.service.UserService;

/**
 * @author leaflame
 * @date 2019/11/15 2:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class TestUserMapper {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;

    @Test
    void testLoadUserByUserName() {
        String username = "leaf";
        System.out.println(userMapper);
        User user = userMapper.loadUserByUserName(username);
        if (user != null)
            System.out.println(user.toString());
    }

    @Test
    void testRegUser() {
        User user = new User();
        user.setUserId(100003L);
        user.setUsername("sdcs5c");
        user.setPassword("3sdc15sc");
        System.out.println(userMapper.regUser(user.getUserId(), user.getUsername(), user.getPassword()));
    }

    @Test
    void testGetAdmin() {
        System.out.println(adminMapper.getAdminById(1L));
    }

}
