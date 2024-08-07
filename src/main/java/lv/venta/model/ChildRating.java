package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Child_Rating_table")
@Entity
public class ChildRating {

	@Id
	@Column(name = "Idrat")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	@Column(name = "Evaluation_Title")
	@NotNull
	@Size(min= 3, max= 15)
	private String evaluationTitle;
	
	@Column
	@NotNull
	RaitingValues value;
	
	// connection between Child and ChildRating => ManyToOne
	@ManyToOne
	@JoinColumn(name = "Idch")
	private Child child;
	
	public ChildRating(String evaluationTitle, RaitingValues value, Child child){
		setEvaluationTitle(evaluationTitle);
		setValue(value);
		setChild(child);
	}
	
}
