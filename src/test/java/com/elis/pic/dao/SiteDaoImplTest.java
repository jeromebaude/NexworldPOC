package com.elis.pic.dao;

import java.math.BigDecimal;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.elis.pic.model.Site;


public class SiteDaoImplTest extends EntityDaoImplTest{

	@Autowired
	SiteDao siteDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Site.xml"));
		return dataSet;
	}

	@Test
	public void findById(){
		Assert.assertNotNull(siteDao.findById(1));
		Assert.assertNull(siteDao.findById(3));
	}

	
	@Test
	public void saveSite(){
		siteDao.saveSite(getSampleSite());
		Assert.assertEquals(siteDao.findAllSites().size(), 3);
	}
	
	@Test
	public void findAllSites(){
		Assert.assertEquals(siteDao.findAllSites().size(), 2);
	}
	

	public Site getSampleSite(){
		Site site = new Site();
		site.setNom("Lille");
		site.setNombreSalaries(new BigDecimal(100));
		site.setDateOuverture(new LocalDate());
		return site;
	}

}
