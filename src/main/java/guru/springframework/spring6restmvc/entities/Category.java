package guru.springframework.spring6restmvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

	@jakarta.persistence.Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID Id;

	@Version
	private Long version;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;

	@UpdateTimestamp
	private Timestamp lastModifiedDate;

	private String description;

	@ManyToMany
	@JoinTable(name = "beer_category",
		joinColumns = @JoinColumn(name = "category_id"),
		inverseJoinColumns = @JoinColumn(name = "beer_id"))
	private Set<Beer> beers;
}
