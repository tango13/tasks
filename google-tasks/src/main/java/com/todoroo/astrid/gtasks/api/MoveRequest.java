/**
 * Copyright (c) 2012 Todoroo Inc
 *
 * See the file "LICENSE" for the full license governing this code.
 */
package com.todoroo.astrid.gtasks.api;

import com.google.api.services.tasks.model.Task;

import java.io.IOException;
/**
 * Encapsulates a request to the api to change the ordering on the given task
 * @author Sam Bosley
 *
 */
public class MoveRequest {

    private final GtasksInvoker service;
    private String taskId;
    private final String destinationList;
    private String parentId;
    private String priorSiblingId;

    public MoveRequest(GtasksInvoker service, String taskId, String destinationList, String parentId, String priorSiblingId) {
        this.service = service;
        this.taskId = taskId;
        this.destinationList = destinationList;
        this.parentId = parentId;
        this.priorSiblingId = priorSiblingId;
    }

    public Task push() throws IOException {
        try {
            return executePush();
        } catch (IOException e) {
            recover();
            return executePush();
        }
    }

    public Task executePush() throws IOException {
        return service.moveGtask(destinationList, taskId, parentId, priorSiblingId);
    }

    protected void recover() {
        parentId = null;
        priorSiblingId = null;
    }
}
