package com.svencol.taskmanager.task.dto;

import jakarta.validation.constraints.Size;

public record TaskUpdate(
        @Size(min = 1, max = 200) String title,
        Boolean done
) {}
