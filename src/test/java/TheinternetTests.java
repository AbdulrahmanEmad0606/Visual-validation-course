import base.BaseTests;
import org.testng.annotations.Test;

public class TheinternetTests extends BaseTests {
    @Test
    public void testBottomFrame(){
        validateFrame("frame-bottom");
    }

}
