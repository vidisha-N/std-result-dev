package cod.dev.test.studentinfo;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/student")
@Log4j2
public class StudentController {

//	org.slf4j.Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentRepo repo;
	
	@PostConstruct
	public void addStudent() {
		log.info("Adding sample studeny data");
		Student s = new Student("dinesh", "Pune", 56);
		
		Student ss = new Student("maniamita31"
				+ "sh", "Pune", 56);
		Student s2 = new Student("vidisha", "Pune", 56);
		repo.saveAll(Arrays.asList(s,ss,s2));
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {
		log.info("Get ALL STUDENt");
		return new ResponseEntity<List<Student>>(repo.findAll(), HttpStatus.OK);
	}
}
