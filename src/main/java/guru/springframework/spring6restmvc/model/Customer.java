package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@Data
@Builder
public class Customer {
	private String name;
	private UUID id;
	private Integer version;
	private LocalDateTime createdDate;
	private LocalDateTime updateDate;
}
