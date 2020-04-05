package com.jccf.application.resources

import com.jccf.application.dtos.TaskRequest
import com.jccf.application.dtos.TaskResult
import com.jccf.application.services.TaskService
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v1/tasks")
class TaskRestResource {

    @Inject
    lateinit var taskService: TaskService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun save(request: TaskRequest): TaskResult {
        return taskService.create(request)
    }

}