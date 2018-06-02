package com.rarm.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rarm.model.PaddyPurchase;
import com.rarm.services.CompanyService;
import com.rarm.services.PaddyPurchaseService;

@Controller
public class PaddyPurchaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaddyPurchaseController.class);

	@Autowired
	private PaddyPurchaseService paddyPurchaseService;

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/paddyPurchase", method = RequestMethod.GET)
	public String addPaddyPurchase(Model model) {
		LOGGER.debug("Rendering paddyPurchase page");
		String category = "paddyPurchase";

		List<String> companyList = companyService.findCompanyCodeByCategory(category);
		model.addAttribute("companyList", companyList);
		for (int i = 0; i < companyList.size(); i++) {
			System.out.println(companyList.get(i));
		}

		return "common/paddyPurchase";
	}

	@RequestMapping(value = "/addCompany/paddyPurchase", method = RequestMethod.GET)
	public String addpurchaseCompany(String category, Model model) {
		LOGGER.debug("Rendering addCompany page for adding purchase Company");
		category = "paddyPurchase";
		model.addAttribute("category", category);
		return "common/addCompany";
	}

	@RequestMapping(value = "/savePaddyPurchase", method = RequestMethod.POST)
	public String saveItem(WebRequest request, RedirectAttributes redirectAttributes) throws ParseException {

		LOGGER.debug("Saving new paddyPurchase");
		String memoNo = request.getParameter("memoNo");
		String companyCode = request.getParameter("companyCode");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("date"));
		BigDecimal quantitySack = new BigDecimal(request.getParameter("quantitySack"));
		BigDecimal quantityKG = new BigDecimal(request.getParameter("quantityKG"));
		BigDecimal unitPricePerMon = new BigDecimal(request.getParameter("unitPricePerMon"));
		BigDecimal totalSackPrice = new BigDecimal(request.getParameter("totalSackPrice"));

		PaddyPurchase paddyPurchase = new PaddyPurchase(memoNo, companyCode, date, quantitySack, quantityKG,
				unitPricePerMon, totalSackPrice);
		paddyPurchaseService.save(paddyPurchase);

		return "redirect:/getAllPaddyPurchase";
	}
	
	@RequestMapping(value = "/getAllPaddyPurchase", method = RequestMethod.GET)
	public String getAllPaddyPurchase(Model model) {
		List<PaddyPurchase> paddyPurchase = paddyPurchaseService.findAllPaddyPurchase();
		
		model.addAttribute("paddyPurchase", paddyPurchase);
		
		return "common/listOfPaddyPurchase";
	}

}
