package com.rarm.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rarm.model.RiceSales;
import com.rarm.model.RecordsRiceSales;
import com.rarm.model.RestRiceSales;
import com.rarm.services.CompanyService;
import com.rarm.services.ItemService;
import com.rarm.services.RiceSalesService;

@Controller
public class RiceSalesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RiceSalesController.class);

	@Autowired
	ItemService itemService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private RiceSalesService riceSalesService;

	@RequestMapping(value = "/addRiceSales", method = RequestMethod.GET)
	public String addRiceSales(Model model) {
		LOGGER.debug("Rendering addRiceSales page");
		String category = "riceSales";
		List<String> itemNameList = itemService.findItemNamebyCategory(category);
		model.addAttribute("itemNameList", itemNameList);
		for (int i = 0; i < itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i));
		}

		List<String> companyList = companyService.findCompanyCodeByCategory(category);
		model.addAttribute("companyList", companyList);
		for (int i = 0; i < companyList.size(); i++) {
			System.out.println(companyList.get(i));
		}

		return "common/addRiceSales";
	}

	@RequestMapping(value = "/addItem/rice", method = RequestMethod.GET)
	public String showAddItem(String category, Model model) {
		LOGGER.debug("Rendering addItem page for adding rice Item");
		// item.setCategory("RiceSales");
		// model.addAttribute("category", item.getCategory());
		category = "riceSales";
		model.addAttribute("category", category);

		return "common/addItem";
	}

	@RequestMapping(value = "/addCompany/riceSales", method = RequestMethod.GET)
	public String addRiceSalesCompany(String category, Model model) {
		LOGGER.debug("Rendering addCompany page for adding riceSales Company");
		category = "riceSales";
		model.addAttribute("category", category);
		return "common/addCompany";
	}

	@RequestMapping(value = "/saveRiceSales", method = RequestMethod.POST)
	public @ResponseBody String saveRiceSales(@RequestBody RestRiceSales[] restRiceSales) throws ParseException {
		List<RiceSales> allRiceSales = new ArrayList<>();
		for (RestRiceSales rs : restRiceSales) {
			String memoNo = rs.getMemoNo();
			String companyCode = rs.getCompanyCode();
			// System.out.println(rs.getCompanyCode());
			// System.out.println(rs.getDate());
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(rs.getDate());
			for (RecordsRiceSales r : rs.getRecords()) {
				String itemName = r.getItemName();
				BigDecimal quantity = r.getQuantity();
				BigDecimal unitPrice = r.getUnitPrice();
				RiceSales RiceSales = new RiceSales(memoNo, companyCode, date, itemName, quantity, unitPrice);
				allRiceSales.add(RiceSales);
			}

		}
		riceSalesService.save(allRiceSales);
		return "home";
	}

	@RequestMapping(value = "/getAllRiceSales", method = RequestMethod.GET)
	public String getAllRiceSales(Model model) {
		List<RiceSales> riceSales = riceSalesService.findAllRiceSales();

		model.addAttribute("riceSales", riceSales);

		return "common/listOfRiceSales";
	}

}
