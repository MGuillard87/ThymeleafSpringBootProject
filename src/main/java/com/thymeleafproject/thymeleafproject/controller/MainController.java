package com.thymeleafproject.thymeleafproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.thymeleafproject.thymeleafproject.form.CharacterForm;
import com.thymeleafproject.thymeleafproject.model.Character;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
MainController est une classe  Controller. Il traite les demandes d'un utilisateur et contrôle le flux (flow) de
l'application.
*/
@Controller
public class MainController {
    private static List<Character> characters = new ArrayList<Character>();

    static {
        characters.add(new Character(0, "Bill", "Guerrier"));
        characters.add(new Character(1, "Merlin", "Magicien"));
        characters.add(new Character(2,"Clochette", "Magicien"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @Value("${error.messageId}")
    private String errorMessageId;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/characterList" }, method = RequestMethod.GET)
    public String characterList(Model model) {

        model.addAttribute("characters", characters);

        return "characterList";
    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.GET)
    public String showAddCharacterPage(Model model) {

        CharacterForm personForm = new CharacterForm();
        model.addAttribute("characterForm", personForm);

        return "addCharacter";
    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.POST)
    public String saveCharacter(Model model, //
         @ModelAttribute("characterForm") CharacterForm characterForm) {

        int id = characterForm.getId();
        String nom = characterForm.getNom();
        String type = characterForm.getType();
        Character characterFindById = this.findById(id);

        if(nom == null || nom.length() == 0
                || type == null || type.length() == 0){
            model.addAttribute("errorMessage", errorMessage);
            return "addCharacter";
        }
        if(characterFindById != null){
            model.addAttribute("errorMessageId", errorMessageId);
            return "addCharacter";
        }

        Character newCharacter = new Character(id,nom, type);
        characters.add(newCharacter);

        return "redirect:/characterList";

    }


    public Character findById(int id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

}
