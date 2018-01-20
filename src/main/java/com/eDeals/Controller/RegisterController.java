package com.eDeals.Controller;

import com.eDeals.Model.Profile;
import com.eDeals.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    ProfileService profileService;



    @RequestMapping("/register")
    public String registerProfile(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerProfilePost(@Valid @ModelAttribute("profile") Profile profile, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        List<Profile> profileList = profileService.getAllProfiles();
        for (int i = 0; i < profileList.size(); i++) {
            if (profile.getEmail().equals(profileList.get(i).getEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "register";
            }

            if (profile.getUsername().equals(profileList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "register";
            }
        }
        profile.setEnabled(true);
        profileService.addProfile(profile);

        return "registerSuccess";
    }

}
