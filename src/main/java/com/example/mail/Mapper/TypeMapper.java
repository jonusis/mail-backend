package com.example.mail.Mapper;

import com.example.mail.Pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
    List<Type> queryTypeList();

    Type queryTypeByTid(int tid);

    void addType(Type user);

    void updateType(Type user);

    void deleteType(int tid);

    int selectIdMaxType();
}
