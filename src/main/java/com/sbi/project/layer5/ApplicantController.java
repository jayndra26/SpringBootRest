package com.sbi.project.layer5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.project.layer2.Applicant;
import com.sbi.project.layer4.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

	@Autowired
	ApplicantService applicantService;

	public ApplicantController() {
		System.out.println("ApplicantController() constructor...");
	}

	@RequestMapping("/getApplicants") // localhost:8080/emps/getEmps
	public List<Applicant> getAllApplicants() {
		System.out.println("/getApplicants");
	
		return applicantService.getAllApplicantsService();
	}

	@RequestMapping("/getApplicant/{appid}")
	public Applicant getApplicant(@PathVariable("appid") int applicantNumberToSearch) {
		System.out.println("/getApplicant");
		boolean applicantFound = false;
		Applicant applicant = null;
		for (int i = 0; i < applicantService.getAllApplicantsService().size(); i++) {
			applicant = applicantService.getAllApplicantsService().get(i);
			if (applicant.getApplicantId() == applicantNumberToSearch) {
				applicantFound = true;
				break;
			}

		}
		if(applicantFound)
			return applicant;
		else 
			throw new RuntimeException("Applicant not found");
	}

	@RequestMapping("/deleteApplicant/{appid}")
	public String deleteApplicant(@PathVariable("appid") int applicantNumberToDelete) {
		System.out.println("/deleteApplicant");
		boolean applicantFound =false;
		Applicant applicant=null;
		for (int i = 0; i < applicantService.getAllApplicantsService().size(); i++) {
				applicant = applicantService.getAllApplicantsService().get(i);
				if(applicant.getApplicantId()==applicantNumberToDelete) {
					applicantService.deleteApplicantService(applicantNumberToDelete);
					
					applicantFound=true;
					break;
				}
			
		}
		if(applicantFound) {
			return "Applicant Id " +applicantNumberToDelete+" deleted succesfully";
		}
		else
			return "Record Not found for applicant id: "+applicantNumberToDelete;
		
	}
	@RequestMapping("/updateApplicant")
	public String updateEmployee(@RequestBody Applicant applicantObj) {
		System.out.println("/updateApplicant");
		boolean applicantFound = false;
		Applicant applicant = null;
		for (int i = 0; i < applicantService.getAllApplicantsService().size(); i++) {
			applicant = applicantService.getAllApplicantsService().get(i);
			if(applicant.getApplicantId() == applicantObj.getApplicantId()) {
				applicantFound =true;
				//applicantService.deleteApplicant(i);
				applicantService.updateApplicantService(applicantObj);
				break;
				
			}
			
		}
		if(applicantFound) {
			return "Applicant Object Modified Successfully";
		}
		else
			return "Object Not Found" +applicantObj.getApplicantId();
					
	}
	@RequestMapping("/addApplicant")
	public String addApplicant(@RequestBody Applicant applicantObjectToAdd) {
		System.out.println("/addApplicant");
		boolean applicantFound = false;
		Applicant applicant =null;
		for (int i = 0; i < applicantService.getAllApplicantsService().size(); i++) {
			applicant = applicantService.getAllApplicantsService().get(i);
			if(applicant.getApplicantId()==applicantObjectToAdd.getApplicantId()) {
				applicantFound=true;
				break;
		
				
			}
			
		}
		if(applicantFound)
			return "Record for "+applicantObjectToAdd.getApplicantId()+" is already exist!!!";
		else {
			applicantService.updateApplicantService(applicantObjectToAdd);
			return "Applicant added successfully";
		}
	}
	
	
	/*
	 * @RequestMapping("/getEmp/{eno}") // localhost:8080/emps/getEmp/7839 public
	 * Employee getEmployee(@PathVariable("eno") int employeeNumberToSearch) {
	 * System.out.println("/getEmp"); boolean employeeFound=false; Employee
	 * employeeObject = null; for(int i=0;i<staff.size();i++) { employeeObject =
	 * staff.get(i); if(employeeObject.getEmployeeNumber() ==
	 * employeeNumberToSearch) { employeeFound = true; break; } }
	 * if(employeeFound==true) return employeeObject; else throw new
	 * RuntimeException("Employee Not Found"); }
	 * 
	 * @RequestMapping("/deleteEmp/{eno}") // localhost:8080/emps/deleteEmp/7839
	 * public String deleteEmployee(@PathVariable("eno") int employeeNumberToDelete)
	 * { System.out.println("/deleteEmp"); boolean employeeFound=false; Employee
	 * employeeObject = null; for(int i=0;i<staff.size();i++) { employeeObject =
	 * staff.get(i); if(employeeObject.getEmployeeNumber() ==
	 * employeeNumberToDelete) { employeeFound = true; staff.remove(i); break; } }
	 * if(employeeFound==true) return
	 * "Employee Object deleted : "+employeeNumberToDelete; else return
	 * "Employee Object NOT found : "+employeeNumberToDelete; }
	 * 
	 * @RequestMapping("/updateEmp") // localhost:8080/emps/updateEmp/7839 public
	 * String updateEmployee(@RequestBody Employee employeeObjectToModify) {
	 * System.out.println("/updateEmp"); boolean employeeFound=false; Employee
	 * employeeObject = null; for(int i=0;i<staff.size();i++) { employeeObject =
	 * staff.get(i); if(employeeObject.getEmployeeNumber() ==
	 * employeeObjectToModify.getEmployeeNumber()) { employeeFound = true;
	 * staff.remove(i); staff.add(employeeObjectToModify); break; } }
	 * if(employeeFound==true) return "Employee Object successfully modified"; else
	 * return
	 * "Employee Object NOT found : "+employeeObjectToModify.getEmployeeNumber();
	 * 
	 * }
	 * 
	 * @RequestMapping("/addEmp") // localhost:8080/emps/updateEmp/7839 public
	 * String addEmployee(@RequestBody Employee employeeObjectToAdd) {
	 * System.out.println("/addEmp"); boolean employeeFound=false; Employee
	 * employeeObject = null; for(int i=0;i<staff.size();i++) { employeeObject =
	 * staff.get(i); if(employeeObject.getEmployeeNumber() ==
	 * employeeObjectToAdd.getEmployeeNumber()) { employeeFound = true; break; } }
	 * if(employeeFound==true) return
	 * "Employee with this employeeNumber already exists!!!"; else {
	 * staff.add(employeeObjectToAdd); return
	 * "Employee Object addedd succesfully : "; }
	 * 
	 * }
	 */
}
