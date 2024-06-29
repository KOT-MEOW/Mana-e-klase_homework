package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Child;
import lv.venta.service.IChildService;

@Controller
@RequestMapping("/child")
public class ChildController {

	@Autowired
	private IChildService childService;
	
	// working but Group output looks like:
	// ChildrenGroup(id=1, title=Sawaqasa, year=2023, teacher=Teacher(id=1, name=Anton, surname=Sakraev))
	@GetMapping("/showAll/{id}") //localhost:8080/child/showAll/{id}
	public String getAllChildByIdGroup(@PathVariable("id") int id,Model model) {
		try {
			ArrayList<Child> allChilds = childService.selectAllChildInGroupByGroupId(id);
			model.addAttribute("mydata", allChilds);
			model.addAttribute("msg", "All childrens");
			return "child-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	//looks like working
	@GetMapping("/remove/{groupid}/{childid}") //localhost:8080/child/remove/{groupid}/{childid}
	public String getTeacherDeleteById(@PathVariable("groupid") int groupId, @PathVariable("childid") int childId, Model model) {
		try {
			childService.deleteChildByIdFromGroupById(groupId,childId);
			ArrayList<Child> allChildrenInGroup = childService.selectAllChildInGroupByGroupId(groupId);
			 model.addAttribute("mydata", allChildrenInGroup);
			 model.addAttribute("msg", "Child with ID " + childId + " removed from group with ID " + groupId);
			return "child-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	
	//Get un Post - /child/addNew/{groupid}
	
	//Get - /child/changeGroup/{childId}/{newGroupId}
	
}
