package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Teacher;

public interface ITeacherRepo extends CrudRepository<Teacher, Integer> {

}
