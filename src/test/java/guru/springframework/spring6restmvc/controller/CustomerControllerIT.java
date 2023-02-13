package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Donald F. Coffin
 */

@SpringBootTest
class CustomerControllerIT {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerController customerController;

	@Rollback
	@Transactional
	@Test
	void testAllEmptyList() {
		customerRepository.deleteAll();
		List<CustomerDTO> dtos = customerController.listAllCustomers();

		assertThat(dtos.size()).isEqualTo(0);
	}

	@Test
	void testListAll() {
		List<CustomerDTO> dtos = customerController.listAllCustomers();

		assertThat(dtos.size()).isEqualTo(3);
	}

	@Test
	void testCustomerIdNotFound() {
		assertThrows(NotFoundException.class, () -> {
			customerController.getCustomerById(UUID.randomUUID());
		});
	}

	@Test
	void testGetById() {
		Customer customer = customerRepository.findAll().get(0);

		CustomerDTO dto = customerController.getCustomerById(customer.getId());

		assertThat(dto).isNotNull();
	}
}