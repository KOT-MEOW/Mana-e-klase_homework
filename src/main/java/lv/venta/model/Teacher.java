package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Teacher_table")
@Entity
public class Teacher {

	@Id
	@Column(name = "Idt")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	@Column(name = "Name")
	@NotNull
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	private String surname;
	
	public Teacher(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
}
