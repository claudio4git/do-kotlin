package com.jccf.core.ports.drives

import com.jccf.core.entities.TaskEntity
import java.util.*

interface TaskManagement {
    fun create(entity: TaskEntity): UUID
}