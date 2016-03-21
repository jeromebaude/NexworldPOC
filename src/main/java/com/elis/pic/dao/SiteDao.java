package com.elis.pic.dao;

import java.util.List;

import com.elis.pic.model.Site;

public interface SiteDao {
	 
    Site findById(int id);
 
    void saveSite(Site site);
     
    void deleteSiteById(int id);
     
    List<Site> findAllSites();
 
}