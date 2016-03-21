package com.elis.pic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elis.pic.model.Site;
import com.elis.pic.service.SiteService;

@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
    SiteService service;
     
    @Autowired
    MessageSource messageSource;
 
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listSites(ModelMap model) {
 
        List<Site> sites = service.findAllSites();
        model.addAttribute("sites", sites);
        return "allsites";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newSite(ModelMap model) {
        Site site = new Site();
        model.addAttribute("site", site);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveSite(@Valid Site site, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
         
        service.saveSite(site);
 
        model.addAttribute("success", "Le site " + site.getNom() + " a été enregistré avec succès.");
        return "success";
    }
 
 
    @RequestMapping(value = { "/edit-{id}-site" }, method = RequestMethod.GET)
    public String editSite(@PathVariable int id, ModelMap model) {
        Site site = service.findById(id);
        model.addAttribute("site", site);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    @RequestMapping(value = { "/edit-{id}-site" }, method = RequestMethod.POST)
    public String updateSite(@Valid Site site, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        service.updateSite(site);
 
        model.addAttribute("success", "Site " + site.getNom()  + " mis à jour avec succès");
        return "success";
    }
 
    @RequestMapping(value = { "/delete-{id}-site" }, method = RequestMethod.GET)
    public String deleteSite(@PathVariable int id) {
        service.deleteSiteById(id);
        return "redirect:/list";
    }
 
}
