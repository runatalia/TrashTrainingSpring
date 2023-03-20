package jsontrainspringboot.controller;

import java.util.List;
import jsontrainspringboot.controller.dto.AccountRequestDTO;
import jsontrainspringboot.controller.dto.AccountResponseDTO;
import jsontrainspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accauntService) {
        this.accountService = accauntService;
    }
    
    @GetMapping("/hello")
    public String getHello(){
    return "Hi, Natasha!";
    }
    
    @PostMapping("/accounts")
    public Long createAccount(@RequestBody  AccountRequestDTO accauntRequestDTO){
        return accountService.saveAccount(accauntRequestDTO.getName(),accauntRequestDTO.getEmail(), accauntRequestDTO.getBill());
    }
    
    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable long id){
        return accountService.findById(id);
    }
    
     @GetMapping("/allaccounts")
     public List<AccountResponseDTO> getAllAccounts(){
        return accountService.getAllAccounts();
    }
     
     @GetMapping("/remove/{id}")
    public void removeAccount(@PathVariable long id){
        accountService.removeAccountById(id);
    }
    
}
