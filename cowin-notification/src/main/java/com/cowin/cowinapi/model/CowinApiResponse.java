package com.cowin.cowinapi.model;

import java.util.List;

public class CowinApiResponse {

	private List<Session> sessions = null;

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "CowinApiResponse [sessions=" + sessions + "]";
	}
	
	
}
