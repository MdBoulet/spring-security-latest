package gn.boulet.springsecuritylatest.service;

import gn.boulet.springsecuritylatest.dto.Product;
import gn.boulet.springsecuritylatest.entity.UserInfo;
import gn.boulet.springsecuritylatest.exception.ProductNotFoundException;
import gn.boulet.springsecuritylatest.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadDataFromDB() {
        productList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Product.builder()
                        .id(i)
                        .name("Product " + i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(5000))
                        .build()
                )
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return productList
                .stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("Product " + id + " not found"));
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userRepository.save(userInfo);

        return "User add Successfully!";
    }

}
