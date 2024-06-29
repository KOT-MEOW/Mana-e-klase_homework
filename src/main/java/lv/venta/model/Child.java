package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Child_table")
@Entity
public class Child {

	@Id
	@Column(name = "Idch")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	@Column(name = "Allergies")
	@Size(max= 30)
	private String allergies;
	
	@Column(name = "Name")
	@NotNull
	@Size(min= 3, max= 15)
	@Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Name data error")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min= 3, max= 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Surname data error")
	private String surname;
	
	// connection between Child and ChildrenGroup => ManyToOne
	@ManyToOne
	@JoinColumn(name = "Idchgr")
	private ChildrenGroup childrenGroup;
	
	// connection between ChildRating and Child => OneToMany
	@OneToMany(mappedBy = "child")
	@ToString.Exclude
	private Collection<ChildRating> childRatings;
	
	public Child(String allergies, String name, String surname, ChildrenGroup childrenGroup) {
		setAllergies(allergies);
		setName(name);
		setSurname(surname);
		setChildrenGroup(childrenGroup);
	}
	
	
}
