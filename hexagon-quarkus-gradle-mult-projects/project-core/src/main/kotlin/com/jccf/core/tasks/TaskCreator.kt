package com.jccf.core.tasks

import com.jccf.core.entities.TaskEntity
import com.jccf.core.ports.drivens.TaskRepository
import java.util.*

class TaskCreator(
        private val taskRepository: TaskRepository
) {

    fun save(entity: TaskEntity): UUID {
        return taskRepository.save(entity)
    }

}