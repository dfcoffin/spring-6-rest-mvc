package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@Service
public interface CustomerService {

	Customer getCustomerById(UUID id);
	List<Customer> getAllCustomers();

	Customer saveNewCustomer(Customer customer);

	void updateCustomerById(UUID customerId, Customer customer);

	void deleteCustomerById(UUID customerId);

	void patchCustomerById(UUID customerId, Customer customer);
}
