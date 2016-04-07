package testEntity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.entity.Book;
import com.epam.entity.Library;

public class testLibrary {
	private Library library1;
	private Library library2;
	private Library library3;
	private Book book;

	@BeforeClass
	public void setUp() {
		book = new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki", 2001);
		library1 = new Library();
		library2 = new Library();
		library3 = library1;

	}

	@Test
	public void equalsTest() {
		library1.setLibrary(book);
		library2.setLibrary(book);
		Assert.assertTrue(library1.equals(library2));
	}

	@Test
	public void hashCodeTest() {
		Assert.assertEquals(library1.hashCode(), library3.hashCode());
	}

	@Test
	public void toStringTest() {
		Assert.assertEquals(library1.toString(),
				"entity.Library@tittle:[entity.Book@tittle:Rich Dad Poor Dadyear:2001author:Robert T. Kiyosaki]");
	}

}
