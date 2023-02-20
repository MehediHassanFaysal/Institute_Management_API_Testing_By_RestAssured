package students_api;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class StudentsAPI {

	public static HashMap map= new HashMap(); 
	
	
	@Test(priority = 1)
	void listOfResigteredStu() {
		given()
		.when()
				.get("http://127.0.0.1:8000/api/all_registered_students")
		.then()
		   		.log().all()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.contentType("application/json")
				.assertThat()
				.body("Message", equalTo("List of all students."))
				.and()
				.body("List[0].email", equalTo("a23@gmail.com"))
				.and()
				.body("Success", equalTo(true));
		
	}


	// Register a new student using valid credentials
	@Test(priority = 2)
	void add_new_stu(){
		map.put("f_name", studentUtilities.stuFirstName());
		map.put("l_name", studentUtilities.stuLastName());
		map.put("gender", studentUtilities.stuGender());
		map.put("age", studentUtilities.stuAge());
		map.put("mobile_no", studentUtilities.stuPhnNo());
		map.put("email", studentUtilities.stuEmail());
		map.put("password", studentUtilities.stuPass());


		given()
				.contentType("application/json")
				.body(map)
		.when()
				.post("http://127.0.0.1:8000/api/student_register")
		.then()
				.statusCode(201)
				.contentType("application/json")
				.assertThat()
				.body("message", equalTo("Registration successfully"))
				.and()
				.body("'student information'.email", equalTo(studentUtilities.stuEmail()))       // not using ["student information"].email
				.log().headers()
				.log().body();
	}

	//Update student information by student id

	@Test(priority = 3)
	void update_stu_info(){
		map.put("f_name", studentUtilities.UpdateStuFirstName());
		map.put("l_name", studentUtilities.UpdatestuLastName());
		map.put("gender", studentUtilities.UpdatestuGender());
		map.put("age", studentUtilities.UpdatestuAge());
		map.put("mobile_no", studentUtilities.UpdatestuPhnNo());
		map.put("email", studentUtilities.UpdatestuEmail());
		map.put("password", studentUtilities.UpdatestuPass());

		given()
				.contentType("application/json")
				.body(map)
		.when()
				.put("http://127.0.0.1:8000/api/update_student_info/3")
		.then()
				.log().all()
				.statusCode(200)
				.assertThat()
				.body("Success", equalTo(true))
				.and()
				.body("Message", equalTo("Student info. has been updated successfully"));
	}


	//Update specific information of a student by student id using patch method

	@Test(priority = 4)
	void partialUpdate(){
		map.put("f_name", studentUtilities.p_update_stu_firstname());
		map.put("l_name", studentUtilities.p_update_stu_lastname());
		map.put("age", studentUtilities.p_update_stu_age());


		given()
				.contentType("application/json")
				.body(map)
		.when()
				.patch("http://127.0.0.1:8000/api/partially/update/student_info/4")
		.then()
				.log().all()
				.assertThat()
				.statusCode(202)
				.and()
				.statusLine("HTTP/1.1 202 Accepted")
				.assertThat()
				.body("Message", equalTo("Student info. has been updated successfully"))
				.and()
				.body("Success", equalTo(true));

	}

}
