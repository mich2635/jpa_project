package in.reno.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import in.reno.dao.EmployeeDao;
import in.reno.entity.Employee;

@ComponentScan("in.reno.message")
@ComponentScan("in.reno.restcontroller")
@ComponentScan("in.reno.dao")
@EntityScan("in.reno.entity")
@SpringBootApplication
public class JpaProject816336Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext allBeans = SpringApplication.run(JpaProject816336Application.class, args);
		EmployeeDao emp = allBeans.getBean(EmployeeDao.class);
		emp.insert(new Employee("reno", "Dev", 25000));
		emp.insert(new Employee("micheal", "Dev", 25000));

	}

}
