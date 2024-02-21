package fr.epsi.project.phototheque.service;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.repository.ImageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageService {


    ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    public Page<Image> getAll(Pageable page){
        return this.imageRepository.findAll(page);
    }

    public Image getById(long id){
        return this.imageRepository.getById(id);
    }

    public Image save(Image image){
        return this.imageRepository.save(image);
    }


}
