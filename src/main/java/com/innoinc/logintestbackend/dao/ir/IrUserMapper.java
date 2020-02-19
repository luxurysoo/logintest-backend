/**
 * IrUser DAO
 * 
 * @author ???
 */

package com.innoinc.logintestbackend.dao.ir;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.innoinc.logintestbackend.model.ir.IrUser;



public interface IrUserMapper {
	@Select("SELECT count(*) FROM ir_user")
	public String getCount(); 
	
    List<IrUser> selectAll();
    
    IrUser selectIruserByUserid(String Userid);

    List<IrUser> selectIruserWhere();
    
}
