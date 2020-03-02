package com.codelean.controller;

import com.codelean.model.Nhanvien;
import com.codelean.model.Phongban;
import com.codelean.service.NhanvienService;
import com.codelean.service.PhongbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NhanvienController {

    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    @ModelAttribute("phongbans")
    public Iterable<Phongban> phongbans(){
        return phongbanService.findAll();
    }

    @GetMapping("/nhanviens")
    public ModelAndView listCustomers(){
        Iterable<Nhanvien> nhanviens = nhanvienService.findAll();
        ModelAndView modelAndView = new ModelAndView("/nhanvien/list");
        modelAndView.addObject("nhanviens", nhanviens);
        return modelAndView;
    }

    @GetMapping("/create-nhanvien")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien", new Nhanvien());
        return modelAndView;
    }

    @PostMapping("/create-nhanvien")
    public ModelAndView saveCustomer(@ModelAttribute("nhanvien") Nhanvien nhanvien){
        nhanvienService.save(nhanvien);
        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien", new Nhanvien());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-nhanvien/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Nhanvien> nhanvien = nhanvienService.findById(id);
        if(nhanvien!= null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
            modelAndView.addObject("nhanvien", nhanvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nhanvien")
    public ModelAndView updateCustomer(@ModelAttribute("nhanvien") Nhanvien nhanvien){
        nhanvienService.save(nhanvien);
        ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
        modelAndView.addObject("nhanvien", nhanvien);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-nhanvien/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Nhanvien> nhanvien = nhanvienService.findById(id);
        if(nhanvien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/delete");
            modelAndView.addObject("nhanvien", nhanvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-nhanvien")
    public String deleteCustomer(@ModelAttribute("nhanvien") Nhanvien nhanvien){
        nhanvienService.remove(nhanvien.getId());
        return "redirect:nhanviens";
    }
}
