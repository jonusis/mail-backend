package com.example.mail.Service;

import com.example.mail.Mapper.CategoryMapper;
import com.example.mail.Pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorycrudService {
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> queryCategory(String category, String type) {
        List<Category> categoryList = null;
        categoryList = categoryMapper.queryCategory(category,type);
        return categoryList;
    }
}
