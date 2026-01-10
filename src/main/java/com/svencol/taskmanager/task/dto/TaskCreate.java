package com.svencol.taskmanager.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskCreate(
        @NotBlank @Size(max = 200) String title
) {}
