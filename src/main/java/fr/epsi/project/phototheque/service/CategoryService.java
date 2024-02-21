package fr.epsi.project.phototheque.service;

import fr.epsi.project.phototheque.entity.Category;
import fr.epsi.project.phototheque.entity.User;
import fr.epsi.project.phototheque.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional(readOnly = true)
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository;}

    public Page<Category> findAll(Pageable page) {return this.categoryRepository.findAll(page);}

    public Optional<Category> findCategoryById(Long id){
        return this.categoryRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public Category  save(Category category){
        return this.categoryRepository.save(category);
    }

}
