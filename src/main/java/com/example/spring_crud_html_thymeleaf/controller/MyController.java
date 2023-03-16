package com.example.spring_crud_html_thymeleaf.controller;


import com.example.spring_crud_html_thymeleaf.entity.Tutorial;
import com.example.spring_crud_html_thymeleaf.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private TutorialService service;

    @GetMapping("/tutorials")
    public String showAllTutorials(Model model) {

        List<Tutorial> tutorials = service.getAllTutorials();
        model.addAttribute("tutorials", tutorials);

        return "tutorials";
    }


    @RequestMapping("/addTutorial")
    public String addTutorial(Model model) {

        Tutorial tutorial = new Tutorial();
        tutorial.setPublished(true);

        model.addAttribute("tutorial", tutorial);
        model.addAttribute("pageTitle", "Create new Tutorial");

        return "tutorial_form";
    }



    @PostMapping("/saveTutorial")
    public String saveTutorial(@ModelAttribute("tutor") Tutorial tutorial) {

        service.saveTutorial(tutorial);

        return "redirect:/tutorials";
    }

    @RequestMapping("/updateInfo")
    public String updateTutorial(@RequestParam("tutorialId") int id, Model model) {

        Tutorial tutorial = service.getTutorial(id);
        model.addAttribute("tutorial", tutorial);

        return "tutorial_form";
    }

    @RequestMapping("/deleteTutorial")
    public String deleteTutorial(@PathVariable int id) {

        service.deleteTutorial(id);

        return "redirect:/tutorials";
    }


    /*
    @GetMapping("/tutorials/title/{title}")
    public List<Tutorial> showAllTutorialByTitleContaining(@PathVariable String title) {

        List<Tutorial> tutorials = service.findByTitleContaining(title);

        return tutorials;
    }

    @GetMapping("/tutorials/published/{published}")
    public List<Tutorial> showfindByPublished(@PathVariable boolean published) {

        List<Tutorial> tutorials = service.findByPublished(published);

        return tutorials;
    }
    */
}
