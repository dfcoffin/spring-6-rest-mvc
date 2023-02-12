package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
public interface CustomerService {

	Optional<CustomerDTO> getCustomerById(UUID id);

	List<CustomerDTO> getAllCustomers();

	CustomerDTO saveNewCustomer(CustomerDTO customer);

	void updateCustomerById(UUID customerId, CustomerDTO customer);

	void deleteCustomerById(UUID customerId);

	void patchCustomerById(UUID customerId, CustomerDTO customer);
}
