package com.huytvb.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytvb.car.models.InvoiceStatus;
import com.huytvb.car.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoice-status")
	public String goInvoiceStatus(Model model) {

		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();

		model.addAttribute("invoiceStatus", invoiceStatusList);

		return "invoice-status";
	}

	@PostMapping("/invoice-status/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);

		return "redirect:/invoice-status";
	}

	@RequestMapping("invoice-status/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {

		return invoiceStatusService.findById(id);
	}

	@RequestMapping(value = "/invoice-status/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);

		return "redirect:/invoice-status";
	}

	@RequestMapping(value = "/invoice-status/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		invoiceStatusService.delete(id);

		return "redirect:/invoice-status";
	}
}
