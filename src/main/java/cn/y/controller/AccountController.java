package cn.y.controller;

import cn.y.domain.Account;
import cn.y.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**web层
 * @author yu201
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 注入AccountService对象
     */
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户的信息.....");
        //调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "success";
    }

    /**
     * 保存,然后重定向
     * @param
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return ;
    }
}
