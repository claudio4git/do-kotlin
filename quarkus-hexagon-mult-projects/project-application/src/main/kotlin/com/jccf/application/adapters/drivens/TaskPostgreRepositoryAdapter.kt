package com.jccf.application.adapters.drivens

import com.jccf.core.entities.TaskEntity
import com.jccf.core.ports.drivens.TaskRepository
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaskPostgreRepositoryAdapter : TaskRepository {

    override fun save(entity: TaskEntity): UUID {
        return UUID.randomUUID()
    }

}