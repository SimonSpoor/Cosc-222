import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

//Write/fix the code as needed to remove warnings/errors and complete the lab 
public class Courses {
	ArrayList<Course> courses = new ArrayList<>();

	void loadCourses(){
		//http://www.calendar.ubc.ca/okanagan/courses.cfm?go=name&code=COSC throws a redirect error
		courses.add(new Course("COSC","111","Computer Programming I","description",""));
		courses.add(new Course("COSC","121","Computer Programming II","description","111"));
		courses.add(new Course("COSC","222","Data Structures","description","121"));
	}

	// Returns for listing methods switched to String for testing purposes
	public String listAll(){
		Course c;
		String s = "";
		for (int i=0; i < courses.size(); i++){
			// had to cast to a Course to get it running
			c = (Course) courses.get(i);
			//System.out.println(c.accr + " " + c.number + " " + c.title );
			s = s.concat(displayCourse(c.getNumber()));
		}
		return s;
	}
	public String listAllter(){
		Iterator<Course> courseIterator = courses.iterator();
		String s = "";
		while (courseIterator.hasNext()) s = s.concat(displayCourse(courseIterator.next().getNumber()));
		return s;
	}

	public String listAllStream(){
		StringBuilder s = new StringBuilder();
		Stream<Course> courseStream = courses.stream();
		courseStream.forEach(
				course ->  s.append(displayCourse(course.getNumber())));
		return s.toString();
	}
	
	String displayCourse(String number){
		Course c = null;
		for (int i = 0; i < courses.size(); i++){
			if (courses.get(i).getNumber() == number) c= courses.get(i);
		}
		String s = "";
		try {
			s += c.accr + " " + c.number + " " + c.title + "\n" + c.desc + "\nPrerequisite: " + c.prereq + "\n";
		} catch (NullPointerException e) {
			System.out.println("Invalid Class Number");
			throw new NullPointerException();
		}
		System.out.print(s);
		return s;
	}

	Integer displayNumberOfCourses(){
		Stream<Course> courseStream = courses.stream();
		int x = (int) courseStream.count();
		System.out.println(x);
		return x;

	}
	Integer howManyDatabaseClasses(){
		Iterator<Course> courseIterator = courses.iterator();
		int x = 0;
		while (courseIterator.hasNext()){
			if (courseIterator.next().desc.contains("database")) x++;
		}
		return x;
	}
	public ArrayList<Course> sortCourses(){
		Collections.sort(courses, Comparator.comparingInt(course -> Integer.parseInt(course.getNumber())));
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public static void main(String[] args) {
		Courses L = new Courses();
		L.loadCourses();
		//L.listAll();
		L.sortCourses();
	}

}
