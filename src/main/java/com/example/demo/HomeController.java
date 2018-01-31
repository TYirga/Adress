package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    adressBookRepository cRepository;

    @RequestMapping("/")
    public String listAdress(Model model) {
        model.addAttribute("adresses", cRepository.findAll());
        return "list";

    }

    @GetMapping("/add")
    public String adressForm(Model model) {
        model.addAttribute("adress", new adressBook());
        return "adressform";
    }

    @PostMapping("/process")
    public String processForm(@Valid adressBook adress, BindingResult result) {
        if (result.hasErrors()) {
            return "adressform";

        }
        cRepository.save(adress);
        return "redirect:/";

    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("adress", cRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateAdress(@PathVariable("id") long id, Model model) {
        model.addAttribute("adress", cRepository.findOne(id));
        return "adressform";
    }

    @RequestMapping("/delete/{id}")
    public String delAdress(@PathVariable("id") long id) {
        cRepository.delete(id);
        return "redirect: /";
    }
    @RequestMapping("/search/{id}")
    public String findAdressBookByEmail(@PathVariable("email") String email, Model model) {
       // List<adressBook> adresses=adressBookRepository.findAdressBookByEmail(email);
       //model.addAttribute("adress", adresses);
       return "list";

    }
}
