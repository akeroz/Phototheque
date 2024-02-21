package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.entity.User;
import fr.epsi.project.phototheque.service.CategoryService;
import fr.epsi.project.phototheque.service.UserService;
import fr.epsi.project.phototheque.v1.dto.CategoryDto;
import fr.epsi.project.phototheque.v1.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public Page<CategoryDto> findAll(Pageable pageable){
        return this.categoryService.findAll(pageable)
                .map(it -> new CategoryDto(it.getId(), it.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findUserById(@PathVariable(name = "id") Long id){
        var category = this.categoryService.findCategoryById(id);
        return ResponseEntity.of(category.map(it -> new CategoryDto(it.getId(), it.getName())));
    }
}
