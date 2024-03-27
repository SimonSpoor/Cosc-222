import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoursesTest {
    Course c = new Course("a", "2", "a", "a", "a");
    Course d = new Course("a", "3", "a", "database", "a");
    Courses courses = new Courses();
    ArrayList<Course> list = new ArrayList<>(Arrays.asList(d,c,c));

    @BeforeEach
    public void setUp() {
        courses.setCourses(list);
}
    @Test
    public void testListAll() {
        assertTrue("a 3 a\ndatabase\nPrerequisite: a\na 2 a\na\nPrerequisite: a\na 2 a\na\nPrerequisite: a\n".equals(courses.listAll()));
    }
    @Test
    public void testListAllter() {
        assertTrue("a 3 a\ndatabase\nPrerequisite: a\na 2 a\na\nPrerequisite: a\na 2 a\na\nPrerequisite: a\n".equals(courses.listAllter()));
    }
    @Test
    public void testListAllStream() {
        assertTrue("a 3 a\ndatabase\nPrerequisite: a\na 2 a\na\nPrerequisite: a\na 2 a\na\nPrerequisite: a\n".equals(courses.listAllStream()));
    }

    @Test
    void listsAllReturnSame() {
        assertAll(() -> assertEquals(courses.listAll(), courses.listAllStream()),
                () -> assertEquals(courses.listAll(), courses.listAllter()),
                () -> assertEquals(courses.listAllStream(), courses.listAllter())
        );
    }

    @Test
    void databaseNumberTest(){
        assertEquals(1, courses.howManyDatabaseClasses());
    }

    @Test
    void sortCoursesTest(){
        assertEquals(courses.sortCourses(), new ArrayList<>(Arrays.asList(c,c,d)));
    }

    @Test
    void listLength(){
        assertEquals(courses.displayNumberOfCourses(),list.size());
    }
}