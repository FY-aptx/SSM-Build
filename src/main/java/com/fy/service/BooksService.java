package com.fy.service;

import com.fy.pojo.Books;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BooksService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookId(int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据书名查询书
    List<Books> queryBookByName(String bookName);
}
