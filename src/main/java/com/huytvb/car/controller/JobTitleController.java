package com.huytvb.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytvb.car.models.JobTitle;
import com.huytvb.car.services.JobTitleService;

@Controller
public class JobTitleController {
	
	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("/jobtitle")
	public String goJobtitle(Model model) {

		List<JobTitle> jobtitleList = jobTitleService.getJobtitles();

		model.addAttribute("jobtitles", jobtitleList);

		return "jobtitle";
	}

	@PostMapping("/jobtitle/addNew")
	public String addNew(JobTitle jobtitle) {
		jobTitleService.save(jobtitle);

		return "redirect:/jobtitle";
	}

	@RequestMapping("jobtitle/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id) {

		return jobTitleService.findById(id);
	}

	@RequestMapping(value = "/jobtitle/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(JobTitle jobtitle) {
		jobTitleService.save(jobtitle);

		return "redirect:/jobtitle";
	}

	@RequestMapping(value = "/jobtitle/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		jobTitleService.delete(id);

		return "redirect:/jobtitle";
	}
}
