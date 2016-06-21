import org.mockito.*;

import org.junit.*;
import static org.junit.Assert.*;


public class VisitorTest {
	@SuppressWarnings("unchecked")
	@Mock
	CitySim9002 mockedCity = Mockito.mock(CitySim9002.class);
	Visitor mockedVisitor = Mockito.mock(Visitor.class);
	
	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this
		MockitoAnnotations.initMocks(mockedCity);
		MockitoAnnotations.initMocks(mockedVisitor);
	}
	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
		}	
//	Test FUN-VISITOR type assigned randomly
//	This is to check whether for each iteration the visitor type is being chosen randomly from one of the four types
//	a Student, a Professor, a Business Person, or a Blogger.
//	As there are only 4 visitor types, the random number generated should be less than 4 
//	This test case should return true
	@Test
	public void testRandomVisitorType1(){
		Visitor v=new Visitor();
		assertTrue(v.random()<4);
	}
//	To test the random number generated for choosing visitor type is between 0 and 3 and not greater than 3.
	@Test
	public void testRandomVisitorType2(){
		Visitor v=new Visitor();
		assertFalse(v.random()>3);
	}
//	To test the random number generated for choosing visitor type is between 0 and 3 and not a negative number.
	@Test
	public void testRandomVisitorType3(){
		Visitor v=new Visitor();
		assertFalse(v.random()<0);
	}
	
	
//	Test FUN-CITY-LOCS are randomly chosen
//	To test that for each iteration, the visitor location is randomly chosen from the available five locations
//	"The Cathedral of Learning","Squirrel Hill","The Point","Downtown","left the city"
//	As there are only 5 city locations including option to leave the city, the random number generated should be less than 5
	@Test
	public void testRandomLocation1(){
		Visitor v=new Visitor();
		assertTrue(v.ranloc()<5);
	}
//	To test the random location chosen is between 0 and 4 and not greater than 4
	@Test
	public void testRandomLocation2(){
		Visitor v=new Visitor();
		assertFalse(v.ranloc()>4);
	}
//	To test the random location chosen is between 0 and 4 and not a negative number 
	@Test
	public void testRandomLocation3(){
		Visitor v=new Visitor();
		assertFalse(v.ranloc()<0);
	}
//	Test Visitor type chosen is always same for given number
//	The random() function will randomly generate values between 1 and 4 
//	This test is to make sure that visitor type is correctly picked from the array. For example if 
//	random number generated is 1, the visitor type should be always "professor"
	@Test
	public void testVisitorChosen1(){
		Visitor v=new Visitor();
		Mockito.when(mockedVisitor.random()).thenReturn(1);
		assertEquals(v.visitorchosen(),"Professor");
	}
//	Test Visitor type chosen is always same for given number
//	The random() function will randomly generate values between 1 and 4 
//	This test is to make sure that visitor type is correctly picked from the array. For example if 
//	random number generated is 0, the visitor type should be always "Student"
	@Test
	public void testVisitorChosen2(){
		Visitor v=new Visitor();
		Mockito.when(mockedVisitor.random()).thenReturn(0);
		assertEquals(v.visitorchosen(),"Student");
	}
//	Test Location chosen is always same for given number
//	The ranloc() function will randomly generate values between 1 and 5 
//	This test is to make sure that Location is correctly picked from the array. For example if 
//	random number generated is 0, the location should be always "The Cathedral of Learning"
	@Test
	public void testLocationChosen1(){
		Visitor v=new Visitor();
		Mockito.when(mockedVisitor.ranloc()).thenReturn(0);
		assertNotEquals(v.visitorchosen(),"The Cathedral of Learning");
	}
//	Test Location chosen is always same for given number
//	The ranloc() function will randomly generate values between 1 and 5 
//	This test is to make sure that Location is correctly picked from the array. For example if 
//	random number generated is 1, the location should be always "Squirrel Hill"
	@Test
	public void testLocationChosen2(){
		Visitor v=new Visitor();
		Mockito.when(mockedVisitor.ranloc()).thenReturn(1);
		assertEquals(v.visitorchosen(),"Squirrel Hill");
	}
	
//	Test Preferences for Visitor
//	This will test for a given visitor type in this case "Student" and a given location which the 
//	visitor did not like, in this case "The Cathedral of Learning" 
//	when the preferences() method is called, the result should be 
//	Visitor X did not like the The Cathedral of Learning
	@Test
	public void testPreferences1(){
		Visitor v=new Visitor();
		Mockito.when(mockedVisitor.visitorchosen()).thenReturn("Student");
		Mockito.when(mockedVisitor.locationchosen()).thenReturn("The Cathedral of Learning");
		assertNotEquals(v.preferences(1),"Visitor 1 did not like the The Cathedral of Learning");
	}
//	Test Preferences for Visitor
//	This will test for a given visitor type in this case "Business Person" and a given location which the 
//	visitor did not like, in this case "Squirrel Hill" 
//	when the preferences() method is called, the result should be 
//	Visitor X did like the Squirrel Hill
	@Test
	public void testPreferences2(){
		Visitor v=new Visitor();
		Mockito.when(mockedVisitor.visitorchosen()).thenReturn("Business Person");
		Mockito.when(mockedVisitor.locationchosen()).thenReturn("Squirrel Hill");
		assertEquals(v.preferences(1),"Visitor 1 did  like the Squirrel Hill");
	}

}


