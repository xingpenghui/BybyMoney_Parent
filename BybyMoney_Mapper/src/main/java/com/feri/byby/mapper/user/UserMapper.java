package com.feri.byby.mapper.user;
import com.feri.byby.domain.user.User;
import org.apache.ibatis.annotations.Param;
public interface UserMapper {
    int insert(User record);
    User selectByName(String name);
    int updatePassword(@Param("id")int id,@Param("password") String password);
    int updateFlag(@Param("id") int id,@Param("flag") int flag);
}