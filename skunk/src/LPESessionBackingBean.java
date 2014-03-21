import java.util.List;


public class LPESessionBackingBean {
private List<LPESession> lpeSessions;
private ChildPropertyTreeModel lpeSessionsTree = null;
private List<LPESessionDetail> lpeSessionDetail;
private LPESession selectedSessionLPE;
public LPESession getSelectedSessionLPE() {
	return selectedSessionLPE;
}
public void setSelectedSessionLPE(LPESession selectedSessionLPE) {
	this.selectedSessionLPE = selectedSessionLPE;
}
public List<LPESession> getLpeSessions() {
	return lpeSessions;
}
public void setLpeSessions(List<LPESession> lpeSessions) {
	this.lpeSessions = lpeSessions;
}
public ChildPropertyTreeModel getLpeSessionsTree() {
	return lpeSessionsTree;
}
public void setLpeSessionsTree(ChildPropertyTreeModel lpeSessionsTree) {
	this.lpeSessionsTree = lpeSessionsTree;
}
public List<LPESessionDetail> getLpeSessionDetail() {
	return lpeSessionDetail;
}
public void setLpeSessionDetail(List<LPESessionDetail> lpeSessionDetail) {
	this.lpeSessionDetail = lpeSessionDetail;
}



}
