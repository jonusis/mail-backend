package com.example.mail.Mapper;
import com.example.mail.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int uid);

    void addUser(User user);

    int updateUser(User user);

    int deleteUser(int uid);

    int selectIdMaxUser();

    List<User> selectUserLogin(String account,String password);
}
