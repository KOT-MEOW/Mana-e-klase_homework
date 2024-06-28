package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "Children_Group_table")
@Entity
public class ChildrenGroup {

	
	@Id
	@Column(name = "Idgr")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	@Column(name = "Title")
	@NotNull
	@Size(min= 3, max= 25)
	private String title;
	
	@Column(name = "Year")
	@NotNull
	private int year;
	
	// id teacher ManyToOne
	
	public ChildrenGroup(String title, int year) {
		setTitle(title);
		setYear(year);
	}
	
}
