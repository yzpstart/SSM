package cn.y.test;

import cn.y.dao.AccountDao;
import cn.y.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试Mybatis的环境
 * @author yu201
 */
public class TestMybatis {
    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void fun1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list = dao.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        //释放资源
        session.close();
        in.close();
        

    }

    /**
     * 测试插入
     * @throws IOException
     */
    @Test
    public void fun2() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setMoney(4000d);
        account.setName("郝建");
        //保存
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //释放资源
        session.close();
        in.close();
    }
}
