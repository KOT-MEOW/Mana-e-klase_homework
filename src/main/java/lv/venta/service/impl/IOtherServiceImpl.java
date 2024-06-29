package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Child;
import lv.venta.model.ChildRating;
import lv.venta.model.RaitingValues;
import lv.venta.repo.IChildRatingRepo;
import lv.venta.repo.IChildRepo;
import lv.venta.service.IOtherService;

@Service
public class IOtherServiceImpl implements IOtherService {
	
	@Autowired
	private IChildRatingRepo childRatingRepo;
	
	@Autowired
	private IChildRepo childRepo;

	@Override
	public ArrayList<ChildRating> selectAllRatingsByChildId(int id) throws Exception {
		if(id < 0) throw new Exception("ID must be positive");
		ArrayList<ChildRating> result = childRatingRepo.findBychildId(id);
		if(result.isEmpty()) throw new Exception("No raiting in DB");
		return result;
	}

	@Override
	public ArrayList<ChildRating> selectAllRatingWhereRatingIsLow() throws Exception {
		ArrayList<ChildRating> result = childRatingRepo.findByValue(RaitingValues.nav_apguts);
		if(result.isEmpty()) throw new Exception("No low rating in DB");
		return result;
	}

	@Override
	public ArrayList<Child> selectAllChildByGroupYear(int year) throws Exception {
		ArrayList<Child> result = childRepo.findByChildrenGroupYear(year);
		if(result.isEmpty()) throw new Exception("This year group dosen't exist");
		return result;
	}

	@Override
	public ArrayList<Child> selectAllChildByAllergiesOLA() throws Exception {
		ArrayList<Child> result = childRepo.findByAllergiesIgnoreCase("ola");
		if(result.isEmpty()) throw new Exception("No allergies");
		return result;
	}

	@Override
	public void insertChildRatingByChildId(ChildRating childRating,int id) throws Exception {
		if(id < 0) throw new Exception("ID must be positive");
		Child child = childRepo.findById(id).get();
		if(child == null) throw new Exception("No child with this ID");
		
		ChildRating newChildRating = new ChildRating();
		newChildRating.setEvaluationTitle(childRating.getEvaluationTitle());
		newChildRating.setValue(childRating.getValue());	
	}

}
