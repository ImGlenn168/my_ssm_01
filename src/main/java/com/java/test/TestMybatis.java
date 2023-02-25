package com.java.test;

import com.java.dao.IAccountDao;
import com.java.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws IOException {
        Account account = new Account();
        account.setName("郭寒");
        account.setMoney(200d);
        // 加载配置文件
        InputStream resource = Resources.getResourceAsStream("mybatisConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        // 创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取到代理对象
        IAccountDao dao = sqlSession.getMapper(IAccountDao.class);
        // 保存
        dao.addAccount(account);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
        resource.close();
    }

    @Test
    public void run2() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = factory.openSession();
        IAccountDao dao = sqlSession.getMapper(IAccountDao.class);
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        sqlSession.close();
        resource.close();
    }
}
