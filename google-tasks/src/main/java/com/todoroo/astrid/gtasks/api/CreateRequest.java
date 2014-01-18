/**
 * Copyright (c) 2012 Todoroo Inc
 *
 * See the file "LICENSE" for the full license governing this code.
 */
package com.todoroo.astrid.gtasks.api;

import com.google.api.services.tasks.model.Task;

import java.io.IOException;
/**
 * Encapsulates a request to the api to create a task on the remote server
 * @author Sam Bosley
 *
 */
public class CreateRequest {

    private final GtasksInvoker service;
    private final String listId;
    private final Task toUpdate;
    private String parent;
    private String priorSiblingId;

    public CreateRequest(GtasksInvoker service, String listId, Task toUpdate, String parent, String priorSiblingId) {
        this.service = service;
        this.listId = listId;
        this.toUpdate = toUpdate;
        this.parent = parent;
        this.priorSiblingId  = priorSiblingId;
    }

    public Task executePush() throws IOException {
        return service.createGtask(listId, toUpdate, parent, priorSiblingId);
    }
}
