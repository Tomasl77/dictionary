package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {

    @GetMapping("/{id}")
    public Invoice getOne(@PathVariable("id") Long id) { // null by default
	LocalDate date = LocalDate.of(1985, 8, 07);
	Invoice invoice = new Invoice("AD25V", date, 1005.36);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public List<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("Size = " + size + "Page = " + page);
	List<Invoice> invoices = new ArrayList<>();
	LocalDate date2 = LocalDate.now();
	invoices.add(new Invoice("200", date2, 10));
	invoices.add(new Invoice("200000", date2, 200));
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id" + id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
	System.out.println(invoice + "" + id);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Patched invoice with id" + id);
    }
}