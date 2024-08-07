package ra.sonnguyen.demo_jv240408_md3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.sonnguyen.demo_jv240408_md3.model.entity.Account;
import ra.sonnguyen.demo_jv240408_md3.service.IAccountService;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AccountController {
    private final IAccountService accountService;

    @GetMapping
    public String home(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "home";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String doAddAccount(@ModelAttribute  Account account) {
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editAccount(@PathVariable("id") Long id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "edit";
    }

    @PostMapping("/edit/{id}")

    public String doEditAccount(@PathVariable("id") Long id, @ModelAttribute Account account) {
        account.setId(id);
        accountService.updateAccount(account);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detailAccount(@PathVariable("id") Long id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "detail";
    }

}
