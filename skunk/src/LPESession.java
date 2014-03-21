
public class LPESession {
	
		public LPESession() {
		super();
		// TODO Auto-generated constructor stub
	}
		private String name;
		private String id;
		private String status;
		private String startedOn;
		private String updatedOn;
		private String executionTime;
		private String message;
		private int alertEvent;
		private int errorRecord;
		private String type;
		private String workRepoName;
		private String agentName;
		private String odiUser;
		private String nextRun;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getStartedOn() {
			return startedOn;
		}
		public void setStartedOn(String startedOn) {
			this.startedOn = startedOn;
		}
		public String getUpdatedOn() {
			return updatedOn;
		}
		public void setUpdatedOn(String updatedOn) {
			this.updatedOn = updatedOn;
		}
		public String getExecutionTime() {
			return executionTime;
		}
		public void setExecutionTime(String executionTime) {
			this.executionTime = executionTime;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public int getAlertEvent() {
			return alertEvent;
		}
		public void setAlertEvent(int alertEvent) {
			this.alertEvent = alertEvent;
		}
		public int getErrorRecord() {
			return errorRecord;
		}
		public void setErrorRecord(int errorRecord) {
			this.errorRecord = errorRecord;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getWorkRepoName() {
			return workRepoName;
		}
		public void setWorkRepoName(String workRepoName) {
			this.workRepoName = workRepoName;
		}
		public String getAgentName() {
			return agentName;
		}
		public void setAgentName(String agentName) {
			this.agentName = agentName;
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
		public LPESession(String name, String id, String status,
				String startedOn, String updatedOn, String executionTime,
				String message, int alertEvent, int errorRecord, String type,
				String workRepoName, String agentName, String odiUser,
				String nextRun) {
			super();
			this.name = name;
			this.id = id;
			this.status = status;
			this.startedOn = startedOn;
			this.updatedOn = updatedOn;
			this.executionTime = executionTime;
			this.message = message;
			this.alertEvent = alertEvent;
			this.errorRecord = errorRecord;
			this.type = type;
			this.workRepoName = workRepoName;
			this.agentName = agentName;
			this.odiUser = odiUser;
			this.nextRun = nextRun;
		}
}
