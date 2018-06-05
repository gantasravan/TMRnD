package guru.springframework.converters;

import guru.springframework.services.TaskService;
import guru.springframework.services.TeamService;
import guru.springframework.services.TeamSkillService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
public class FileScannerServiceImpl implements FileScannerService {

    private static Logger LOG = Logger.getLogger(FileScannerServiceImpl.class);

    private Map<String, DirectoryMonitor> directoryMonitorMap = new HashMap<String, DirectoryMonitor>();

    @Autowired
    TeamService teamService;

    @Autowired
    TaskService taskService;

    @Autowired
    TeamSkillService teamSkillService;

    @PreDestroy
    public void tearDown() {
    }

    @PostConstruct
    public void initial() {

        LOG.debug("Loading batch jobs");


        // initialize one time only
        LOG.debug("Loading SAP batch jobs.");
        DirectoryMonitor monitorDirectory = new DirectoryMonitor(teamService, taskService, teamSkillService, "D:\\workspace\\TMRnD\\csv_files\\csv_files\\");
        directoryMonitorMap.put("tm", monitorDirectory);

        // start file scanner
        startFileScanner();
    }

    /**
     * can be used for forced start
     * executeScanner invokes and executes file processing
     */
    @Async
    public void executeScanner(String mod) throws Exception {
    }

    @Override
    public boolean startFileScanner() {
        LOG.debug("Start File Scanner");
        boolean status = false;

        try {
            Set<String> keySet = directoryMonitorMap.keySet();
            Iterator<String> itr = keySet.iterator();
            while (itr.hasNext()) {
                String jobName = itr.next();
                LOG.debug(" Start batch job for " + jobName);
                directoryMonitorMap.get(jobName).startDirectoryMonitoring();
            }
            status = true;
        } catch (Exception e) {
            LOG.error(" Error [" + e.getMessage() + "]", e);
        }
        return status;
    }

    @Override
    public void stopFileScanner() {
        LOG.debug("Stop File Scanner");
        try {
            Set<String> keySet = directoryMonitorMap.keySet();
            Iterator<String> itr = keySet.iterator();
            while (itr.hasNext()) {
                String jobName = itr.next();
                LOG.debug(" Stop batch job for " + jobName);
                directoryMonitorMap.get(jobName).stopDirectoryMonitoring();
            }
        } catch (Exception e) {
            LOG.error(" Error [" + e.getMessage() + "]", e);
        }
    }

}
