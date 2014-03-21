import java.util.ArrayList;
import java.util.List;

/* $Header: emas/odi/jsrc/odi/OdiMgmtUiModel/src/oracle/sysman/emai/model/odi/TargetIncident.java nichouha_odi4/1 2012/10/24 22:31:53 nichouha Exp $ */

/* Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved. */

/*
   DESCRIPTION
    <short description of component this file declares/defines>

   PRIVATE CLASSES
    <list of private classes defined - with one-line descriptions>

   NOTES
    <other useful comments, qualifications, etc.>

   MODIFIED    (MM/DD/YY)
    nichouha    09/20/12 - Target Incidents bean created
    nichouha    09/20/12 - Creation
 */

/**
 *  @version $Header: emas/odi/jsrc/odi/OdiMgmtUiModel/src/oracle/sysman/emai/model/odi/TargetIncident.java nichouha_odi4/1 2012/10/24 22:31:53 nichouha Exp $
 *  @author  nichouha
 *  @since   release specific (what release of product did this appear in)
 */

public class TargetIncident 
{
    private String severity;
    private Integer id;
    private String summary;
    private String summaryNLSID;//NLSDI in metric collection defination has been prefixed with ODI_TGT (for target specifc alerts ie Agent) and ODI_NON_TGT (for no target specifc alerts ie. sessions LPE)
    private Integer criticalAlerts;
    private Integer warningAlerts;
    private String category;

    
    public TargetIncident()
    {
        super();
        
    }
    
    public TargetIncident(String iSeverity, Integer id, String iSummary, String iSummaryNLSID, Integer iCriticalAlerts, Integer iWarningAlerts, String iCategory)
    {
        this.severity = iSeverity;
        this.id = id;
        this.summary = iSummary;
        this.criticalAlerts = iCriticalAlerts;
        this.warningAlerts = iWarningAlerts;
        this.category = iCategory;
        this.summaryNLSID = iSummaryNLSID;
        
    }
    
    public void setSeverity(String severity)
    {
        this.severity = severity;
    }

    public String getSeverity()
    {
        return severity;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setSummaryNLSID(String summaryNLSID)
    {
        this.summaryNLSID = summaryNLSID;
    }

    public String getSummaryNLSID()
    {
        return summaryNLSID;
    }

    public void setCriticalAlerts(Integer criticalAlerts)
    {
        this.criticalAlerts = criticalAlerts;
    }

    public Integer getCriticalAlerts()
    {
        return criticalAlerts;
    }

    public void setWarningAlerts(Integer warningAlerts)
    {
        this.warningAlerts = warningAlerts;
    }

    public Integer getWarningAlerts()
    {
        return warningAlerts;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }
    
    public static void main (String [] args) {
    	List<TargetIncident> allIncidents = new ArrayList<TargetIncident>();
    	TargetIncident ti = new TargetIncident("CRITICAL", 1, "Status down", "ODI_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti1 = new TargetIncident("WARNING", 2, "Status down", "ODI_NON_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti2 = new TargetIncident("CRITICAL", 3, "Status down", "ODI_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti3 = new TargetIncident("CRITICAL", 4, "Status down", "ODI_NON_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti4 = new TargetIncident("CRITICAL", 5, "Status down", "ODI_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti5 = new TargetIncident("WARNING", 6, "Status down", "ODI_NON_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti6 = new TargetIncident("CRITICAL", 7, "Status down", "ODI_NON_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti7 = new TargetIncident("CRITICAL", 8, "Status down", "ODI_TGT_status_down", 0, 0,"Availability");
    	TargetIncident ti8 = new TargetIncident("WARNING", 9, "Status down", "ODI_TGT_status_down", 0, 0,"Availability");
    	allIncidents.add(ti);
    	allIncidents.add(ti1);
    	allIncidents.add(ti2);
    	allIncidents.add(ti3);
    	allIncidents.add(ti4);
    	allIncidents.add(ti5);
    	allIncidents.add(ti6);
    	allIncidents.add(ti7);
    	allIncidents.add(ti8);
    	
    	List<TargetIncident> tagIncidents = new ArrayList<TargetIncident>();
    	List<TargetIncident> lpeIncidents = new ArrayList<TargetIncident>();
    	for (TargetIncident tgtInc : allIncidents) {
    		if (tgtInc != null && tgtInc.getSummaryNLSID() != null && tgtInc.getSummaryNLSID().contains("ODI_TGT") ){
    			tagIncidents.add(tgtInc);
    		} else {
    			lpeIncidents.add(tgtInc);
    		}
    	}
    	for (TargetIncident tg : tagIncidents) {
    		System.out.println("Target Incidents "+tg.toString());
    	}
    	for (TargetIncident tg : lpeIncidents) {
    		System.out.println("LPE Session Incidents "+tg.toString());
    	}
    	
    	
    	
    	
    	
    	
    	
    }

	@Override
	public String toString() {
		return "TargetIncident [severity=" + severity + ", id=" + id
				+ ", summary=" + summary + ", summaryNLSID=" + summaryNLSID
				+ ", criticalAlerts=" + criticalAlerts + ", warningAlerts="
				+ warningAlerts + ", category=" + category + "]";
	}
}

