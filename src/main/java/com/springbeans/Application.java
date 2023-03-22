package com.springbeans;

import com.springbeans.entity.Account;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;



@SpringBootApplication
public class Application implements CommandLineRunner {
     public static void main(String[] args) {
      SpringApplication.run(Application.class,args);
    }
     
     @Autowired
     private JdbcTemplate jdbcTempLate;
     
    @Override
    public void run(String... args) throws Exception {
       jdbcTempLate.execute("insert into Account (id,name,email,bill) values(1, 'natalia' , 'nata@mail.ru ', 234)");
    
    Map<String,Object>mapAccount = jdbcTempLate.queryForMap("select*from Account");
    System.out.println(getAccountById(1L));
    } 
    
    private Account getAccountById(Long id){
        String query = "select*from Account where id =%s";
   Map<String,Object>mapAccount = jdbcTempLate.queryForMap(String.format(query, id));
    Account account = new Account();
    account.setId(id);
    account.setName((String)mapAccount.get("name"));
    account.setEmail((String)mapAccount.get("email"));
    account.setBill((Integer)mapAccount.get("bill"));
    return account;
    }
}
