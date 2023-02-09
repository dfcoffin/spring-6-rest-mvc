package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private Map<UUID, Customer> customerMap;

	public CustomerServiceImpl() {

		Customer customer1 = Customer.builder()
				.id(UUID.randomUUID())
				.name("Michael Weston")
				.version(1)
				.createdDate(LocalDateTime.now())
				.updateDate(LocalDateTime.now())
				.build();

		Customer customer2 = Customer.builder()
				.id(UUID.randomUUID())
				.name("Fionna Glenanne")
				.version(1)
				.createdDate(LocalDateTime.now())
				.updateDate(LocalDateTime.now())
				.build();

		Customer customer3 = Customer.builder()
				.id(UUID.randomUUID())
				.name("Sam Axe")
				.version(1)
				.createdDate(LocalDateTime.now())
				.updateDate(LocalDateTime.now())
				.build();

		this.customerMap = new HashMap<>();
		customerMap.put(customer1.getId(),customer1);
		customerMap.put(customer2.getId(),customer2);
		customerMap.put(customer3.getId(),customer3);

	}

	@Override
	public Customer getCustomerById(UUID id) {
		return customerMap.get(id);
	}
	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customerMap.values());
	}

	@Override
	public Customer saveNewCustomer(Customer customer) {
		Customer savedCustomer = Customer.builder()
				.id(UUID.randomUUID())
				.name(customer.getName())
				.version(1)
				.createdDate(LocalDateTime.now())
				.updateDate(LocalDateTime.now())
				.build();

		customerMap.put(savedCustomer.getId(), savedCustomer);

		return savedCustomer;
	}
}
