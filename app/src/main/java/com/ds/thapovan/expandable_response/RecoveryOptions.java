package com.ds.thapovan.expandable_response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RecoveryOptions{

	@SerializedName("workflowRules")
	private List<WorkflowRulesItem> workflowRules;

	@SerializedName("relationshipManagers")
	private List<RelationshipManagersItem> relationshipManagers;

	@SerializedName("caseStageLevel")
	private List<CaseStageLevelItem> caseStageLevel;

	@SerializedName("chequeFollowUpOutcome")
	private List<ChequeFollowUpOutcomeItem> chequeFollowUpOutcome;

	@SerializedName("courts")
	private List<CourtsItem> courts;

	@SerializedName("stations")
	private List<StationsItem> stations;

	@SerializedName("branches")
	private List<BranchesItem> branches;

	@SerializedName("ropFollowUpOutcome")
	private List<RopFollowUpOutcomeItem> ropFollowUpOutcome;

	@SerializedName("caseType")
	private List<CaseTypeItem> caseType;

	@SerializedName("debitCollectors")
	private List<DebitCollectorsItem> debitCollectors;

	@SerializedName("warningLetterStatus")
	private List<WarningLetterStatusItem> warningLetterStatus;

	@SerializedName("ppFollowUpOutcome")
	private List<PpFollowUpOutcomeItem> ppFollowUpOutcome;

	@SerializedName("stages")
	private List<StagesItem> stages;

	@SerializedName("followUpOutcome")
	private List<FollowUpOutcomeItem> followUpOutcome;

	@SerializedName("caseStageLevelStatus")
	private List<CaseStageLevelStatusItem> caseStageLevelStatus;

	public List<WorkflowRulesItem> getWorkflowRules(){
		return workflowRules;
	}

	public List<RelationshipManagersItem> getRelationshipManagers(){
		return relationshipManagers;
	}

	public List<CaseStageLevelItem> getCaseStageLevel(){
		return caseStageLevel;
	}

	public List<ChequeFollowUpOutcomeItem> getChequeFollowUpOutcome(){
		return chequeFollowUpOutcome;
	}

	public List<CourtsItem> getCourts(){
		return courts;
	}

	public List<StationsItem> getStations(){
		return stations;
	}

	public List<BranchesItem> getBranches(){
		return branches;
	}

	public List<RopFollowUpOutcomeItem> getRopFollowUpOutcome(){
		return ropFollowUpOutcome;
	}

	public List<CaseTypeItem> getCaseType(){
		return caseType;
	}

	public List<DebitCollectorsItem> getDebitCollectors(){
		return debitCollectors;
	}

	public List<WarningLetterStatusItem> getWarningLetterStatus(){
		return warningLetterStatus;
	}

	public List<PpFollowUpOutcomeItem> getPpFollowUpOutcome(){
		return ppFollowUpOutcome;
	}

	public List<StagesItem> getStages(){
		return stages;
	}

	public List<FollowUpOutcomeItem> getFollowUpOutcome(){
		return followUpOutcome;
	}

	public List<CaseStageLevelStatusItem> getCaseStageLevelStatus(){
		return caseStageLevelStatus;
	}
}