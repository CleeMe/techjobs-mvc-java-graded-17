package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/search/results")
    public String displaySearchResults(@RequestParam("searchType") String type, @RequestParam("searchTerm") String  term, Model model) {
        ArrayList<Job>  jobs;
        if ("all".equals(type) || term.isEmpty()) {
            jobs = JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(type, term);
        }
        model.addAttribute("jobs", jobs);
        model.addAttribute("columnChoices", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

}

