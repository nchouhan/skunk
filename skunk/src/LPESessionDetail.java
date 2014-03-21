import java.util.List;


public class LPESessionDetail {
private String name;
private String agentName;
private int errorRecord;
private String sourceCode;
private String targetCodel;
private String message;
private String stepTaskType;
private String workRepoName;
private String odiUser;
private String nextRun;
private String startDate;
private String endDate;
private int duration;
private String updates;
private String deletes;
private List<LPESessionDetail> childSession;
public List<LPESessionDetail> getChildSession() {
	return childSession;
}
public void setChildSession(List<LPESessionDetail> childSession) {
	this.childSession = childSession;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAgentName() {
	return agentName;
}
public LPESessionDetail(String name, String agentName, int errorRecord,
		String sourceCode, String targetCodel, String message,
		String stepTaskType, String workRepoName, String odiUser,
		String nextRun, String startDate, String endDate, int duration,
		String updates, String deletes) {
	super();
	this.name = name;
	this.agentName = agentName;
	this.errorRecord = errorRecord;
	this.sourceCode = sourceCode;
	this.targetCodel = targetCodel;
	this.message = message;
	this.stepTaskType = stepTaskType;
	this.workRepoName = workRepoName;
	this.odiUser = odiUser;
	this.nextRun = nextRun;
	this.startDate = startDate;
	this.endDate = endDate;
	this.duration = duration;
	this.updates = updates;
	this.deletes = deletes;
}
public void setAgentName(String agentName) {
	this.agentName = agentName;
}
public int getErrorRecord() {
	return errorRecord;
}
public void setErrorRecord(int errorRecord) {
	this.errorRecord = errorRecord;
}
public String getSourceCode() {
	return sourceCode;
}
public void setSourceCode(String sourceCode) {
	this.sourceCode = sourceCode;
}
public String getTargetCodel() {
	return targetCodel;
}
public void setTargetCodel(String targetCodel) {
	this.targetCodel = targetCodel;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getStepTaskType() {
	return stepTaskType;
}
public void setStepTaskType(String stepTaskType) {
	this.stepTaskType = stepTaskType;
}
public String getWorkRepoName() {
	return workRepoName;
}
public void setWorkRepoName(String workRepoName) {
	this.workRepoName = workRepoName;
}
public String getOdiUser() {
	return odiUser;
}
public void setOdiUser(String odiUser) {
	this.odiUser = odiUser;
}
public String getNextRun() {
	return nextRun;
}
public void setNextRun(String nextRun) {
	this.nextRun = nextRun;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getUpdates() {
	return updates;
}
public void setUpdates(String updates) {
	this.updates = updates;
}
public String getDeletes() {
	return deletes;
}
public void setDeletes(String deletes) {
	this.deletes = deletes;
}


}
