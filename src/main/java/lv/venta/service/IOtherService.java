package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Child;
import lv.venta.model.ChildRating;

public interface IOtherService {


	public abstract ArrayList<ChildRating> selectAllRatingsByChildId(int id) throws Exception;
	
	public abstract ArrayList<ChildRating> selectAllRatingWhereRatingIsLow() throws Exception;
	
	public abstract ArrayList<Child> selectAllChildByGroupYear(int year) throws Exception;
	
	public abstract ArrayList<Child> selectAllChildByAllergiesOLA() throws Exception;
	
	public abstract void insertChildRatingByChildId(ChildRating childRating,int id) throws Exception;
	
}
