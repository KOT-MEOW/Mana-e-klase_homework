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
	@Column(name = "Idchgr")
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
	
	// connection between Teacher and ChildrenGroup => ManyToOne
	@ManyToOne
	@JoinColumn(name = "Idt")
	private Teacher teacher;
	
	// connection between ChildrenGroup and Child => OneToMany
	@OneToMany(mappedBy = "childrenGroup")
	@ToString.Exclude
	private Collection<Child> childs;
	
	public ChildrenGroup(String title, int year, Teacher teacher) {
		setTitle(title);
		setYear(year);
		setTeacher(teacher);
	}
	
}
