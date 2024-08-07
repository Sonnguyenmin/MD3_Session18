package ra.sonnguyen.demo_jv240408_md3.service;

import ra.sonnguyen.demo_jv240408_md3.model.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account getAccountById(Long id);
    Boolean saveAccount(Account account);
    Boolean updateAccount(Account account);
    Boolean deleteAccount(Long id);
    List<Account> getAccountByName(String accountName);
}
