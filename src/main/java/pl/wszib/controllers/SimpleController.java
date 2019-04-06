package pl.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController() {
        listPerson = generateList();
    }

    @GetMapping("basic")
    public String basic(Model model){
        String firstName = "Jan";
        String lastName = "Kowalski";
        model.addAttribute("fName", firstName);
        model.addAttribute("lName", lastName);

        Person person = new Person();
        person.setFirstName("Dominika");
        person.setLastName("Dudek");
        person.setPhoneNumber("76512349");
        person.setSalary(10000.00);
        person.setVisible(true);

        model.addAttribute("person", person);

        return "basicTemplate";
    }

    @GetMapping("iteration")
    public String iteration(Model model){

//        List<Person> list = generateList();
        model.addAttribute("list", listPerson);

        return "iterationTemplate";

    }

    @GetMapping("links")
    public String links (Model model){

        return  "linksTemplate";
    }

    @GetMapping("inter")
    public  String inter (Model model){
        return "interTemplate";
    }

    @GetMapping("forms")
    public String forms (Model model){

        model.addAttribute("person", new Person());
        return "formsTemplate";
    }

    @PostMapping("formsSave")
    public String formsSave (Person person, Model model){

        listPerson.add(person);
        return "successTemplate";
    }



    private List<Person> generateList(){

        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Dominika");
        person1.setLastName("Dudek");
        person1.setPhoneNumber("76512349");
        person1.setSalary(10000.00);
        person1.setVisible(true);

        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Dorota");
        person2.setLastName("Puzio");
        person2.setPhoneNumber("876523495");
        person2.setSalary(300000.00);
        person2.setVisible(true);

        list.add(person2);

        Person person = new Person();
        person.setFirstName("Anna");
        person.setLastName("Takase");
        person.setPhoneNumber("77346954");
        person.setSalary(3000.00);
        person.setVisible(false);

        list.add(person);

        return list;
    }

@GetMapping("fragments")
    public String fragments (Model model){
        return "fragments/fragmentsTemplate";
}

    @GetMapping("fragmentsT")
    public String fragments2 (Model model){
        return "fragments/fragmentsTemplateT";
    }
}
