package com.example.spring_crud_html_thymeleaf.service;



import com.example.spring_crud_html_thymeleaf.entity.Tutorial;

import java.util.List;


public interface TutorialService {

   public List<Tutorial> getAllTutorials();

   public void saveTutorial(Tutorial tutorial);

   public Tutorial getTutorial(int id);

   public void deleteTutorial(int id);

   public List<Tutorial> findByTitleContaining(String title);

   public List<Tutorial> findByPublished(boolean published);

}
