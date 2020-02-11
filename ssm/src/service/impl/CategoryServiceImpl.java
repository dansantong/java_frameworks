package service.impl;

import mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Category;
import service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    //由spring自动装配
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> list(){
        return categoryMapper.list();
    }

}
