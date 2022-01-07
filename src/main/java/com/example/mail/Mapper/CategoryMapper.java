package com.example.mail.Mapper;

import com.example.mail.Pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    List<Category> queryCategory (String category, String type);
}
