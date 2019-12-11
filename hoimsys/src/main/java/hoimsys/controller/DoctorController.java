package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import hoimsys.bo.Msg;
import hoimsys.po.Doctor;
import hoimsys.service.DoctorService;

@Controller
@RequestMapping("api/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	/*
	 * 根据医生ID返回医生信息
	 */
	@ResponseBody
	@GetMapping("/getdoctor")
	Msg doctorBydId(Integer dId) {
		Doctor doctor = doctorService.getOneDoctorBydId(dId);
		if (doctor == null) {
			return Msg.fail();
		}
		return Msg.success().add("doctor", doctor);
	}
	
	/*
	 * 根据条件返回部门医生列表
	 */
	@ResponseBody
	@GetMapping("/getdoctors")
	Msg listDoctorBydtIdAndLikedName(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "dtId", defaultValue = "0") Integer dtId,
			@RequestParam(value = "dName", defaultValue = "") String dName) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<Doctor> doctorList = doctorService.getListDoctorBydtIdAndLikedName(dtId,dName);
		
		PageInfo<Doctor> pageDoctorList = new PageInfo<Doctor>(doctorList);
		
		return Msg.success().add("pageDoctorList", pageDoctorList);
	}

}
