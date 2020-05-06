package be.sdutry.kombinedsite.gettingtoknow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "getting_to_know_question", schema = "kombined")
@Entity(name = "gettingToKnowQuestion")
@Builder
public class Question {
	@Id
	@Column(name = "id", insertable= false, updatable= false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String question;
}
