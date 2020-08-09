package com.fy.dao;

import com.fy.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookId(@Param("bookID")int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据书名查询书
    List<Books> queryBookByName(@Param("bookName") String bookName);

}
