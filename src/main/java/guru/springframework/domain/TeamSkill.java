package guru.springframework.domain;

import guru.springframework.converters.Global;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Sravan
 */
@Entity
@Table(name = "Team_Skill")
public class TeamSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TEAM_ID", nullable = false)
    @Size(min = 1, max = Global.VARCHAR100)
    private String teamId;

    @Column(name = "SKILL", nullable = false)
    @Size(min = 1, max = Global.VARCHAR100)
    private String skill;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
