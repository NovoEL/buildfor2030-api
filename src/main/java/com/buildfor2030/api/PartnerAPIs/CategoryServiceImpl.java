package com.buildfor2030.api.PartnerAPIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryVO> retrieveAllCategories() {
        return convertToCategoryVOs(categoryRepository.findAll());
    }

    private List<CategoryVO> convertToCategoryVOs(List<Category> categories) {
        List<CategoryVO> categoryVOs = new ArrayList<>();
        for (Category category : categories) {
            categoryVOs.add(new CategoryVO(category));
        }
        return categoryVOs;
    }

}
