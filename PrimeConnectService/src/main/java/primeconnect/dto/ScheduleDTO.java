package primeconnect.dto;

import primeconnect.jb.ScheduleData;

public class ScheduleDTO {
	
	private ScheduleData scheduleData;
	
	public ScheduleDTO(ScheduleData scheduleData)
	{
		this.scheduleData = scheduleData;
	}
	
	public String getFirstName() {
		return scheduleData != null ? scheduleData.getFirstName() : null;
	}

	public String getLastName() {
		return scheduleData != null ? scheduleData.getLastName() : null;
	}

	public String getMiddleName() {
		return scheduleData != null ? scheduleData.getMiddleName() : null;
	}

	public Long getStartTime() {
		return scheduleData != null ? scheduleData.getStartTime().getTime() : null;
	}

	public Long getEndTime() {
		return scheduleData != null ? scheduleData.getEndTime().getTime() : null;
	}
	
	public String getProfession() {
		return scheduleData != null ? scheduleData.getProfession() : null;
	}
	
}
