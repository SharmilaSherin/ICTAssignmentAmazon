import org.testng.annotations.DataProvider;

public class DataProvide {



    @DataProvider(name="LoginData")
    public Object[][] getData(){
        Object[][]  data = {{"sharmilasherin181@gmail.com","sherin@1"},{"sharmila@gmail.com","sherin"}};
        return data;
    }
}
