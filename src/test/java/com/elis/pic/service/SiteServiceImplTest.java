package com.elis.pic.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.elis.pic.dao.SiteDao;
import com.elis.pic.model.Site;

public class SiteServiceImplTest {

	@Mock
	SiteDao dao;
	
	@InjectMocks
	SiteServiceImpl siteService;
	
	@Spy
	List<Site> sites = new ArrayList<Site>();
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		sites = getSiteList();
	}

	@Test
	public void findById(){
		Site emp = sites.get(0);
		when(dao.findById(anyInt())).thenReturn(emp);
		Assert.assertEquals(siteService.findById(emp.getId()),emp);
	}

	@Test
	public void saveSite(){
		doNothing().when(dao).saveSite(any(Site.class));
		siteService.saveSite(any(Site.class));
		verify(dao, atLeastOnce()).saveSite(any(Site.class));
	}
	
	@Test
	public void updateSite(){
		Site emp = sites.get(0);
		when(dao.findById(anyInt())).thenReturn(emp);
		siteService.updateSite(emp);
		verify(dao, atLeastOnce()).findById(anyInt());
		Assert.assertEquals(dao.findById(emp.getId()).getNom(), emp.getNom());
	}
	
	@Test
	public void findAllSites(){
		when(dao.findAllSites()).thenReturn(sites);
		Assert.assertEquals(siteService.findAllSites(), sites);
	}
	
	@Test
	public void findSiteById(){
		Site emp = sites.get(0);
		when(dao.findById(anyInt())).thenReturn(emp);
		Assert.assertEquals(siteService.findById(anyInt()), emp);
	}

	@Test
	public void isSiteSsnUnique(){
		Site emp = sites.get(0);
		when(dao.findById(anyInt())).thenReturn(emp);
	}
	
	
	public List<Site> getSiteList(){
		Site e1 = new Site();
		e1.setId(1);
		e1.setNom("Paris");
		e1.setDateOuverture(new LocalDate());
		e1.setNombreSalaries(new BigDecimal(500));
		
		Site e2 = new Site();
		e2.setId(2);
		e2.setNom("Rouen");
		e2.setDateOuverture(new LocalDate());
		e2.setNombreSalaries(new BigDecimal(100));
		
		sites.add(e1);
		sites.add(e2);
		return sites;
	}
	
}
