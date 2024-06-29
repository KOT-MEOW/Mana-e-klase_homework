package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Child;

public interface IChildRepo extends CrudRepository<Child, Integer> {

	ArrayList<Child> findByChildrenGroupId(int id);

	Child findByNameAndSurnameAndChildrenGroupId(String name, String surname, int idgr);

	ArrayList<Child> findByChildrenGroupYear(int year);

	ArrayList<Child> findByAllergiesIgnoreCase(String string);



}
