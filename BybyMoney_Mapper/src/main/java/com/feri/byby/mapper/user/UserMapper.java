package com.feri.byby.mapper.user;
import com.feri.byby.domain.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);
    User selectByName(String name);
    int updatePassword(@Param("id")int id,@Param("password") String password);
    int updateFlag(@Param("id") int id,@Param("flag") int flag);
    long selectCount();
    List<User> selectPage(@Param("index") int index, @Param("count") int count);
}