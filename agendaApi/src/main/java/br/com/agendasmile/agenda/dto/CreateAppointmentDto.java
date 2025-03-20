package br.com.agendasmile.agenda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class CreateAppointmentDto implements Serializable {

    @JsonProperty("title")
    @NotBlank
    private String title;

    @JsonProperty("description")
    @NotBlank
    private String description;

    @JsonProperty("type")
    @NotBlank
    private String type;

    @JsonProperty("start_datetime")
    @NotBlank
    private String startTimeTime;

    @JsonProperty("end_datetime")
    @NotBlank
    private String endDateTime;

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }

    public String getStartDateTime() {
        return this.startTimeTime;
    }

    public String getEndDateTime() {
        return this.endDateTime;
    }
}
