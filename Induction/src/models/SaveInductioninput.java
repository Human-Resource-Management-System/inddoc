package models;

import java.util.List;

public class SaveInductioninput {
	private Integer IndcId;
	private List<Integer> IndcEmofId;
	private String IndcDate;
	private int IndcProcessedAusrId;
	private String IndcStatus;

	public Integer getIndcId() {
		return IndcId;
	}

	public void setIndcId(Integer indcId) {
		IndcId = indcId;
	}

	public List<Integer> getIndcEmofId() {
		return IndcEmofId;
	}

	public void setIndcEmofId(List<Integer> indcEmofId) {
		IndcEmofId = indcEmofId;
	}

	public String getIndcDate() {
		return IndcDate;
	}

	public void setIndcDate(String indcDate) {
		IndcDate = indcDate;
	}

	public int getIndcProcessedAusrId() {
		return IndcProcessedAusrId;
	}

	public void setIndcProcessedAusrId(int indcProcessedAusrId) {
		IndcProcessedAusrId = indcProcessedAusrId;
	}

	public String getIndcStatus() {
		return IndcStatus;
	}

	public void setIndcStatus(String indcStatus) {
		IndcStatus = indcStatus;
	}

	// getters setters
}