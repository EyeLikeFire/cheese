package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    static HashMap<String, String> cheeseMap = new HashMap<>();
    static ArrayList<Cheese> cheeseArr = new ArrayList<>(); //Mind blown \(@o@)/ use name of class instead of 'object'



    @RequestMapping(value="")
    public String index(Model model){

        //Used for testing:
        //        Cheese bree = new Cheese("Bree", "It Stinks");
        //
        //        cheeseArr.add(new Cheese("Smoked Guda", "It's the best"));
        //        cheeseArr.add(new Cheese("Pepper Jack", "Some people say it's spicy?"));
        //        cheeseArr.add(bree);

        model.addAttribute("cheeseArr", cheeseArr);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese"); //This is just giving the html page a title
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDesecription){
        //cheeseMap.put(cheeseName, cheeseDesecription);
        cheeseArr.add(new Cheese(cheeseName, cheeseDesecription));
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteCheeseAction(Model model){

        model.addAttribute("cheeseMap", cheeseArr);
        model.addAttribute("title", "My Cheeses");

        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteCheeseDisplay(@RequestParam ArrayList<String> cheeseNameList){

        ArrayList<Cheese> tempCheeseList = new ArrayList<>();


        for(int i = 0; i < cheeseArr.size(); i++){
            //If arraylist of names doesnt have name of object in an if arraylist of objects...
            if(!cheeseNameList.contains(cheeseArr.get(i).getName())) {
                //add object from arraylist of objects to new array list...
                tempCheeseList.add(cheeseArr.get(i));
            }
        }

        cheeseArr = tempCheeseList;

        return "redirect:";
    }
}

