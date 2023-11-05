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
import java.util.List;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
public class SearchController {
    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("columnChoices", ListController.columnChoices);
        return "search";
    }

    @PostMapping("/search/results")
    public String displaySearchResults(
            @RequestParam("searchType") String searchType,
            @RequestParam("searchTerm") String searchTerm,
            Model model) {
        ArrayList<Job> jobs;

        if ("all".equals(searchType) || searchTerm.isEmpty()) {
            jobs = JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("columnChoices", ListController.columnChoices);
        return "search";
    }
}
