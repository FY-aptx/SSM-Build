package com.fy.controller;

import com.fy.pojo.Books;
import com.fy.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调service层

    @Autowired
    @Qualifier("BookServiceImpl")
    private BooksService booksService;
    //查询全部书籍，并且返回到一个展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books=booksService.queryAllBook();
        model.addAttribute("list",books);

        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/AddBook")
    public String addBook(Books books){
        System.out.println("addBook==>"+books);
        booksService.addBook(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")请求
    }

    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model){
        Books books=booksService.queryBookId(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/UpdateBook")
    public String updateBook(Books books,Model model){
        System.out.println("updateBook==>"+books);
        booksService.updateBook(books);
        //Books books1 = booksService.queryBookId(books.getBookID());
        //model.addAttribute("books", books1);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        booksService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //根据书籍名字查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> list1 = booksService.queryBookByName(queryBookName);
        System.out.println("Book==>"+list1);
        System.out.println(list1==null);
        if (list1.isEmpty()){
            list1=booksService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list1);
        return "allBook";



    }


}
