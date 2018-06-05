package guru.springframework.services;

import guru.springframework.domain.Team;
import guru.springframework.domain.TeamSkill;
import guru.springframework.repositories.TeamRepository;
import guru.springframework.repositories.TeamSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class TeamSkillServiceImpl implements TeamSkillService {

    @Autowired
    private TeamSkillRepository teamSkillRepository;


    public boolean insertTeamSkillData(String fileName) {

        String csvFile = "D:\\workspace\\TMRnD\\csv_files\\csv_files\\" + fileName + "";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int count = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (count != 0) {
                    String[] teamArray = line.split(cvsSplitBy);
                    System.out.println("Task Name= " + teamArray[0] + " and Skill Name " + teamArray[1] + " ");
                    TeamSkill teamSkill = new TeamSkill();
                    String teamString = teamArray[0];
                    teamString = teamString.replaceAll("^\"|\"$", "");
                    teamSkill.setTeamId(teamString);
                    String skillString = teamArray[1];
                    skillString = skillString.replaceAll("^\"|\"$", "");
                    teamSkill.setSkill(skillString);
                    teamSkillRepository.save(teamSkill);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }


}
