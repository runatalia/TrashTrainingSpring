
package jsontrainspringboot.service;


import java.util.ArrayList;
import java.util.List;
import jsontrainspringboot.controller.dto.AccountResponseDTO;
import jsontrainspringboot.entity.Account;
import jsontrainspringboot.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jsontrainspringboot.repository.AccountRepository;


@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accauntRepository) {
        this.accountRepository = accauntRepository;
    }
    
    public Long saveAccount(String name, String email, Integer bill){
        Account account = new Account(name,email,bill);
        return accountRepository.save(account).getId();
    }
    
    public AccountResponseDTO findById(long id){
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Аккаунт с id"+id+" не существует в базе"));
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO(account.getId(),account.getName()
                ,account.getEmail(),account.getBill());
        return accountResponseDTO;
    }
    
     public List<AccountResponseDTO> getAllAccounts(){
         List<Account> accounts = accountRepository.findAll();
         List<AccountResponseDTO> accountsResponseDTO = new ArrayList();
         for(Account account: accounts){
             AccountResponseDTO accountResponseDTO = new AccountResponseDTO(account.getId(),account.getName()
                ,account.getEmail(),account.getBill());
             accountsResponseDTO.add(accountResponseDTO);
         }
        return accountsResponseDTO;
    }
     
     public void removeAccountById(long id){
        accountRepository.deleteById(id);
    }
}
