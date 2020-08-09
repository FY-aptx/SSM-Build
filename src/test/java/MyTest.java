import com.fy.pojo.Books;
import com.fy.service.BooksService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService bookServiceImpl = (BooksService) context.getBean("BookServiceImpl");
        List<Books> booksList = bookServiceImpl.queryAllBook();
        for (Books books : booksList) {
            System.out.println(books);
        }
    }

}
