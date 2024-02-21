package fr.epsi.project.phototheque.service;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.repository.CategoryRepository;
import fr.epsi.project.phototheque.repository.ImageRepository;
import fr.epsi.project.phototheque.v1.dto.ImageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageService {


    ImageRepository imageRepository;
    CategoryRepository categoryRepository;


    public ImageService(ImageRepository imageRepository, CategoryRepository categoryRepository){
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
    }

    public Page<Image> getAll(Pageable page){
        return this.imageRepository.findAll(page);
    }

    public Image getById(long id){
        return this.imageRepository.getById(id);
    }

    public Image save(ImageDto image){
        Image image1 = new Image();
        image1.setCategory(categoryRepository.getById(1L));
        image1.setContent(image.getContent());
        image1.setName(image.getName());
        image1.setHasHuman(image.getHasHuman());
        image1.setDate(image.getDate());
        image1.setDescription(image.getDescription());
        return this.imageRepository.save(image1);
    }


}
