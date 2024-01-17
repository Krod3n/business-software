package fr.a.factures.dto;

import java.sql.Date;

public class MonthTurnoverDTO {
	private Date month;
	private Double total;

	public MonthTurnoverDTO() {
		super();
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
