package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.ChildRating;
import lv.venta.model.RaitingValues;

public interface IChildRatingRepo extends CrudRepository<ChildRating, Integer> {

	ArrayList<ChildRating> findBychildId(int id);

	ArrayList<ChildRating> findByValue(RaitingValues navApguts);

}
