package com.elis.pic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elis.pic.dao.SiteDao;
import com.elis.pic.model.Site;

@Service("siteService")
@Transactional
public class SiteServiceImpl implements SiteService {
 
    @Autowired
    private SiteDao dao;
     
    public Site findById(int id) {
        return dao.findById(id);
    }
 
    public void saveSite(Site site) {
        dao.saveSite(site);
    }

    public void updateSite(Site site) {
        Site entity = dao.findById(site.getId());
        if(entity!=null){
        	entity.setNom(site.getNom());
            entity.setDateOuverture(site.getDateOuverture());
            entity.setNombreSalaries(site.getNombreSalaries());
        }
    }
 
    public void deleteSiteById(int id) {
        dao.deleteSiteById(id);
    }
     
    public List<Site> findAllSites() {
        return dao.findAllSites();
    }     
}
