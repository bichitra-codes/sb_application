package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.Course;

public interface CourseService {

	public String upSet(Course course);
	public Course getById(Integer id);
	public List<Course> getAllCourse();
	public String deleteById(Integer id);
}

