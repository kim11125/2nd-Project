package project.domain.entity.board;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.domain.entity.DateEntity;
import project.domain.entity.member.MemberEntity;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class BoardEntity extends DateEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	
	
	@JoinColumn(name = "mno")
	@ManyToOne(cascade = CascadeType.ALL)
	private MemberEntity member;
}
