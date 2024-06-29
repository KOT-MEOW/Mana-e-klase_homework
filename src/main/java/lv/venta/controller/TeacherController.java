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
import lv.venta.model.Teacher;
import lv.venta.service.ITeacherCRUDService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private ITeacherCRUDService teacherCRUDService;
	
	@GetMapping("/showAll") //localhost:8080/teacher/showAll
	public String getAllTeacher(Model model) {
		try {
			ArrayList<Teacher> allTeachers = teacherCRUDService.selectAllTeachers();
			model.addAttribute("mydata", allTeachers);
			model.addAttribute("msg", "All teachers");
			return "teacher-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	
	@GetMapping("/showAll/{id}") //localhost:8080/teacher/showAll/{id}
	public String getTeacherById(@PathVariable("id") int id, Model model) {
		try {
			Teacher selectTeacher = teacherCRUDService.selectTeacherById(id);
			model.addAttribute("mydata", selectTeacher);
			model.addAttribute("msg", "Select teacher");
			return "teacher-one-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	
	/*
	  Error:
could not execute statement [Cannot delete or update a parent row: a foreign key constraint fails (`mana_e_klase_homework`.`children_group_table`, CONSTRAINT `FKk9xoc1nb4cd1w3vss4epiv4pm` FOREIGN KEY (`idt`) REFERENCES `teacher_table` (`idt`))] [delete from teacher_table where idt=?]; SQL [delete from teacher_table where idt=?]; constraint [null]
	 */
	
	@GetMapping("/remove/{id}") //localhost:8080/teacher/remove/{id}
	public String getTeacherDeleteById(@PathVariable("id") int id, Model model) {
		try {
			teacherCRUDService.deleteTeacherById(id);
			ArrayList<Teacher> allTeachers = teacherCRUDService.selectAllTeachers();
			model.addAttribute("mydata", allTeachers);
			model.addAttribute("msg", "All teachers (no deleted teacher)");
			return "teacher-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	

	// not working if try add ChildrenGroup
	@GetMapping("/addNew") //localhost:8080/teacher/addNew
	public String getTeacherInsert(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacher-add-page";
	} 
	
	@PostMapping("/addNew") 
	public String postTeacherInsert(@Valid Teacher teacher, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "teacher-add-page";
		} else {
			teacherCRUDService.insertNewTeacher(teacher);
			return "redirect:/teacher/showAll";
		}
	}
	
	
	@GetMapping("/update/{id}") //localhost:8080/teacher/update/{id}
	public String getTeacherUpdateById(@PathVariable("id") int id, Model model) {
		try {
			Teacher teacherForUpdate = teacherCRUDService.selectTeacherById(id);
			model.addAttribute("teacher",teacherForUpdate);
			model.addAttribute("id", id);
			return "teacher-update-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@PostMapping("/update/{id}")
	public String postTeacherUpdateById(@PathVariable("id") int id, 
			@Valid Teacher teacher, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "teacher-update-page";
		}else {
			try {
				teacherCRUDService.updateTeacherById(id, teacher);
				return "redirect:/teacher/showAll/"+ id;
			} catch (Exception e) {
				model.addAttribute("mydata", e.getMessage());
				return "error-page";
			}
		}
	}
	
}
