package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
//import java.util.List;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {
    @GetMapping(value = "")
    public String searchForm(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(
            Model model,
            @RequestParam("searchType") String searchType,
            @RequestParam("searchTerm") String searchTerm
            ) {
        ArrayList<Job> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);
        return "search";


    }
}
