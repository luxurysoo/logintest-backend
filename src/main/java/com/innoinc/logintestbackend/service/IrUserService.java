package com.innoinc.logintestbackend.service;

import java.util.List;

import com.innoinc.logintestbackend.dao.ir.IrUserMapper;
import com.innoinc.logintestbackend.model.ir.IrUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IrUserService {
	@Autowired
    IrUserMapper iruserMapper;
	
	public List<IrUser> selectAll() {
		List<IrUser> iruserList = iruserMapper.selectAll();
		return iruserList;
	}
	
	public IrUser selectIruserByUserid(String id) {
		IrUser iruser = iruserMapper.selectIruserByUserid(id);
		return iruser;
	}
}
