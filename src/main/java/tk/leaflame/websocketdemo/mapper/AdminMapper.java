package tk.leaflame.websocketdemo.mapper;

import org.apache.ibatis.annotations.Param;
import tk.leaflame.websocketdemo.entity.Admin;

/**
 * @author leaflame
 * @date 2019/11/15 13:10
 */
public interface AdminMapper {

    Admin getAdminById(@Param("id") Long id);
}
