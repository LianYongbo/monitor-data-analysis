package com.bdilab.monitor.business.userManagement.userInfoManagement.dao;

import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(String userMobile);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userMobile);

    List<User> selectFuzzyByMobile (@Param("mobile") String userMobile, @Param("organizationId")String organizationId,@Param("workspaceId")String workspaceId);

    List<User> selectFuzzyByName (@Param("name") String userName, @Param("organizationId")String organizationId,@Param("workspaceId")String workspaceId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}