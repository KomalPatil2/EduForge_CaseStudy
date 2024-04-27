package com.sha.springbootmicroservice1course;

import java.util.List;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
 
import com.sha.springbootmicroservice1course.model.Course;
import com.sha.springbootmicroservice1course.repository.CourseRepository;
import com.sha.springbootmicroservice1course.service.CourseServiceImpl;
public class CourseTests {
	private org.slf4j.Logger log = LoggerFactory.getLogger(CourseTests.class);
  @Test  
	@DisplayName("save Course")
    public void saveCourse(){  
		try {
			log.info("Starting execution of saveCourse");
			Course expectedValue = null; 
			Course course = null; 
CourseRepository courseRepositoryc = null; 
CourseServiceImpl courseserviceimpl  =new CourseServiceImpl( courseRepositoryc); 
Course actualValue=courseserviceimpl.saveCourse( course);
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
    }  
  @Test  
	@DisplayName("delete Course")
    public void deleteCourse(){  
		try {
			log.info("Starting execution of deleteCourse");
Long courseId=0L; 
CourseRepository courseRepositoryc = null; 
CourseServiceImpl courseserviceimpl  =new CourseServiceImpl( courseRepositoryc); 
courseserviceimpl.deleteCourse( courseId);
Assertions.assertTrue(true);
		} catch (Exception exception) {
			log.error("Exception in execution ofdeleteCourse-"+exception,exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
    }  
  @Test  
	@DisplayName("find All Courses")
    public void findAllCourses(){  
		try {
			log.info("Starting execution of findAllCourses");
List<Course> expectedValue = null; 
CourseRepository courseRepositoryc = null; 
CourseServiceImpl courseserviceimpl  =new CourseServiceImpl( courseRepositoryc); 
List<Course> actualValue=courseserviceimpl.findAllCourses();
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
}
}