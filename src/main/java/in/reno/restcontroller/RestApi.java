package in.reno.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reno.dao.EmployeeDao;
import in.reno.entity.Employee;
import in.reno.message.Message;

@RestController
public class RestApi {

	@Autowired
	EmployeeDao dao;

	@Autowired
	Message msg;

	@GetMapping("getAllEmp")
	public List<Employee> getAllEmp() {
		List<Employee> empList = dao.findAll();
		return empList;
	}

	@GetMapping("insertEmp")
	public Message insertEmp(@RequestParam String name, @RequestParam String designation, @RequestParam long salary) {
		System.out.println("hi");
		msg.setMessage("Insertion Successfull");
		dao.insert(new Employee(name, designation, salary));
		return msg;
	}

	@GetMapping("updateEmp")
	public Message updateEmp(@RequestParam int id, @RequestParam long salary) {
		msg.setMessage("Update Successfull");
		dao.update(id, salary);
		return msg;
	}

	@GetMapping("delete")
	public Message delete(@RequestParam int id) {
		msg.setMessage("Deleted Successfully");
		dao.deleteById(id);
		return msg;
	}

}
