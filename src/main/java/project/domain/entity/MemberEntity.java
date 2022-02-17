package project.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.security.MemberGrade;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class MemberEntity extends DateEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mno;
	@Column(nullable = false, unique = true)
	private String userId;
	@Column(nullable = false)
	private String pw;
	@Column(nullable = false)
	private String name;
	
	
	//멤버롤
	@Enumerated(EnumType.STRING) //DB에 저장시 String으로
	@ElementCollection(fetch = FetchType.EAGER)
	@Builder.Default
	private Set<MemberGrade> gradeSet = new HashSet<>();
	
	public void addRole(MemberGrade grade) {
		gradeSet.add(grade);
	}
	
	
	
}
