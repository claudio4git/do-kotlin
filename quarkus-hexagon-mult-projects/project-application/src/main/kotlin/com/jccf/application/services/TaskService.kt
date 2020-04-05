package com.jccf.application.services

import com.jccf.application.dtos.TaskRequest
import com.jccf.application.dtos.TaskResult
import com.jccf.core.entities.TaskEntity
import com.jccf.core.ports.drives.TaskManagement
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaskService(
        private val taskManagement: TaskManagement
) {

    fun create(request: TaskRequest): TaskResult {
        val entity = TaskEntity(request.name)
        return TaskResult(taskManagement.create(entity))
    }

}