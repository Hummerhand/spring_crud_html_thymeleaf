package com.example.spring_crud_html_thymeleaf.repository;


import com.example.spring_crud_html_thymeleaf.entity.Tutorial;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    public List<Tutorial> findByTitleContaining(String title);

    public List<Tutorial> findByPublished(boolean published);

    @Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
    @Modifying
    public void updatePublishedStatus(Integer id, boolean published);


}
