package cn.y.service.impl;

import cn.y.dao.AccountDao;
import cn.y.domain.Account;
import cn.y.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**业务实现
 * 注解@Service：将这个类交给容器管理
 * @author yu201
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /**
     * 注入AccountDao对象
     */
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层:查询所有账户.....");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层:保存账户.....");
        accountDao.saveAccount(account);
    }
}
