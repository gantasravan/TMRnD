/**
 * Copyright (c) {2011} {meter@rbtsb.com} {
 * individual contributors as indicated by the @authors tag}.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Private License v1.0
 * which accompanies this distribution, and is available at
 * http://www.rbtsb.com
 */
package guru.springframework.converters;

import guru.springframework.services.TaskService;
import guru.springframework.services.TeamService;
import guru.springframework.services.TeamSkillService;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.Serializable;

/**
 * @author Dil Nawaz
 */
public class DirectoryObserver extends FileAlterationObserver implements
        Serializable {

    /**
     * log Injected.
     */
    private static final Logger LOG = Logger.getLogger(DirectoryObserver.class);

    /**
     * Serial Id.
     */
    private static final long serialVersionUID = 7402987010021078896L;

    /**
     * File Listener class
     */
    private DirectoryListener listener;

    private static String LOGGING_PREFIX = "Directory Observer Logging - ";

    private TeamService teamService;

    private TaskService taskService;

    private TeamSkillService teamSkillService;

    /**
     * Constructor.
     */
    public DirectoryObserver(File directory, TeamService teamService, TaskService taskService, TeamSkillService teamSkillService) {
//        File directory2 = new File("D:\\workspace\\TMRnD\\csv_files\\csv_files\\");
        super(directory);

        LOG.debug(LOGGING_PREFIX + "Path: " + directory);
        this.teamService = teamService;
        this.taskService = taskService;
        this.teamSkillService = teamSkillService;
        // Add listeners
        listener = new DirectoryListener();
        super.addListener(listener);
    }


    /**
     * Inner class for Listener Adaptor.
     *
     * @author Dil Nawaz
     */
    class DirectoryListener extends FileAlterationListenerAdaptor {

        public DirectoryListener() {

        }

        @Override
        public void onFileCreate(final File file) {
            boolean validFile = false;
            try {

                System.out.println("File Name--" + file.getName());
                if (file.exists()) {

                    LOG.debug(LOGGING_PREFIX + "processing onFileCreate - File: " + file.getAbsolutePath());
                    try {

                        long size = file.length();
                        Thread.sleep(1000);
                        long newSize = file.length();
                        System.out.println("File " + file.getName() + " Old Size first time--" + size);
                        System.out.println("File " + file.getName() + " New Size first time--" + newSize);

                        if (size < newSize) {
                            while (size < newSize) {
                                System.out.println("File " + file.getName() + "  size and newsize are not same ");

                                System.out.println("downloading...File " + file.getName() + " ");
                                size = file.length();
                                Thread.sleep(1000);
                                newSize = file.length();
                                System.out.println("File " + file.getName() + "  Old Size second time--" + size);
                                System.out.println("File " + file.getName() + "  New Size second time--" + newSize);
                                if (size == newSize) {
                                    validFile = true;
                                }
                            }
                        } else {
                            if (size == newSize) {
                                System.out.println("File " + file.getName() + "  size and newsize are same ");
                                validFile = true;
                                System.out.println("File " + file.getName() + " Downloaded");
                                System.out.println("Fianl File Size: " + file.getName() + " " + newSize);
                            }

                        }

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (validFile) {
                    System.out.println("ThreadName " + Thread.currentThread());
                    System.out.println("File " + file.getName() + "  is valid File ");
                    if (file.getName().equals("team.csv")) {
                        teamService.insertTeamData(file.getName());
                        file.delete();
                    }
                    if (file.getName().equals("task.csv")) {
                        taskService.insertTaskData(file.getName());
                        file.delete();
                    }
                    if (file.getName().equals("team_skill.csv")) {
                        teamSkillService.insertTeamSkillData(file.getName());
                        file.delete();
                    }

                }
            } catch (Exception e) {
                LOG.error(" Error [" + e.getMessage() + "]", e);
            }

            try {
                LOG.debug(">>>>>>>>>>>>> Process loadSapDirectoryListings");
            } catch (Exception e) {
                LOG.error(" Error [" + e.getMessage() + "]", e);
            }

        }

        @Override
        public void onFileDelete(final File file) {
            if (!"dummy".equals(file.getName())) {
                LOG.info("File Deleted with File name ::" + file.getName());
            }
            try {
                LOG.debug(">>>>>>>>>>>>> Process loadSapDirectoryListings");
            } catch (Exception e) {
                LOG.error(" Error [" + e.getMessage() + "]", e);
            }
        }

        @Override
        public void onFileChange(final File file) {
            if (file.getName().equalsIgnoreCase("")) {
                file.delete();
            }

            LOG.info("File Changed with File name ::" + file.getName());

            try {
                LOG.debug(">>>>>>>>>>>>> Process loadSapDirectoryListings");
            } catch (Exception e) {
                LOG.error(" Error [" + e.getMessage() + "]", e);
            }
        }

        public void onStart(final DirectoryObserver directoryObserver) {
            LOG.info("From onStart <<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");

        }

        public void onStop(final DirectoryObserver directoryObserver) {
            LOG.info("From onStop <<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
        }
    }

}
