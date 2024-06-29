package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.model.Child;
import lv.venta.model.ChildRating;
import lv.venta.service.IOtherService;

@Controller
@RequestMapping("/other")
public class OtherController {

	@Autowired
	private IOtherService otherService;
	
	@GetMapping("/child/rating/{childid}") //localhost:8080/other/child/rating/{childid}
	public String getChildRating(@PathVariable("childid") int childid, Model model) {
		try {
			ArrayList<ChildRating> childRating = otherService.selectAllRatingsByChildId(childid);
			model.addAttribute("mydata", childRating);
			model.addAttribute("msg", "All Raiting");
			return "child-rating-show-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/rating/all/low") //localhost:8080/other/rating/all/low
	public String getAllLow(Model model) {
		try {
			ArrayList<ChildRating> childRating = otherService.selectAllRatingWhereRatingIsLow();
			model.addAttribute("mydata", childRating);
			model.addAttribute("msg", "low rating");
			return "child-rating-show-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}
	
	
	@GetMapping("/child/group/{year}") //localhost:8080/other/child/group/{year}
	public String getAllChildInGroupByYear(@PathVariable("year") int year,Model model) {
		try {
			ArrayList<Child> childs = otherService.selectAllChildByGroupYear(year);
			model.addAttribute("mydata", childs);
			model.addAttribute("msg", "all childrens");
			return "child-all-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}
	
	
	@GetMapping("/child/allergyOla") //localhost:8080/other/child/allergyOla
	public String getChildAllergyOla(Model model) {
		try {
			ArrayList<Child> childsAllergies = otherService.selectAllChildByAllergiesOLA();
			model.addAttribute("mydata", childsAllergies);
			model.addAttribute("msg", "all childrens with alergies ola");
			return "child-all-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}

	// not working tamplate empty
	@GetMapping("/child/rating/addNew/{childid}") //localhost:8080/other/child/rating/addNew/{childid}
	public String getChildRatingAdd(@PathVariable("childid") int childid,Model model) {
		model.addAttribute("childRating", new ChildRating());
		return "child-rating-add-page";
	} 
	
	@PostMapping("/child/rating/addNew/{childid}") 
	public String postChildRatingAdd(@PathVariable("childid") int childid, @Valid ChildRating childRating, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "child-rating-add-page";
		} else {
			otherService.insertChildRatingByChildId(childRating, childid);
			return "redirect:/other/rating/child-rating-show-page";
		}
	}
}
