package tk.leaflame.websocketdemo.mapper;

//import org.junit.jupiter.api.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.leaflame.websocketdemo.entity.User;
import tk.leaflame.websocketdemo.service.UserService;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author leaflame
 * @date 2019/11/15 2:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {

    //    @Autowired
//    UserMapper userMapper;
    //
    @Autowired
    UserService userService;
//
//    @Autowired
//    AdminMapper adminMapper;

    private void generateThreads(String username) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                new Thread(() -> {
                    Optional.ofNullable(
                            userService.loadUserByUsername(username)
                    ).ifPresent(System.out::print);
                    System.out.println(" " + Thread.currentThread().getName());
                }, "Thread-" + i).start());
    }

    @Test
    public void testLoadUserByUserName() {
        long start = System.currentTimeMillis();
        String username = "tester";
//        System.out.println(userMapper);
//        for (int i = 1; i <= 100; i++) {
//            User user = userMapper.loadUserByUserName(username);
//            if (user != null)
//                System.out.println(user.toString());
//        }
        generateThreads(username);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void testCacheableLoadUserByUserName() {
        long start = System.currentTimeMillis();
        String username = "tester";
//        for (int i = 1; i <= 100; i++) {
//            User user = (User) userService.loadUserByUsername(username);
//            if (user != null)
//                System.out.println(user.toString());
//        }
        generateThreads(username);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
//
//    @Test
//    void testRegUser() {
//        User user = new User();
//        user.setUsername("sd5v4dsv45");
//        user.setPassword("3sdc15sc");
//        user.setEmail("6dsv48@orjb.com");
//        System.out.println(userService.regUser(user));
//    }
//
//    @Test
//    void testGetAdmin() {
//        System.out.println(adminMapper.getAdminById(1L));
//    }

}
