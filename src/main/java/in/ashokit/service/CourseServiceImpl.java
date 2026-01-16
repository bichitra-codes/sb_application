package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Course;
import in.ashokit.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String upSet(Course course) {
		courseRepo.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer id) {
	
		Optional<Course> findById = courseRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
			return "Delete sucess";
		} else {
			
			return " No Record Found ";
		}
	}

}
