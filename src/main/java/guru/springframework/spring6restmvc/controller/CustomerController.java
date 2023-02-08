package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping
	public List<Customer> listAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") UUID id) {
		return customerService.getCustomerById(id);
	}
}
