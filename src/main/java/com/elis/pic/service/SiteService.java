package com.elis.pic.service;

import java.util.List;

import com.elis.pic.model.Site;

public interface SiteService {
	 
    Site findById(int id);
     
    void saveSite(Site site);
     
    void updateSite(Site site);
     
    void deleteSiteById(int id);
 
    List<Site> findAllSites();
     
}
