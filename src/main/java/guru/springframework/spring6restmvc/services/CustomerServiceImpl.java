package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

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

		customerMap = new HashMap<>();
		customerMap.put(customer1.getId(),customer1);
		customerMap.put(customer2.getId(),customer2);
		customerMap.put(customer3.getId(),customer3);

	}

	@Override
	public void patchCustomerById(UUID customerId, Customer customer) {
		Customer existing = customerMap.get(customerId);

		if (StringUtils.hasText(customer.getName())) {
			existing.setName(customer.getName());
		}
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		customerMap.remove(customerId);
	}

	@Override
	public void updateCustomerById(UUID customerId, Customer customer) {
		Customer existing = customerMap.get(customerId);
		existing.setName(customer.getName());
	}

	@Override
	public Customer saveNewCustomer(Customer customer) {

		Customer savedCustomer = Customer.builder()
				.id(UUID.randomUUID())
				.version(1)
				.createdDate(LocalDateTime.now())
				.updateDate(LocalDateTime.now())
				.name(customer.getName())
				.build();

		customerMap.put(savedCustomer.getId(), savedCustomer);

		return savedCustomer;
	}

	@Override
	public Customer getCustomerById(UUID id) {
		return customerMap.get(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customerMap.values());
	}


}
