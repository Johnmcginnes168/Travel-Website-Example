package com.example.demo.BootStrapData;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @PostConstruct
    public void sampleCustomers(){

        if(customerRepository.count() == 1) {

            Customer customer1 = new Customer();
            customer1.setFirstName("John");
            customer1.setLastName("Lennon");
            customer1.setPostal_code("04401");
            customer1.setAddress("1122 Boogie Woogie Avenue");
            customer1.setPhone("(999)999-9995");
            customer1.setDivision(divisionRepository.findAll().get(7));
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());

            Customer customer2 = new Customer();
            customer2.setFirstName("Paul");
            customer2.setLastName("McCartney");
            customer2.setPostal_code("90210");
            customer2.setAddress("123 Streety St.");
            customer2.setPhone("(999)999-9996");
            customer2.setDivision(divisionRepository.findAll().get(7));
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());

            Customer customer3 = new Customer();
            customer3.setFirstName("George");
            customer3.setLastName("Harrsion");
            customer3.setPostal_code("01126");
            customer3.setAddress("87 Lois Ln.");
            customer3.setPhone("(999)999-9997");
            customer3.setDivision(divisionRepository.findAll().get(7));
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());

            Customer customer4 = new Customer();
            customer4.setFirstName("Ringo");
            customer4.setLastName("Starr");
            customer4.setPostal_code("04412");
            customer4.setAddress("55 Oak St.");
            customer4.setPhone("(999)999-9998");
            customer4.setDivision(divisionRepository.findAll().get(7));
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());

            Customer customer5 = new Customer();
            customer5.setFirstName("Pete");
            customer5.setLastName("Best");
            customer5.setPostal_code("04413");
            customer5.setAddress("23 Maple St.");
            customer5.setPhone("(999)999-9999");
            customer5.setDivision(divisionRepository.findAll().get(7));
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

        }

        else{
            System.out.println("Existing sample customers");
        }
    }

}
