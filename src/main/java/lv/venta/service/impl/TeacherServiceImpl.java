package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Teacher;
import lv.venta.repo.ITeacherRepo;
import lv.venta.service.ITeacherCRUDService;

@Service
public class TeacherServiceImpl implements ITeacherCRUDService {
	
	@Autowired
	private ITeacherRepo teacherRepo;

	@Override
	public ArrayList<Teacher> selectAllTeachers() throws Exception {
		ArrayList<Teacher> result = (ArrayList<Teacher>) teacherRepo.findAll();
		if(result.isEmpty()) throw new Exception("No teachers in DB");
		return result;
	}

	@Override
	public Teacher selectTeacherById(int id) throws Exception {
		if(id < 0) throw new Exception("ID must be positive");
		Teacher result = teacherRepo.findById(id).get();
		if(result == null) throw new Exception("Teacher doesn't exist");
		return result;
	}

	@Override
	public void deleteTeacherById(int id) throws Exception {
		if(id < 0) throw new Exception("ID must be positive");
		Teacher deleteTeacher = teacherRepo.findById(id).get();
		if(deleteTeacher != null) teacherRepo.delete(deleteTeacher);
		else {
			throw new Exception("Teacher doesn't exist");
		}
		
	}

	@Override
	public void insertNewTeacher(Teacher teacher) throws Exception {
		Teacher newTeacher = teacherRepo.findByNameAndSurname(teacher.getName(), teacher.getSurname());
		if(newTeacher != null) throw new Exception("Teacher already exist");
		teacherRepo.save(teacher);
	}

	@Override
	public void updateTeacherById(int id, Teacher teacher) throws Exception {
		Teacher updateTeacher = teacherRepo.findById(id).get();
		if(updateTeacher == null) throw new Exception("Teacher doesn't exist");
		updateTeacher.setName(teacher.getName());
		updateTeacher.setSurname(teacher.getSurname());
		updateTeacher.setChildrenGroups(teacher.getChildrenGroups());
		teacherRepo.save(updateTeacher);
	}

}
