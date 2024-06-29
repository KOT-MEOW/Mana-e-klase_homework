package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.model.Child;
import lv.venta.model.ChildrenGroup;
import lv.venta.repo.IChildRepo;
import lv.venta.repo.IChildrenGroupRepo;
import lv.venta.service.IChildService;

public class ChildServiceImpl implements IChildService {
	
	@Autowired
	private IChildRepo childRepo;
	
	@Autowired
	private IChildrenGroupRepo childrenGroupRepo;
	
	@Override
	public ArrayList<Child> selectAllChildInGroupByGroupId(int id) throws Exception {
		if(id < 0) throw new Exception("ID must be positive");
		ArrayList<Child> result = childRepo.findByChildrenGroupId(id);
		if(result.isEmpty()) throw new Exception("No children in that group");
		return result;
	}

	@Override
	public void deleteChildByIdFromGroupById(int idgr, int idch) throws Exception {
		if(idgr < 0 || idch < 0) throw new Exception("ID must be positive");
		
		// add check if exist group and child in group
		
		Child deleteChildFromGroup = childRepo.findById(idch).get();
		
		deleteChildFromGroup.setChildrenGroup(null);
		childRepo.save(deleteChildFromGroup);
	}

/*
	@Override
	public void insertNewChildInGroupById(int idgr) throws Exception {
		if(idgr < 0) throw new Exception("ID must be positive");
		
		ChildrenGroup childrenGroup = childrenGroupRepo.findById(idgr); // not worknig
		
		if(childrenGroup == null) throw new Exception("Group dosen't exist");

		Child newChild = new Child();
		newChild.setChildrenGroup(childrenGroup);
		
		childRepo.save(newChild);
	}
*/
	
	@Override
	public void insertNewChildInGroupById(int idgr) throws Exception {
	
	}
	
	@Override
	public void changeChildByIdGroupById(int id) throws Exception {
		
	}



}
