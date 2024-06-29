package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Teacher;

public interface ITeacherCRUDService {

	public abstract ArrayList<Teacher> selectAllTeachers() throws Exception;
	
	public abstract Teacher selectTeacherById(int id) throws Exception;

	public abstract void deleteTeacherById(int id) throws Exception;
	
	public abstract void insertNewTeacher(Teacher teacher) throws Exception;
	
	public abstract void updateTeacherById(int id,Teacher teacher) throws Exception;
	
}
