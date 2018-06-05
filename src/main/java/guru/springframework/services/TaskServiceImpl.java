package guru.springframework.services;

import guru.springframework.domain.Task;
import guru.springframework.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public boolean insertTaskData(String fileName) {

        String csvFile = "D:\\workspace\\TMRnD\\csv_files\\csv_files\\" + fileName + "";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int count = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (count != 0) {
                    String[] taskArray = line.split(cvsSplitBy);
                    System.out.println("Task Name= " + taskArray[0] + " and Skill Name " + taskArray[1] + " ");
                    Task task = new Task();
                    String taskString = taskArray[0];
                    taskString = taskString.replaceAll("^\"|\"$", "");
                    task.setTaskId(taskString);
                    String skillString = taskArray[1];
                    skillString = skillString.replaceAll("^\"|\"$", "");
                    task.setSkill(skillString);
                    taskRepository.save(task);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }


}
