package tk.leaflame.websocketdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.leaflame.websocketdemo.entity.User;

/**
 * @author leaflame
 * @date 2019/11/14 20:46
 */
//@Mapper
public interface UserMapper {

    User loadUserByUserName(String username);

    int regUser(@Param("user") User user);

    int updateUser(User user);

    int deleteUser(Long userId);
}
