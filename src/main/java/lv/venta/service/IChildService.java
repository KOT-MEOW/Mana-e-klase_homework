package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Child;

public interface IChildService {

	public abstract ArrayList<Child> selectAllChildInGroupByGroupId(int id) throws Exception;
	
	public abstract void deleteChildByIdFromGroupById(int idgr, int idch) throws Exception;

	public abstract void insertNewChildInGroupById(int idgr) throws Exception;

	public abstract void changeChildByIdGroupById(int id) throws Exception;

	
	
}
