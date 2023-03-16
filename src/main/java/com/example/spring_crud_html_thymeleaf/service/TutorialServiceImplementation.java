package com.example.spring_crud_html_thymeleaf.service;


import com.example.spring_crud_html_thymeleaf.entity.Tutorial;
import com.example.spring_crud_html_thymeleaf.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImplementation implements TutorialService {

    @Autowired
    TutorialRepository repository;

    @Override
    public List<Tutorial> getAllTutorials() {

        return repository.findAll();
    }

    @Override
    public void saveTutorial(Tutorial tutorial) {

        repository.save(tutorial);
    }

    @Override
    public Tutorial getTutorial(int id) {

        Tutorial tutorial = null;

        Optional<Tutorial> optional = repository.findById(id);
        if(optional.isPresent()) {
            tutorial = optional.get();
        }

        return tutorial;
    }

    @Override
    public void deleteTutorial(int id) {

        repository.deleteById(id);
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {

        List<Tutorial> tutorials = repository.findByTitleContaining(title);

        return tutorials;
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {

        List<Tutorial> tutorials = repository.findByPublished(published);

        return tutorials;
    }


}
