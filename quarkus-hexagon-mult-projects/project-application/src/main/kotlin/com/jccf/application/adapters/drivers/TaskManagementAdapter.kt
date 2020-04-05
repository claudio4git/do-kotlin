package com.jccf.application.adapters.drivers

import com.jccf.application.adapters.drivens.TaskPostgreRepositoryAdapter
import com.jccf.core.entities.TaskEntity
import com.jccf.core.ports.drives.TaskManagement
import com.jccf.core.tasks.TaskCreator
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaskManagementAdapter(
        private val repository: TaskPostgreRepositoryAdapter
) : TaskManagement {

    override fun create(entity: TaskEntity): UUID {
        return TaskCreator(repository).save(entity)
    }

}