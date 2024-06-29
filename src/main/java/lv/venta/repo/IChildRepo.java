package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Child;

public interface IChildRepo extends CrudRepository<Child, Integer> {

}
