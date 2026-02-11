package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Course;
import in.ashokit.service.CourseService;

@RestController
public class CourseRestCobtroller {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		
		String status = courseService.upSet(course);
		
		return new ResponseEntity<>(status , HttpStatus.CREATED);
	}
	
	@GetMapping(value="/course/{id}", produces= "application/json")
	public ResponseEntity<Course> getCourse(@PathVariable Integer id) {
		
		Course course = courseService.getById(id);
		
		if (course == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
		return new ResponseEntity<>(course , HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourse() {
		
		List<Course> allCourses = courseService.getAllCourse();
		
		return new ResponseEntity<>(allCourses , HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course) {
		
		String status = courseService.upSet(course);
		
		return new ResponseEntity<>(status , HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		
		String status = courseService.deleteById(id);
		
		return new ResponseEntity<>(status , HttpStatus.OK);
	
        }
	
}


