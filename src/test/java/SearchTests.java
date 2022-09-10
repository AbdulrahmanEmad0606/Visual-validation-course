import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SearchTests extends BaseTests {
    @Test
    public void testSearchByFullTitle(){
        String title = "Test";
        page.search(title);
        validateWindow();

    }
    @Test
    public void testSearchByFullTitle_Element(){
        page.search("Agile Testing");
        assertEquals("Number of books returned", 1, page.getNumberOfVisibleBooks());

    }
}