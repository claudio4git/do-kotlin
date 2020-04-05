package br.com.jccf.application.task

import br.com.jccf.core.task.dto.TaskRequest
import br.com.jccf.core.task.dto.TaskResponse
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v1/tasks")
class TaskResource(
    private val taskResourceAdapter: TaskResourceAdapter
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(request: TaskRequest): TaskResponse {
        return taskResourceAdapter.create(request)
    }
}
