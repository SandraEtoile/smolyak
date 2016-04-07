package testEntity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.entity.Book;

public class testBook {
	private static Book book1;
	private static Book book2;
	private static Book book3;
	private static Book book4;

	@BeforeClass
	public void setUp() {
		book1 = new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki", 2001);
		book2 = new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki", 2001);
		book3 = new Book("The Catcher in the Rye", "J. D. Salinger ", 1993);
		book4 = book1;

	}

	@DataProvider(name = "test1")
	public static Object[][] testEquals() {
		return new Object[][] { { book1, book2, true }, { book1, book3, false }, };
	}

	@DataProvider(name = "test2")
	public static Object[][] testString() {
		return new Object[][] { { book1, "entity.Book@tittle:Rich Dad Poor Dadyear:2001author:Robert T. Kiyosaki" },
				{ book3, "entity.Book@tittle:The Catcher in the Ryeyear:1993author:J. D. Salinger " }, };
	}

	@Test(dataProvider = "test1")
	public void testEquals(Book input1, Book input2, boolean expected) {
		Assert.assertEquals(input1.equals(input2), expected);

	}

	@Test
	public void testHashCode() {
		Assert.assertEquals(book1.hashCode(), book4.hashCode());

	}

	@Test(dataProvider = "test2")
	public void toStringTest(Book input, String expected) {
		Assert.assertEquals(input.toString(), expected);
	}

}
