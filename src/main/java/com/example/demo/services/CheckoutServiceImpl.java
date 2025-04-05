package com.example.demo.services;


import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               CartRepository cartRepository,
                               CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase){
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        String orderTrackingNum = generateOrderTrackingNumber();
        cart.setOrderTracking(orderTrackingNum);

        cart.setStatus(StatusType.ordered);

        cartItems.forEach(itm -> cart.add(itm));
    if(!cartItems.isEmpty()){
        cartRepository.save(cart);
    }
    else{
        orderTrackingNum = "Your Cart is Empty.";
    }
        return new PurchaseResponse(orderTrackingNum);
    }
    private String generateOrderTrackingNumber(){

        return UUID.randomUUID().toString();
    }
}
