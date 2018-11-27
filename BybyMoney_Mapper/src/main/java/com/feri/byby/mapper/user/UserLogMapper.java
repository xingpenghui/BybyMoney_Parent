package com.feri.byby.mapper.user;

import com.feri.byby.domain.user.UserLog;

import java.util.List;

public interface UserLogMapper {
    int insert(UserLog record);
    List<UserLog> selectAll();
}