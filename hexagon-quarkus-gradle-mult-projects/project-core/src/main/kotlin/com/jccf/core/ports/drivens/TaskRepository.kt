package com.jccf.core.ports.drivens

import com.jccf.core.entities.TaskEntity
import java.util.*

interface TaskRepository {
    fun save(entity: TaskEntity): UUID
}