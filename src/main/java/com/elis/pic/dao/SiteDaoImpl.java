package com.elis.pic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.elis.pic.model.Site;

@Repository("siteDao")
public class SiteDaoImpl extends AbstractDao<Integer, Site> implements SiteDao {
 
    public Site findById(int id) {
        return getByKey(id);
    }
 
    public void saveSite(Site site) {
        persist(site);
    }
 
    public void deleteSiteById(int id) {
        Query query = getSession().createSQLQuery("delete from Site where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Site> findAllSites() {
        Criteria criteria = createEntityCriteria();
        return (List<Site>) criteria.list();
    }
 
    public Site findSiteById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Site) criteria.uniqueResult();
    }
}