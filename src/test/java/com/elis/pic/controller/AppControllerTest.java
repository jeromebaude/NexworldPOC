package com.elis.pic.controller;

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
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.elis.pic.model.Site;
import com.elis.pic.service.SiteService;

public class AppControllerTest {

	@Mock
	SiteService service;
	
	@Mock
	MessageSource message;
	
	@InjectMocks
	AppController appController;
	
	@Spy
	List<Site> sites = new ArrayList<Site>();

	@Spy
	ModelMap model;
	
	@Mock
	BindingResult result;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		sites = getSiteList();
	}
	
	@Test
	public void listSites(){
		when(service.findAllSites()).thenReturn(sites);
		Assert.assertEquals(appController.listSites(model), "allsites");
		Assert.assertEquals(model.get("sites"), sites);
		verify(service, atLeastOnce()).findAllSites();
	}
	
	@Test
	public void newSite(){
		Assert.assertEquals(appController.newSite(model), "registration");
		Assert.assertNotNull(model.get("site"));
		Assert.assertFalse((Boolean)model.get("edit"));
		Assert.assertEquals(((Site)model.get("site")).getId(), 0);
	}


	@Test
	public void saveSiteWithValidationError(){
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).saveSite(any(Site.class));
		Assert.assertEquals(appController.saveSite(sites.get(0), result, model), "registration");
	}
	
	@Test
	public void saveSiteWithSuccess(){
		when(result.hasErrors()).thenReturn(false);
		doNothing().when(service).saveSite(any(Site.class));
		Assert.assertEquals(appController.saveSite(sites.get(0), result, model), "success");
		Assert.assertEquals(model.get("success"), "Le site Paris a été enregistré avec succès.");
	}

	@Test
	public void editSite(){
		Site emp = sites.get(0);
		when(service.findById(anyInt())).thenReturn(emp);
		Assert.assertEquals(appController.editSite(anyInt(), model), "registration");
		Assert.assertNotNull(model.get("site"));
		Assert.assertTrue((Boolean)model.get("edit"));
		Assert.assertEquals(((Site)model.get("site")).getId(), 1);
	}

	@Test
	public void updateSiteWithValidationError(){
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).updateSite(any(Site.class));
		Assert.assertEquals(appController.updateSite(sites.get(0), result, model,0), "registration");
	}

	@Test
	public void updateSiteWithSuccess(){
		when(result.hasErrors()).thenReturn(false);
		doNothing().when(service).updateSite(any(Site.class));
		Assert.assertEquals(appController.updateSite(sites.get(0), result, model, 0), "success");
		Assert.assertEquals(model.get("success"), "Site Paris mis à jour avec succès");
	}
	
	
	@Test
	public void deleteSite(){
		doNothing().when(service).deleteSiteById(anyInt());
		Assert.assertEquals(appController.deleteSite(123), "redirect:/list");
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
