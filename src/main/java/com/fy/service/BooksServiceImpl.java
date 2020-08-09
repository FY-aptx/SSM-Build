package com.fy.service;

import com.fy.dao.BookMapper;
import com.fy.pojo.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    //业务（service）层调dao层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookId(int id) {
        return bookMapper.queryBookId(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
