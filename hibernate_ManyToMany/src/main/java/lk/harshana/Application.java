package lk.harshana;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lk.harshana.model.Course;
import lk.harshana.model.Student;
import lk.harshana.service.CourseService;
import lk.harshana.service.StudentService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private static Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		
		saveCourseStudent();
		
		getCourseList();
		
		getStudentList();
	}
	
	public void saveCourseStudent() {
		Student student = new Student();
		student.setName("harshan");
		
		Student student1 = new Student();
		student1.setName("jayamaha");
		
		Course course = new Course();
		course.setCourseCode("CSM2112");
		course.setCourseName("Computer Engineering");
		
		Course course1 = new Course();
		course1.setCourseCode("CSM2114");
		course1.setCourseName("Programming I");
		
		Course course2 = new Course();
		course2.setCourseCode("MTM21142");
		course2.setCourseName("computational Methematics");
		////////////////////////////////////////////////////////////
		student.getCourses().add(course1);
		student.getCourses().add(course);
		student.getCourses().add(course2);
		
		course.getStudents().add(student);
		course.getStudents().add(student1);
		
		student1.getCourses().add(course1);
		student1.getCourses().add(course);
		
		course1.getStudents().add(student);
		course1.getStudents().add(student1);

		
		course1.getStudents().add(student);
		course1.getStudents().add(student1);

		studentService.saveStudent(student);
		studentService.saveStudent(student1);
		
		courseService.saveCourse(course);
		courseService.saveCourse(course1);
		courseService.saveCourse(course2);
	}
	
	public void getCourseList() {
		for(Course course : courseService.getAllCourses()) {
			log.info(course.getCourseCode() + " " + course.getCourseName());
		}
	}
	
	public void getStudentList() {
		for(Student student : studentService.getAllStudents()) {
			log.info(student.getName());
		}
	}
}
