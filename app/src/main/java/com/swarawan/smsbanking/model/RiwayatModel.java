package com.swarawan.smsbanking.model;

public class RiwayatModel {
	private int idRiwayat;
	private String riwayat, idBank, status;

	public int getIdRiwayat() {
		return idRiwayat;
	}

	public String getRiwayat() {
		return riwayat;
	}

	public void setRiwayat(String riwayat) {
		this.riwayat = riwayat;
	}

	public String getIdBank() {
		return idBank;
	}

	public void setIdBank(String idBank) {
		this.idBank = idBank;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
