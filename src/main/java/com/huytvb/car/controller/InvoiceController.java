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

import com.huytvb.car.models.Client;
import com.huytvb.car.models.Invoice;
import com.huytvb.car.models.InvoiceStatus;
import com.huytvb.car.services.ClientService;
import com.huytvb.car.services.InvoiceService;
import com.huytvb.car.services.InvoiceStatusService;

@Controller
public class InvoiceController {		
	
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoice")
	public String goInvoice(Model model) {

		List<Client> clientList = clientService.findAll();
		List<Invoice> invoiceList = invoiceService.getInvoice();
		List<InvoiceStatus> invoiceStatus = invoiceStatusService.getInvoiceStatus();

		model.addAttribute("clients", clientList);
		model.addAttribute("invoices", invoiceList);
		model.addAttribute("invoiceStatus",invoiceStatus);

		return "invoice";
	}

	@PostMapping("/invoice/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);

		return "redirect:/invoice";
	}

	@RequestMapping("invoice/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {

		return invoiceService.findById(id);
	}

	@RequestMapping(value = "/invoice/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Invoice invoice) {
		invoiceService.save(invoice);

		return "redirect:/invoice";
	}

	@RequestMapping(value = "/invoice/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		invoiceService.delete(id);

		return "redirect:/invoice";
	}
}
