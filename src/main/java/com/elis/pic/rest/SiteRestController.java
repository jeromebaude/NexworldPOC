package com.elis.pic.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elis.pic.model.Site;
import com.elis.pic.service.SiteService;

@RestController
@RequestMapping("/sites")
public class SiteRestController {
	
	@Autowired
	SiteService siteService;
	
	@RequestMapping(method = RequestMethod.GET)
	Collection<Site> readSites() {
		return this.siteService.findAllSites();
	}
	
	@RequestMapping(value = "/{siteId}", method = RequestMethod.GET)
	Site readSite(@PathVariable Integer siteId) {
		return this.siteService.findById(siteId);
	}
}
