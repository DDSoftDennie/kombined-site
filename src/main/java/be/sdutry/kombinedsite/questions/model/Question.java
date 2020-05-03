package be.sdutry.kombinedsite.questions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question", schema = "kombined")
@Entity
@Builder
public class Question {
	@Id
	@Column(name = "id", insertable= false, updatable= false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Length(max = 256)
	private QuestionType questionType;
	@NotNull
	@Length(max = 4000)
	private String question;
}
