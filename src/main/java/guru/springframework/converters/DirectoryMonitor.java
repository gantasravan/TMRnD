package guru.springframework.converters;

import guru.springframework.services.TaskService;
import guru.springframework.services.TeamService;
import guru.springframework.services.TeamSkillService;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.log4j.Logger;

import java.io.File;

public class DirectoryMonitor {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(DirectoryMonitor.class);

    private String status = "N";

    /**
     * Interval 5 seconds.
     */
    private static final long interval = (1000 * 5);

    /**
     * Directories to watch.
     */
    private File directoryToWatch;

    /**
     * Directory change observers.
     */
    private DirectoryObserver directoryObserver;

    /**
     * Monitor/threads that frequently checks the directory changes.
     */
    private FileAlterationMonitor fileMonitor;

    /**
     * Constructor.
     */
    public DirectoryMonitor(TeamService teamService, TaskService taskService, TeamSkillService teamSkillService,
                            String directory) {
//        directory ="D:\\workspace\\TMRnD\\csv_files\\csv_files\\";
        LOG.info("Initialized watching directory and observers >>>>");
        directoryToWatch = new File(directory);

        // initiate observer
        directoryObserver = new DirectoryObserver(directoryToWatch, teamService, taskService, teamSkillService);
    }

    public void startDirectoryMonitoring() throws InterruptedException {
        try {
            /** File changes monitor class */
            fileMonitor = new FileAlterationMonitor(interval,
                    directoryObserver);
            /** Monitor starts */
            fileMonitor.start();

        } catch (Exception e) {
            try {
                fileMonitor.stop();
                LOG.info("File monitoring stopped due to exception >>>>>");
            } catch (Exception ex) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * Start the monitors.
     */
    public void stopDirectoryMonitoring() throws InterruptedException {
        LOG.info("File monitoring is stopped>>>>>>>>>>>>>>>>>" + directoryToWatch.getAbsolutePath());
        try {
            /** Monitor Stop */
            if (fileMonitor != null) {
                fileMonitor.stop();
            }

        } catch (Exception e) {
            try {
                if (fileMonitor != null)
                    fileMonitor.stop();
                LOG.info("File monitoring stopped due to exception >>>>>>>>>>>>>>>>>");
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return the directoryObserver
     */
    public DirectoryObserver getDirectoryObserver() {
        return directoryObserver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
