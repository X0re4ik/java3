package ru.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotNull
    @Size(min=1, max = 32, message = "uid must be at most 32 characters long")
    @NotBlank(message = "uid is mandatory")
    private String uid;

    @NotBlank(message = "operationUid is mandatory")
    @Size(min=1, max = 32, message = "operationUid must be at most 32 characters long")
    private String operationUid;

    private String systemName;

    @NotBlank(message = "systemTime is mandatory")
    private String systemTime;

    private String source;

    @Min(value = 1, message = "communicationId must be at least 1")
    @Max(value = 100000, message = "communicationId must be at most 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
    private int snsCode;
}
