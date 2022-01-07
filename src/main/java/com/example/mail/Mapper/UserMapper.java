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

    void updateUser(User user);

    void deleteUser(int uid);

    int selectIdMaxUser();

    List<User> selectUserLogin(String account,String password);

    List<User> queryUserByName(String name);

    List<User> searchUser(String name, String account, int age, int sex);
}
