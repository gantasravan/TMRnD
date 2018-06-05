//package guru.springframework.controllers;
//
//import guru.springframework.commands.ProductForm;
//import guru.springframework.converters.ProductToProductForm;
//import guru.springframework.domain.Product;
//import guru.springframework.services.ProductService;
//import guru.springframework.services.TeamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.validation.Valid;
//
///**
// * Created by jt on 1/10/17.
// */
//@Controller
//public class TeamController {
//    @Autowired
//    private TeamService teamService;
//
//
//    @RequestMapping("/")
//    public String redirToList() {
//        return "redirect:/team/list";
//    }
//
//    @RequestMapping({"/team/list", "/team"})
//    public String listTeams(Model model) {
//        teamService.insertTeamData();
////        model.addAttribute("products", productService.listAll());
//        return "team/list";
//    }
//}
