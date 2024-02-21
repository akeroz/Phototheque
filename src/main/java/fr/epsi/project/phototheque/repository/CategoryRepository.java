package fr.epsi.project.phototheque.repository;

import fr.epsi.project.phototheque.entity.Category;
    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}