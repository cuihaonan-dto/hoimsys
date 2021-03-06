package hoimsys.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import hoimsys.bo.DoctorRegAndPat;
import hoimsys.bo.RegistrationAndDtDoctor;
import hoimsys.po.Registration;

public interface RegistrationService {
	
	//根据日期以及医生id查询当天的挂号单数量
    int getNumbersByDateAnddId(@Param("rDate")String rDate, @Param("tId")Integer tId);
    
    //根据病人id与预约时间查询挂号单
    Registration getRegistrationBypIdAnddateTime(@Param("pId")Integer pId, @Param("dateTime")Date dateTime);
    
    //根据病人id以及挂号单所处状态查询挂号单
  	List<RegistrationAndDtDoctor> getRegistrationsBypIdAndrStatus(Integer pId, Integer rStatus);
  	
  	//根据挂号单id查询挂号单
  	Registration getRegistrationByrId(Integer rId);
  	
  	//修改医嘱标题（rInfo)和详情（rRemarks）,返回此挂号单的药单编号；
  	Integer UpdageRegInfoAndRemark(Registration reg);
  	
  	//根据医生id以及挂号单状态查询该医生所处理的挂号单信息
  	List<DoctorRegAndPat> getDoctorRegAndPatBydIdAndrStatus(Integer dId, Integer rStatus, String pNameOrrId);
  	
  //根据挂号单状态查询所有的挂号单信息
  	List<DoctorRegAndPat> getAllDoctorRegAndPatBydIdAndrStatus(Integer rStatus, String pNameOrrId);
  	
  	//根据挂号单id（regId)修改挂号单状态(rStatus)
  	int changerStatusByregId(Integer regId, Integer rStatus);
  	
  	//根据挂号单id更新挂号单数据
  	int changeRegByRegId(Registration reg);

}
