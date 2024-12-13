package com.example.javaspr1322.controller;

import org.springframework.ui.Model;
import com.example.javaspr1322.model.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shops")
class ShopController
{
    private List<Shop> shops = new ArrayList<>();
    @GetMapping
    public String listShops(Model model)
    {
        model.addAttribute("shops", shops);
        return "shop-list";
    }
    @GetMapping("/add")
    public String showAddForm()
    {
        return "shop-add";
    }
    @PostMapping("/add")
    public String addShop(@RequestParam String name,
                          @RequestParam String address,
                          @RequestParam String phone,
                          @RequestParam String email,
                          @RequestParam String website,
                          @RequestParam String category,
                          @RequestParam String description)
    {
        shops.add(new Shop(name, address, phone, email, website, category, description));
        return "redirect:/shops";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam String name, Model model)
    {
        Optional<Shop> shopOptional = shops.stream().filter(shop -> shop.getName().equals(name)).findFirst();
        shopOptional.ifPresent(shop -> model.addAttribute("shop", shop));
        return "shop-edit";
    }
    @PostMapping("/edit")
    public String editShop(@RequestParam String originalName,
                           @RequestParam String name,
                           @RequestParam String address,
                           @RequestParam String phone,
                           @RequestParam String email,
                           @RequestParam String website,
                           @RequestParam String category,
                           @RequestParam String description)
    {
        shops.removeIf(shop -> shop.getName().equals(originalName));
        shops.add(new Shop(name, address, phone, email, website, category, description));
        return "redirect:/shops";
    }
    @PostMapping("/delete")
    public String deleteShop(@RequestParam String name)
    {
        shops.removeIf(shop -> shop.getName().equals(name));
        return "redirect:/shops";
    }
}