import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SearchTests extends BaseTests {
    @Test
    public void testSearchByFullTitle(){
        String title = "Test";
        page.search(title);
        validateWindow();

    }
}