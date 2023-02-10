package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@DeleteMapping("{customerId}")
	public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId) {

		customerService.deleteCustomerById(customerId);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PutMapping("{customerId}")
	public ResponseEntity updateCustomerById(@PathVariable("customerId")UUID customerId,
											 @RequestBody Customer customer) {

		customerService.updateCustomerById(customerId, customer);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody Customer customer) {

		Customer savedCustomer = customerService.saveNewCustomer(customer);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> listAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") UUID id) {
		return customerService.getCustomerById(id);
	}
}
