package fr.epsi.project.phototheque.repository;

import fr.epsi.project.phototheque.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
