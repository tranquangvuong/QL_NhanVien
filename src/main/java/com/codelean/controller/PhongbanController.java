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
public class PhongbanController {

    @Autowired
    private PhongbanService phongbanService;
    @Autowired
    private NhanvienService nhanvienService;

    @GetMapping("/phongbans")
    public ModelAndView listProvinces(){
        Iterable<Phongban> phongbans = phongbanService.findAll();
        ModelAndView modelAndView = new ModelAndView("/phongban/list");
        modelAndView.addObject("phongbans", phongbans);
        return modelAndView;
    }

    @GetMapping("/create-phongban")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/phongban/create");
        modelAndView.addObject("phongban", new Phongban());
        return modelAndView;
    }

    @PostMapping("/create-phongban")
    public ModelAndView saveProvince(@ModelAttribute("phongban") Phongban phongban){
        phongbanService.save(phongban);

        ModelAndView modelAndView = new ModelAndView("/phongban/create");
        modelAndView.addObject("phongban", new Phongban());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-phongban/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Phongban> phongban = phongbanService.findById(id);
        if(phongban != null) {
            ModelAndView modelAndView = new ModelAndView("/phongban/edit");
            modelAndView.addObject("phongban", phongban);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-phongban")
    public ModelAndView updateProvince(@ModelAttribute("phongban") Phongban phongban){
        phongbanService.save(phongban);
        ModelAndView modelAndView = new ModelAndView("/phongban/edit");
        modelAndView.addObject("phongban", phongban);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-phongban/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Phongban> phongban = phongbanService.findById(id);
        if(phongban != null) {
            ModelAndView modelAndView = new ModelAndView("/phongban/delete");
            modelAndView.addObject("phongban", phongban);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-phongban")
    public String deleteProvince(@ModelAttribute("phongban") Phongban phongban){
        phongbanService.remove(phongban.getId());
        return "redirect:phongbans";
    }

    @GetMapping("/view-phongban/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Phongban> phongban = phongbanService.findById(id);
        if(phongban == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Nhanvien> nhanviens = nhanvienService.findAllByPhongban(phongban.get());
        ModelAndView modelAndView = new ModelAndView("/phongban/view");
        modelAndView.addObject("phongban", phongban);
        modelAndView.addObject("nhanviens", nhanviens);
        return modelAndView;
    }

}
