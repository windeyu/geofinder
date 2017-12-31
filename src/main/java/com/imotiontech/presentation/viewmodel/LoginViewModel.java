package com.imotiontech.presentation.viewmodel;

import com.imotiontech.domain.Account;
import com.imotiontech.repository.AccountRepository;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Optional;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LoginViewModel {

    private String account;
    private String password;

    //wire service
    @WireVariable("accountRepository")
    AccountRepository accountRepository;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Command
    public void login(){
        Optional<Account> found = accountRepository.findByName(account);
        if (found.isPresent()) {
            Executions.getCurrent().getSession().setAttribute("accountName", account);
            Executions.sendRedirect("/home.zul");
        } else {
            System.out.println("login failed");
        }
    }

}
