package cn.dao.impl;

import cn.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("---------BookDaoImpl-----------");
    }
}
