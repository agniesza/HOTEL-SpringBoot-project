package com.agacorporation.demo.component;

import com.agacorporation.demo.component.commands.UserFilter;
import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.User;
import com.agacorporation.demo.service.EmailService;
import com.agacorporation.demo.service.SecurityService;
import com.agacorporation.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping
@SessionAttributes("userForm")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    private final UserService userService;
    private final SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration.html";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("userForm", new User());
        return "addUser.html";
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/editUser.html", method= RequestMethod.GET)
    public String showFormUSR(Model model, Optional<Long> id){

        model.addAttribute("userForm",
                id.isPresent()?
                        userService.getUser(id.get()):
                        new User());
        System.out.println("login get: "+userService.getUser(id.get()).getLogin());
        return "editUser.html";
    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/editUser.html")
    public String editUser(@ModelAttribute("userForm") User userForm){
        System.out.println("login post: "+userForm.getLogin());
        userService.save(userForm);
        emailService.send(userForm.getEmail(), "Zmiana danych",
                "Dane na Twoim koncie zostały zmienione");
        return "redirect:userList.html";
    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
        userForm.setPassword(passwordEncoder.encode("testowe"));
        userService.save(userForm);
        emailService.send(userForm.getEmail(), "Witaj w hotelu woods!",
                "Rejesracja Twojego konta przebiegła pomyślnie. Twój login to:" + userForm.getLogin()+" Hasło do logowania to: testowe. Hasło zostało wygenerowane automatycznie. Proszę zmień hasło na stronie: www.woods.com");
        return "welcome.html";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userService.save(userForm);
        emailService.send(userForm.getEmail(), "Witaj w hotelu woods!",
                "Rejesracja Twojego konta przebiegła pomyślnie. Twój login to:" + userForm.getLogin()+" Zapraszamy na: www.woods.com");

        return "welcome.html";
    }

    @PostMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
       return "welcome.html";
      //  return "login.html";
    }
    @GetMapping("/login")
    public String login() {
         //  return "redirect:/welcome.html";
        return "login.html";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {

        return "welcome.html";
    }

    @GetMapping({"/contact"})
    public String contact(Model model) {
        return "contact.html";
    }

    @GetMapping({"/userDetails"})
    public String showUserDetails(Model model) {
        return "userDetails.html";
    }

    @GetMapping({"/accountDetails"})
        public String showAccountDetails(Model model) {
        return "accountDetails.html";
    }

    @RequestMapping(value="/reservationList.html", params = {"uid"}, method = RequestMethod.GET)
    public String showUserDetails(Model model, long uid){
        User u = userService.getUser(uid);
        model.addAttribute("user", u);

        return "userDetails";
    }
    //info about logged in user
    @RequestMapping(value="/accountDetails.html", method = RequestMethod.GET)
    public String showLoggedInUAccountDetails(Model model, Principal principal){

        model.addAttribute("user", userService.getUserByLogin(principal.getName()));
        System.out.println(userService.getUserByLogin(principal.getName()).getLogin());
        return "accountDetails";
    }

    @GetMapping(value="/userList.html", params = {"all"})
    public String resetUserList(@ModelAttribute("searchCommand") UserFilter search){
        search.clear();
        return "redirect:userList.html";
    }
    @RequestMapping(value="/userList.html", method = {RequestMethod.GET})
    public String showUserList(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") UserFilter search){

        model.addAttribute("userListPage", userService.getAllUsers(search, pageable));

        return "userList";
    }

    @RequestMapping(value="/userList.html", method = {RequestMethod.POST})
    public String showUserList2(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") UserFilter search){

        model.addAttribute("userListPage", userService.getAllUsers(search, pageable));
        System.out.println("fraza "+search.getPhrase());
        return "userList";
        // return "redirect:reservationList";
    }

    @PostMapping("/changePassword.html")
    public String changePassword(@ModelAttribute("userForm") User userForm, Principal principal) {


        return "accountDetails.html";
    }
    @GetMapping("/changePassword.html")
    public String changePassword(Model model) {
        model.addAttribute("userForm", new User());

        return "redirect:/accountDetails.html";
    }

    @RequestMapping(value="/userList.html", params = "id", method = RequestMethod.GET)
    public String deleteUser(long id, HttpServletRequest request){
        userService.deleteUser(id);
        return "deleteInfo";
    }
}
