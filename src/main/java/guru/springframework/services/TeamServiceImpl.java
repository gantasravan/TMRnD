package guru.springframework.services;

import guru.springframework.commands.ProductForm;
import guru.springframework.domain.Product;
import guru.springframework.domain.Task;
import guru.springframework.domain.Team;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.TaskRepository;
import guru.springframework.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public boolean insertTeamData(String fileName) {

        String csvFile = "D:\\workspace\\TMRnD\\csv_files\\csv_files\\" + fileName + "";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int count = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (count != 0) {
                    String[] teamArray = line.split(cvsSplitBy);
                    System.out.println("Team Name= " + teamArray[0] + "");
                    Team team = new Team();
                    String teamString = teamArray[0];
                    teamString = teamString.replaceAll("^\"|\"$", "");
                    team.setTeamId(teamString);
                    teamRepository.save(team);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }


}
